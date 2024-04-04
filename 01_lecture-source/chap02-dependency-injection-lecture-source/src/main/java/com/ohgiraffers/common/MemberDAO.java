package com.ohgiraffers.common;

import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;

@Repository("dao")
public class MemberDAO {

    private final Map<Integer,MemberDTO> memberMap;

    public  MemberDAO(){
        memberMap=new HashMap<>();
        this.memberMap.put(1,new MemberDTO(1,"홍길동","020-1234-4444","fff@gmail.com",new PersonalAccount(10,"110-1211-12131313")));


    }



}
