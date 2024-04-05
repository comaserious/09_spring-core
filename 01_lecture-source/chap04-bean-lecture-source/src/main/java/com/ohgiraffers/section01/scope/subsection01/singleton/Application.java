package com.ohgiraffers.section01.scope.subsection01.singleton;

import com.ohgiraffers.common.Product;
import com.ohgiraffers.common.ShoppingCart;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.lang.annotation.RetentionPolicy;
import java.util.List;

public class Application {

    public static void main(String[] args) {

        ApplicationContext context= new AnnotationConfigApplicationContext(ContextConfiguration.class);

        String[] beanNames = context.getBeanDefinitionNames();
        for(String bean : beanNames){
            System.out.println("bean : "+bean);
        }

        Product carpBread = (Product) context.getBean("carpBread");
        Product milk = (Product) context.getBean("milk");
        Product water = (Product) context.getBean("water");

        ShoppingCart cart1 = (ShoppingCart) context.getBean("cart");
        ShoppingCart cart2 = (ShoppingCart) context.getBean("cart");


        cart1.addItem(carpBread);
        cart2.addItem(milk);
        cart1.addItem(water);


        List<Product> items = cart1.getItem();

        // cart1 만 조회했는데 cart2 에 저장한 우유도 출력된것을 확인할수 있다
        // 즉 singleton 으로써 하나의 인스턴스를 공유하는 것이다
        for(Product i : items){
            System.out.println("item : "+i);
        }

        System.out.println("cart1 의 해시코드 : "+cart1.hashCode());
        System.out.println("cart2 의 해시코드 : "+cart2.hashCode());
    }
}
