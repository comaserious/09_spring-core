package com.ohgiraffers.section02.common;

import org.springframework.stereotype.Component;

@Component
public class Racoon implements Animal{
    @Override
    public void eat() {
        System.out.println("너구리고 솜사탕을 호수에 담가 먹음");
    }
}
