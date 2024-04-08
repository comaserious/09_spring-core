package com.ohgiraffers.section02.initdestroy.subsection02.annotation;

import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

@Component
public class Owner {

    /*init-method 랑 같은 오노테이션 설정 방법이다*/
    @PostConstruct
    public void openShop(){
        System.out.println("가게문 열었다 손님 받아라");
    }

    /*destroy-method 랑 같은 어노테이션 설정 방법이다*/
    @PreDestroy
    public void closeShop(){
        System.out.println("가게문 닫았다 나가라");
    }


    // 다만 여기서 어노테이션을 사용하기 위해서는 추가적인 dependencies를 등록해주어야한다
    // 이러한 단점이 존재한다
}
