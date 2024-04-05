package com.ohgiraffers.section01.autowired.common;

import org.springframework.stereotype.Repository;

import java.util.*;

@Repository("bookDao")
public class BookDAOImpl implements BookDAO{

    private final Map<Integer,BookDTO> bookList;
    public BookDAOImpl(){
        bookList=new HashMap<>();
        bookList.put(1,new BookDTO(1,123,"혼공자","아무개","한빛출판사",new Date()));
        bookList.put(2,new BookDTO(2,124,"혼공자2","아무개","한빛출판사",new Date()));

    }

    @Override
    public List<BookDTO> selectBookList() {
        return new ArrayList<>(bookList.values());
    }

    @Override
    public BookDTO selectOne(int sequence) {
        return this.bookList.get(sequence);
    }
}
