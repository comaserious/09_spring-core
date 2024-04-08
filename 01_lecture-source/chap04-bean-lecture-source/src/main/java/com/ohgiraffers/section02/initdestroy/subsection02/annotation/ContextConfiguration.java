package com.ohgiraffers.section02.initdestroy.subsection02.annotation;

import com.ohgiraffers.common.Beverage;
import com.ohgiraffers.common.Bread;
import com.ohgiraffers.common.Product;
import com.ohgiraffers.common.ShoppingCart;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import java.util.Date;

@Configuration
@ComponentScan("com.ohgiraffers.section02.initdestroy.subsection02")
public class ContextConfiguration {



    @Bean
    public Product carpBread(){
        return new Bread("붕어빵",1000,new Date());
    }
    @Bean
    public Product milk(){
        return new Beverage("초코우유",2000,500);
    }

    @Bean
    public Product water(){
        return new Beverage("에비앙",6000,100);

    }


    /*prototype : getBean() 시에 매번 새로운 인스턴스를 생성하게 해준다*/
    @Bean
    @Scope("prototype")
    public ShoppingCart cart(){

        return new ShoppingCart();
    }



}
