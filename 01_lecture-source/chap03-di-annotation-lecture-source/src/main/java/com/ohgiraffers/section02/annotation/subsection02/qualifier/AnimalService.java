package com.ohgiraffers.section02.annotation.subsection02.qualifier;

import com.ohgiraffers.section02.common.Animal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

/*필기.
*  */
@Service("serviceQualifier")
public class AnimalService {

    /*필드 주입 방식*/

//    @Autowired
//    @Qualifier("raccoon")
//    private Animal animal;
//
//    public void animalEat(){
//        this.animal.eat();
//    }

    private Animal animal;
    /*생성자 주입방식*/

    /*필기. 생성자 주입의 경우 @Qualifier 어노테이션은 메소드의 파라미터 앞에 기재를 한다*/

    @Autowired
    public AnimalService(@Qualifier("racoon")Animal animal){
        this.animal = animal;

    }
    public void animalEat(){
        animal.eat();
    }

}
