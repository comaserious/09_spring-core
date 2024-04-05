package com.ohgiraffers.section01.autowired.common;

import java.util.List;

public interface BookDAO {

    List<BookDTO> selectBookList();
    BookDTO selectOne(int sequence);

}
