package com.example.restaurant.wishList.service;

import com.example.restaurant.naver.NaverClient;
import com.example.restaurant.naver.dto.SearchImageReq;
import com.example.restaurant.naver.dto.SearchLocalReq;
import com.example.restaurant.wishList.dto.WishListDto;
import com.example.restaurant.wishList.entity.WishListEntity;
import com.example.restaurant.wishList.repository.WishListRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class WishListService {

    private final NaverClient naverClient;

    private final WishListRepository wishListRepository;

    public WishListDto search(String query){
        //지역검색

        var searchLocalReq=new SearchLocalReq();
        searchLocalReq.setQuery(query);

        var searchLocalRes = naverClient.localSearch(searchLocalReq);

        if(searchLocalRes.getTotal()>0){
            //이미지가 있을때 첫번째 아이템 겟
            var localItem=searchLocalRes.getItems().stream().findFirst().get();

            //괄호가 쳐저있는 검색 삭제 정규식
            var imageQuery =localItem.getTitle().replaceAll("<[^>]*>","");
            var searchImageReq =new SearchImageReq();
            searchImageReq.setQuery(imageQuery);

            //이미지검색
            var searchImageRes= naverClient.imageSearch(searchImageReq);

            if(searchImageRes.getTotal()>0){
                var imageItem= searchImageRes.getItems().stream().findFirst().get();
                //결과를 만들어 리턴
                var result = new WishListDto();
                result.setTitle(localItem.getTitle());
                result.setCategory(localItem.getCategory());
                result.setAddress(localItem.getAddress());
                result.setRoadAddress(localItem.getRoadAddress());
                result.setHomePageLink(localItem.getLink());
                result.setImageLink(imageItem.getLink());

                return result;


            }

        }
        return new WishListDto();

    }

    public WishListDto add(WishListDto wishListDto) {
        var entity=dtoToEntity(wishListDto);
        var saveEntity=wishListRepository.save(entity);
        return entityToDto(saveEntity);
    }

    private WishListEntity dtoToEntity(WishListDto wishListDto){
        var entity= new WishListEntity();
        entity.setIndex(wishListDto.getIndex());
        entity.setTitle(wishListDto.getTitle());
        entity.setCategory(wishListDto.getCategory());
        entity.setAddress(wishListDto.getAddress());
        entity.setRoadAddress(wishListDto.getRoadAddress());
        entity.setHomePageLink(wishListDto.getHomePageLink());
        entity.setImageLink(wishListDto.getImageLink());
        entity.setVisit(wishListDto.isVisit());
        entity.setVisitCount(wishListDto.getVisitCount());
        entity.setLastVisitData(wishListDto.getLastVisitData());
        return entity;
    }

    private WishListDto entityToDto(WishListEntity wishListEntity){
        var dto= new WishListDto();
        dto.setIndex(wishListEntity.getIndex());
        dto.setTitle(wishListEntity.getTitle());
        dto.setCategory(wishListEntity.getCategory());
        dto.setAddress(wishListEntity.getAddress());
        dto.setRoadAddress(wishListEntity.getRoadAddress());
        dto.setHomePageLink(wishListEntity.getHomePageLink());
        dto.setImageLink(wishListEntity.getImageLink());
        dto.setVisit(wishListEntity.isVisit());
        dto.setVisitCount(wishListEntity.getVisitCount());
        dto.setLastVisitData(wishListEntity.getLastVisitData());
        return dto;
    }

    public List<WishListDto> findAll() {

        return wishListRepository.findAll()
                .stream()
                .map(it -> entityToDto(it))
                .collect(Collectors.toList());
    }

    public void delete(int index) {
        wishListRepository.deleteById(index);
    }

    public void addVisit(int index){
        var wishItem=wishListRepository.findById(index);
        if(wishItem.isPresent()){
            var item=wishItem.get();

            item.setVisit(true);
            item.setVisitCount(item.getVisitCount()+1);
        }
    }



}
