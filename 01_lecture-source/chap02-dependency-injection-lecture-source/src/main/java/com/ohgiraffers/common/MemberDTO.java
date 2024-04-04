package com.ohgiraffers.common;

import lombok.*;

@NoArgsConstructor@AllArgsConstructor@Getter@Setter@ToString
public class MemberDTO {

    private int sequence;
    private String name;
    private String phone;
    private String email;
    private Account personalAccount;  // 개인 개좌



}
