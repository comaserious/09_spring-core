package com.ohgiraffers.section02.initdestroy.subsection02.annotation;

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

        Product carpBread = (Product) context.getBean("carpBread");
        Product milk = (Product) context.getBean("milk");
        Product water = (Product) context.getBean("water");

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

        /*필기.
        *  init 메소드는 bean 객체 생성 시점에 동작하므로 바로 확인할 수 있지만,
        *  destroy 메소드는 bean 객체 소멸 시점에 동작하므로 컨테이너가 종료되지
        *  않을 경우 확인할 수 없다.
        *  가비지 컬렉터가 해당 빈을 메모리에서 지울때 destroy 메소드가 동작하게 되는데
        *  메모리에서 지우기 전에 프로세스가 종료되기 때문이다.
        *  따라서 close() 메소드로 컨테이너를 강제로 종료시키면 destroy 메소드가
        *  동작하게 되는 것이다*/
        ((AnnotationConfigApplicationContext)context).close();
    }
}
