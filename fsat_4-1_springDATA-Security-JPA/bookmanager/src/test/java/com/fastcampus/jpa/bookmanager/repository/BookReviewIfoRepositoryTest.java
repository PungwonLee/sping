package com.fastcampus.jpa.bookmanager.repository;

import com.fastcampus.jpa.bookmanager.domain.Book;
import com.fastcampus.jpa.bookmanager.domain.BookReviewInfo;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.transaction.Transactional;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class BookReviewIfoRepositoryTest {

    @Autowired
    private BookReviewIfoRepository bookReviewIfoRepository;
    @Autowired
    private BookRepository bookRepository;

    @Test
    void crudTest() {
        BookReviewInfo bookReviewInfo = new BookReviewInfo();
//        bookReviewInfo.setBookId(1L);
        bookReviewInfo.setAverageReviewScore(4.5f);
        bookReviewInfo.setReviewCount(2);

        bookReviewIfoRepository.save(bookReviewInfo);

        System.out.println("bookReviewIfoRepository.findAll() = " + bookReviewIfoRepository.findAll());

    }

    @Test
    void crudTest2() {

        givenBookReview();

        Book result = bookReviewIfoRepository
                        .findById(1L)
                        .orElseThrow(RuntimeException::new)
                        .getBook();

        System.out.println("result = " + result);

        Book book = bookRepository.findById(1L).orElseThrow(RuntimeException::new);
        System.out.println("book = " + book);
    }

    private Book givenBook() {
        Book book = new Book();
        book.setName("Jpa 초격차 패키지");
        book.setAuthorId(1L);
        book.setPublisherId(1L);

        Book save = bookRepository.save(book);

        System.out.println("bookfindAll = " + bookRepository.findAll());
        return save;
    }

    private void givenBookReview() {
        BookReviewInfo bookReviewInfo = new BookReviewInfo();
        bookReviewInfo.setBook(givenBook());
        bookReviewInfo.setAverageReviewScore(4.5f);
        bookReviewInfo.setReviewCount(2);

        bookReviewIfoRepository.save(bookReviewInfo);

        System.out.println("bookReviewIfoRepository.findAll() = " + bookReviewIfoRepository.findAll());

    }
}