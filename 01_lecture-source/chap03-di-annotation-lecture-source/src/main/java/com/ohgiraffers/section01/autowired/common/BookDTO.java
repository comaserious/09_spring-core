package com.ohgiraffers.section01.autowired.common;

import lombok.*;

import java.util.Date;


@NoArgsConstructor@AllArgsConstructor@Getter@Setter@ToString
public class BookDTO {

    private int sequence;
    private int isbn;
    private String title;
    private String author;
    private String publisher;
    private Date createDate;


}
