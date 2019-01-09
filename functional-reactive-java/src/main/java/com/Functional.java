package com;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Functional {
    public static void main(String[] args)  {
        List<Dog> dogs= Arrays.asList(new Dog(), new Dog());


        System.out.println(getAges(dogs, Dog::getAge2));
    }

    public static  List<Integer> getAges(List<Dog> dogs, DogAge f) {

        List<Integer> ages = new ArrayList<>();

        for (Dog dog : dogs) {
            ages.add(f.apply(dog));
        }

        return ages;
    }
}

@FunctionalInterface
interface DogAge {
    Integer apply(Dog dog);
 }

class Dog {
    public Integer getAge() {
        return 1;
    }
    public Integer getAge2() {
        return 2;
    }
}