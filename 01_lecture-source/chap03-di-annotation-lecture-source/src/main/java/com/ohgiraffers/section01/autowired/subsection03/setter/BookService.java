package com.ohgiraffers.section01.autowired.subsection03.setter;

import com.ohgiraffers.section01.autowired.common.BookDAO;
import com.ohgiraffers.section01.autowired.common.BookDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("ServiceSetter")
public class BookService {

    private BookDAO bookDAO;

    @Autowired
    public void setBookDAO(BookDAO bookDAO){
        this.bookDAO=bookDAO;

    }

    public List<BookDTO> selectAllBooks(){
        return bookDAO.selectBookList();
    }
    public BookDTO selectBookBySequence(int sequence){
        return  bookDAO.selectOne(sequence);
    }

    //Autowired 의 경우
    // MVS 간 연결에 유용하다
    //다만 repository 같이 값을 집어 넣어야하는 인스턴스의 경우
    // Autowired 를 쓰기 힘들다
    //왜냐하면 Autowired는 의존성 부여를 하기만 하지
    //값을 집어넣을수가 없기 때문이다
     // 따라서 Autowired는 단순히 클래스간 연결을 위해 사용하는것이 바람직할것이다

}
