package com.ohgiraffers.section03.properties.subsection01.properties;

import com.ohgiraffers.common.Bread;
import com.ohgiraffers.common.Product;
import com.ohgiraffers.common.ShoppingCart;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.List;

public class Application {

    public static void main(String[] args) {

        ApplicationContext context= new AnnotationConfigApplicationContext(ContextConfiguration.class);

        String[] beanNames = context.getBeanDefinitionNames();
        for(String bean : beanNames){
            System.out.println("bean : "+bean);
        }

        Product carpBread = context.getBean("carpBread" , Bread.class);
        System.out.println(carpBread);

        Product milk = (Product) context.getBean("milk");
        System.out.println(milk);
        Product water = (Product) context.getBean("water");
        System.out.println("water = " + water);

        ShoppingCart cart1 = (ShoppingCart) context.getBean("cart");
        ShoppingCart cart2 = (ShoppingCart) context.getBean("cart");


        cart1.addItem(carpBread);
        cart2.addItem(milk);
        cart1.addItem(water);


        List<Product> items = cart1.getItem();

        for(Product i : items){
            System.out.println("item : "+i);
        }

        System.out.println(cart2.getItem());

        System.out.println("cart1 의 해시코드 : "+cart1.hashCode());
        System.out.println("cart2 의 해시코드 : "+cart2.hashCode());


        ((AnnotationConfigApplicationContext)context).close();
    }
}
