package com.ohgiraffers.section03.properties.subsection01.properties;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

public class Owner {

    @PostConstruct
    public void openShop(){
        System.out.println("문 열어");
    }
    @PreDestroy
    public void closeShop(){
        System.out.println("문닫아");
    }
}
