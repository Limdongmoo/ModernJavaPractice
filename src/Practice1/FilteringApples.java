package Practice1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

import static java.awt.Color.*;
import static java.lang.Integer.compare;

public class FilteringApples {

    Comparator<Apple> byWeight =
            (Apple a1, Apple a2) -> a1.getWeight().compareTo(a2.getWeight());

    public static void main(String[] args) {
        List<Apple> storage = Arrays.asList(new Apple(80, GREEN),
                new Apple(155, GREEN), new Apple(120, RED));

        List<Apple> heavyApples
                = filterApples(storage, new AppleHeavyPredicate());
        for(Apple a : heavyApples){
            System.out.println(a.getWeight() + "g Apple");
        }
        List<Apple> greenApples
                = filterApples(storage, new AppleColorPredicate());
        for(Apple a : greenApples){
            System.out.println(a.getColor().toString() +"g Apple");
        }

    }

        public static List<Apple> filterApples(List<Apple> list, ApplePredicate p) {
            List<Apple> result = new ArrayList<>();
            for (Apple a : list) {
                if (p.test(a)) {
                    result.add(a);
                }
            }
            return result;
        }


}
