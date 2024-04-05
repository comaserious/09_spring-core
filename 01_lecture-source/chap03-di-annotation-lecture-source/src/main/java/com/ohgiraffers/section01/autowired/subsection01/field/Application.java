package com.ohgiraffers.section01.autowired.subsection01.field;

import com.ohgiraffers.section01.autowired.common.BookDTO;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.List;

public class Application {

    public static void main(String[] args) {

        /*필기.
        *   @Autowired
        *       의존성을 주입할 때 사용되는 대표적인 어노테이션
        *       의존성을 주입하는 방법은 3가지 방법이 있다
        *       1. 필드 주입 - 20%
        *       2. 생성자 주입 - 80%
        *       3. setter 주입 - 거의 사용하지 않는다*/

        ApplicationContext context = new AnnotationConfigApplicationContext("com.ohgiraffers.section01");

        BookService bookService = context.getBean("serviceField",BookService.class);

        List<BookDTO> books = bookService.selectAllBooks();
        for(BookDTO book : books){
            System.out.println("book : "+book);
        }

        BookDTO book = bookService.searchBookBySequence(1);
        System.out.println(book);
    }
}
