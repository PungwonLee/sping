package com.fastcampus.jpa.bookmanager.repository;

import com.fastcampus.jpa.bookmanager.domain.Gender;
import com.fastcampus.jpa.bookmanager.domain.User;
import com.fastcampus.jpa.bookmanager.domain.UserHistory;
import org.assertj.core.util.Lists;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;

import javax.transaction.Transactional;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.data.domain.ExampleMatcher.GenericPropertyMatchers.endsWith;

@SpringBootTest//스프링 컨텍스트를 로딩해서 테스트하겠다
class UserRepositoryTest {
    @Autowired
    private UserRepository userRepository;@Autowired
    private UserHistoryRepository userHistoryRepository;

    @Test
    void crud() {//create, update, read, delete
        ExampleMatcher matcher = ExampleMatcher.matching()
                .withIgnorePaths("name")
                .withMatcher("email", endsWith());

        Example<User> example = Example.of(new User("ma","fastcampus.com"), matcher);
        userRepository.findAll(example).forEach(System.out::println);
    }

    @Test
    void select(){
        System.out.println(userRepository.findByName("dennis"));

        System.out.println("findByEmail : "+userRepository.findByEmail("martin@fastcampus.com"));
        System.out.println("getByEmail : "+userRepository.getByEmail("martin@fastcampus.com"));
        System.out.println("readByEmail : "+userRepository.readByEmail("martin@fastcampus.com"));
        System.out.println("queryByEmail : "+userRepository.queryByEmail("martin@fastcampus.com"));
        System.out.println("searchByEmail : "+userRepository.searchByEmail("martin@fastcampus.com"));
        System.out.println("streamByEmail : "+userRepository.streamByEmail("martin@fastcampus.com"));
        System.out.println("findUserByEmail : "+userRepository.findUserByEmail("martin@fastcampus.com"));

        System.out.println("findFirst1ByName : "+userRepository.findFirst1ByName("martin"));
        System.out.println("findTop1ByName : "+userRepository.findTop1ByName("martin"));

        System.out.println("findByEmailAndName : "+userRepository.findByEmailAndName("martin@fastcampus.com","martin"));

        System.out.println("findByCreatedAtAfter : "+userRepository.findByCreatedAtAfter(LocalDateTime.now().minusDays(1)));

        System.out.println("findByIdAfter : "+userRepository.findByIdAfter(1L));


        System.out.println("findByCreatedAtGreaterThan : " + userRepository.findByCreatedAtGreaterThan(LocalDateTime.now().minusDays(1)));
        System.out.println("findByCreatedAtGreaterThanEqual : " + userRepository.findByCreatedAtGreaterThanEqual(LocalDateTime.now().minusDays(1)));

        System.out.println("findByCreatedAtBetween : " + userRepository.findByCreatedAtBetween(LocalDateTime.now().minusDays(1),LocalDateTime.now().plusDays(1)));
        System.out.println("findByIdBetween : " + userRepository.findByIdBetween(1L,3L));

        System.out.println("findByIdIsNotNull : " + userRepository.findByIdIsNotNull());

        System.out.println("findByNameStartingWith : " + userRepository.findByNameStartingWith("mar"));
        System.out.println("findByNameEndingWith : " + userRepository.findByNameEndingWith("tin"));
        System.out.println("findByNameContains : " + userRepository.findByNameContains("art"));
        System.out.println("findByNameLike : " + userRepository.findByNameLike("%mar%"));

    }


    @Test
    void pagingAndSortingTest(){
        System.out.println("findTop1ByName : "+ userRepository.findTop1ByName("martin"));
        System.out.println("findLast1ByName : "+ userRepository.findLast1ByName("martin"));
        System.out.println("findTop1ByNameOrderByIdDesc : "+ userRepository.findTop1ByNameOrderByIdDesc("martin"));
        System.out.println("findFirstByNameOrderByIdDescEmailAsc : "+ userRepository.findFirstByNameOrderByIdDescEmailAsc("martin"));
        System.out.println("findFirstByNameWithSortParams : "+ userRepository.findFirstByName("martin",Sort.by(Sort.Order.desc("id"), Sort.Order.asc("email"))));
        System.out.println("findByName : "+ userRepository.findByName("martin",
                PageRequest.of(0,2,Sort.by(Sort.Order.desc("id")))).getContent());

    }

    @Test
    void enumTest(){
    }

    @Test
    void listenerTest(){
        User user = new User();
        user.setEmail("martin2@fastcampus.com");
        user.setName("martin");

        userRepository.save(user);

    }

    @Test
    void prePersistTest(){
        User user = new User();
        user.setEmail("martin2@fastcampus.com");
        user.setName("martin");
        userRepository.save(user);

        System.out.println(userRepository.findById(1L).orElseThrow(RuntimeException::new));
    }

    @Test
    void preUpdateTest(){
        User user = userRepository.findById(1L).orElseThrow(RuntimeException::new);

        user.setEmail("martin2@fastcampus.com");
        user.setName("martin");
        userRepository.save(user);

        System.out.println(userRepository.findById(1L).orElseThrow(RuntimeException::new));
    }

    @Test
    @Transactional
    void userHistoryTest(){
        User user = new User();
        user.setEmail("martin-new@fastcampus.com");
        user.setName("martin-new");

        userRepository.save(user);
        user.setName("martin-new-new");



        userHistoryRepository.findAll().forEach(System.out::println);
    }



    @Test
    void userRelationTest(){
        User user = new User();
        user.setName("david");
        user.setEmail("david@fastcampus.com");
        user.setGender(Gender.MALE);

        userRepository.save(user);

        user.setName("daniel");
        userRepository.save(user);

        user.setEmail("daniel@fastcampus.com");
        userRepository.save(user);

        userHistoryRepository.findAll().forEach(System.out::println);
//        List<UserHistory> result = userHistoryRepository.findByUserId(
//                userRepository.findByEmail("daniel@fastcampus.com").getId()); 
        List<UserHistory> result = userRepository.findByEmail("daniel@fastcampus.com").getUserHistories();

        result.forEach(System.out::println);

        System.out.println("UserHistory.getUser(): "+userHistoryRepository.findAll().get(0));
    }


    @BeforeEach
    void init(){
        userRepository.save(User.builder().id(1L).name("martin").email("martin@fastcampus.com").build());
        userRepository.save(User.builder().id(2L).name("dennis").email("dennis@fastcampus.com").build());
        userRepository.save(User.builder().id(3L).name("sophia").email("sophia@naver.com").build());
        userRepository.save(User.builder().id(4L).name("james").email("james@naver.com").build());
        userRepository.save(User.builder().id(5L).name("martin").email("martin@another.com").build());
//

    }


}