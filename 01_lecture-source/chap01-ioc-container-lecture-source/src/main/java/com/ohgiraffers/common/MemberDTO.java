package com.ohgiraffers.common;

import lombok.*;

@AllArgsConstructor@Getter@Setter@ToString
@NoArgsConstructor
//@Data <=x
public class MemberDTO {

    private int sequence;  //회원 번호
    private String id ;     // 아이디
    private String pwd;     // pwd
    private String name;      //이름

}
