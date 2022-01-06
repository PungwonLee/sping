package com.fastcampus.jpa.bookmanager.repository;

import com.fastcampus.jpa.bookmanager.domain.Book;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class BookRepositoryTest {
    @Autowired
    private BookRepository bookRepository;

    @Test
    void bookTest(){
        Book book = new Book();
        book.setName("Jpa 초격차");
        book.setAuthorId(1L);
        book.setPublisherId(1L);

        Book save = bookRepository.save(book);
        System.out.println(save);
        save.setId(2L);
        save=bookRepository.save(book);
        System.out.println(save);
    }
}