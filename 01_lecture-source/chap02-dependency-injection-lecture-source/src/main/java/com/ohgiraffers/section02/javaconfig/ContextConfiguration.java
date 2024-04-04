package com.ohgiraffers.section02.javaconfig;

import com.ohgiraffers.common.Account;
import com.ohgiraffers.common.MemberDTO;
import com.ohgiraffers.common.PersonalAccount;
import org.springframework.context.annotation.Bean;

import org.springframework.context.annotation.Configuration;

@Configuration
public class ContextConfiguration {

    @Bean
    public Account account(){
        return new PersonalAccount(10,"110-1211-133131");

    }

    // 생성자를 통한 주입
//    @Bean
//    public MemberDTO member(){
//        return new MemberDTO(1,"홍길동","101-1213-1331","ddd@gmai.com",account() );
//    }

    // setter 를 통한 주입
    @Bean
    public MemberDTO member(){

        MemberDTO member = new MemberDTO();

        member.setSequence(1);
        member.setName("햇갈린다");
        member.setPhone("010-1213-1213");
        member.setEmail("dkdk@gmail.com");
        member.setPersonalAccount(account());
        return member;


    }

}
