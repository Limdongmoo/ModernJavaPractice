package AnonymousClass;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static java.awt.Color.*;

public class AppleFiltering {

    static List<Apple> filteringApple(List<Apple> list, ApplePredicate a){
        List<Apple> result = new ArrayList<>();
        for(Apple apple : list){
            if(a.test(apple)){
                result.add(apple);
            }
        }
        return result;
    }

    public static void main(String...args){
        List<Apple> storage = Arrays.asList(new Apple(RED,80),new Apple(GREEN,155),new Apple(RED,160));

        List<Apple> redApple = filteringApple(storage, new ApplePredicate() {
            @Override
            public boolean test(Apple apple) {
                return RED.equals(apple.getColor());
            }
        });

        List<Apple> heavyApple = filteringApple(storage,(Apple apple) -> apple.getWeight()>150);

        for(Apple a : heavyApple){
            System.out.println(a.toString());
        }
    }
}
