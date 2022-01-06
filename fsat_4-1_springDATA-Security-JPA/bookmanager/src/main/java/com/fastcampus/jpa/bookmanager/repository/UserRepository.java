package com.fastcampus.jpa.bookmanager.repository;

import com.fastcampus.jpa.bookmanager.domain.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Set;

public interface UserRepository extends JpaRepository<User,Long> {

   List<User> findByName(String name);

   User findByEmail(String email);
   User getByEmail(String email);
   User readByEmail(String email);
   User queryByEmail(String email);
   User searchByEmail(String email);
   User streamByEmail(String email);
   User findUserByEmail(String email);
   User findSomeThingByEmail(String email);

   List<User> findFirst1ByName(String name);
   List<User> findTop1ByName(String name);

   List<User> findByEmailAndName(String email,String name);
   List<User> findByEmailOrName(String email,String name);

   List<User> findByCreatedAtAfter(LocalDateTime createAt);
   List<User> findByIdAfter(Long id);

   // yesterday보다 뒤에 있는 날자(초과)
   List<User> findByCreatedAtGreaterThan(LocalDateTime yesterday);
   // yesterday보다  '' (이상)
   List<User> findByCreatedAtGreaterThanEqual(LocalDateTime yesterday);
   //Less는 미만 ThanEqual붙이면 이하
   List<User> findByCreatedAtLessThanEqual(LocalDateTime yesterday);


   //between은   왼쪽값<= 비교값 <= 오른쪽값 이다
   List<User> findByCreatedAtBetween(LocalDateTime yesterday,LocalDateTime tomorrow);
   List<User> findByIdBetween(Long id1,Long id2);
   List<User> findByIdGreaterThanEqualAndIdLessThanEqual(Long id1,Long id2);

   List<User> findByIdIsNotNull();

   List<User> findByNameStartingWith(String name); //시작 부분 name 같은지
   List<User> findByNameEndingWith(String name);   // 끝부분 name 같은지
   List<User> findByNameContains(String name);     // 밑의 Like와 같은 역활 % % 자동 주입

   List<User> findByNameLike(String name);

   Set<User> findUserByName(String name);
   Set<User> findUserByNameIs(String name);
   Set<User> findUserByNameEquals(String name);
   //위의 3개는 동일하다 Is와 Equals는 가독성을 위해 쓰는 것


   List<User> findLast1ByName(String name);  //의도 하던대로 안됨 라스트 1까지의 모든게 조회됨
   List<User> findTop1ByNameOrderByIdDesc(String name);  //위의 의도대로 됨
   List<User> findFirstByNameOrderByIdDescEmailAsc(String name);  //아이디의 역순 이메일의 정순 정렬

   List<User> findFirstByName(String name, Sort sort);

   Page<User> findByName(String name, Pageable pageable);


}
