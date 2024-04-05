package com.ohgiraffers.section02.annotation.subsection03.collection;

import com.ohgiraffers.section02.common.Animal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("animalCollection")
public class AnimalService {

    // 이런식이면 하나의 Bean 만을 가지고 올수 있다
//    private Animal animal;
//
//    @Autowired
//    public AnimalService(Animal animal){
//        this.animal=animal;
//    }

    private List<Animal> animalList;

    public AnimalService(List<Animal> animalList){
        this.animalList = animalList;
    }

    public void animaleat(){
        for(Animal animal : animalList){
            animal.eat();
        }
    }
}
