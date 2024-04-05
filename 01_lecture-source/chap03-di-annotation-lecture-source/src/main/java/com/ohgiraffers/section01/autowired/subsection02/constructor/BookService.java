package com.ohgiraffers.section01.autowired.subsection02.constructor;

import com.ohgiraffers.section01.autowired.common.BookDAO;
import com.ohgiraffers.section01.autowired.common.BookDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("ServiceConstructor")
public class BookService {

    /*필기.
    *   1. 필드 주입은 의존성이 있는 객체가 생성되지 않아도 객체의 생성이 가능하다
    *      따라서 메소드가 호출 될 때 (런타임 에러) 오류가 발생하게 된다
    *      생성자 주입은 의존성이 잇는 객체가 생성되지 않으면
    *      객체의 생성이 불가능하여 어플리케이션 실행시점에 오류(컴파일에러) 가 발생한다
    *   2. 필드에 final 키워드를 사용할 수 있기 때문에 객체의 생성 이후
    *      의존성을 변경 할 수 없어 안정성이 보장된다
    *   3. 코드의 가독성이 좋다
    * */


    //생성자를 통한 초기화를 하기 때문에 final 을 사용할수 있다. 객체의 불변성을 보장할 수 있다
    private final BookDAO bookdao;
    @Autowired
    public BookService(BookDAO bookDAO){
        this.bookdao = bookDAO;
    }

    public List<BookDTO> selectAllBooks(){

        return bookdao.selectBookList();
    }
    public BookDTO searchBookBySequence(int sequence){
        return bookdao.selectOne(sequence);
    }
}
