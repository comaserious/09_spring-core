package com.ohgiraffers.section01.autowired.subsection01.field;

import com.ohgiraffers.section01.autowired.common.BookDAO;
import com.ohgiraffers.section01.autowired.common.BookDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

//@Component
//@Component 의 세분화 어노테이션으로 Service 계층에 사용된다
@Service("serviceField")
public class BookService {

    @Autowired
    private BookDAO bookDAO;

    public List<BookDTO> selectAllBooks(){
        return bookDAO.selectBookList();
    }
    public BookDTO searchBookBySequence(int sequence){
        return bookDAO.selectOne(sequence);
    }
}
