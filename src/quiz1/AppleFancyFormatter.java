package quiz1;

import java.util.ArrayList;
import java.util.List;

public class AppleFancyFormatter implements AppleFormatter{

    @Override
    public String accept(Apple apple) {
        String characteristic = apple.getWeight() > 150 ? "heavy" : "light" ;
        return " A " + characteristic + " " + apple.getColor() + " apple ";
    }

    public static void prettyPrintApple(List<Apple> inventory, AppleFormatter formatter){
        for(Apple a : inventory){
            String output = formatter.accept(a);
            System.out.println(output);
        }
    }

    public static void main(String[] args){
        List<Apple> storage = new ArrayList<>();
        Apple a1 = new Apple();
        Apple a2 = new Apple();
        a1.setWeight(170);
        a1.setColor("green");
        a2.setWeight(120);
        a2.setColor("red");

        storage.add(a1);
        storage.add(a2);

        prettyPrintApple(storage, new AppleFancyFormatter());
    }
}
