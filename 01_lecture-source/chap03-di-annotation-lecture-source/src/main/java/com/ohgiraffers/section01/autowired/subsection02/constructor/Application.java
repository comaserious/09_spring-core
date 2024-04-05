package com.ohgiraffers.section01.autowired.subsection02.constructor;


import com.ohgiraffers.section01.autowired.common.BookDTO;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.List;

public class Application {

    public static void main(String[] args) {

        ApplicationContext context = new AnnotationConfigApplicationContext("com.ohgiraffers.section01");
        BookService bookService = context.getBean("ServiceConstructor", BookService.class);

        List<BookDTO> books = bookService.selectAllBooks();
        for(BookDTO b  : books){
            System.out.println("book : "+b);
        }

        BookDTO book = bookService.searchBookBySequence(2);
        System.out.println(book);
    }
}
