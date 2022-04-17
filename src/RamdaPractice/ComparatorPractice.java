package RamdaPractice;

import static java.awt.Color.*;
import static java.util.Comparator.*;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class ComparatorPractice {

    public static void main(String...args){

        List<Apple> storage = Arrays.asList(new Apple(RED, 150),
                new Apple(GREEN, 80), new Apple(RED, 160));


        storage.sort(new Comparator<Apple>(){

            @Override
            public int compare(Apple o1, Apple o2) {
                System.out.println(1);
                return o1.getWeight().compareTo(o2.getWeight());
            }
        });
        storage.sort(comparing(Apple::getWeight));

        for(Apple a : storage){
            System.out.println(a.getWeight());
        }



    }

}
