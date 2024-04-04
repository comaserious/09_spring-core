package com.ohgiraffers.section02.javaconfig;

import com.ohgiraffers.common.MemberDTO;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Application01 {

    public static void main(String[] args) {

        ApplicationContext context = new AnnotationConfigApplicationContext(ContextConfiguration.class);

//        MemberDTO member = context.getBean(MemberDTO.class);


        // 특별히 지정을 하지 않았다면 메소드 이름이 bean id 가 된다
        MemberDTO member = context.getBean("getMember",MemberDTO.class);
        System.out.println("member = " + member);

    }
}
