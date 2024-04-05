package com.ohgiraffers.section02.common;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

/*필기.
*  @Primary 어노테이션을 설정하면 @Autowired로 동일한 타입(Animal)의 여러
*  Bean(객체)를 찾게 되는 경우 자동으로 연결을 우선 시 할 타입으로 설정이 된다
*  동일한 타입의 클래스 중 한 개만 @Primary 어노테이션을 사용할 수 있다*/
@Component
@Primary
public class Koala implements Animal{
    @Override
    public void eat() {
        System.out.println("코알라가 유칼립투스를 씹어먹음");
    }
}
