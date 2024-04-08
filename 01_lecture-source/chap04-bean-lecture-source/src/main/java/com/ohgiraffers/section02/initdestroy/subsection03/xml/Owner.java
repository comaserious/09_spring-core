package com.ohgiraffers.section02.initdestroy.subsection03.xml;

import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;


public class Owner {



    public void openShop(){
        System.out.println("가게문 열었다 손님 받아라");
    }



    public void closeShop(){
        System.out.println("가게문 닫았다 나가라");
    }


    // 다만 여기서 어노테이션을 사용하기 위해서는 추가적인 dependencies를 등록해주어야한다
    // 이러한 단점이 존재한다
}
