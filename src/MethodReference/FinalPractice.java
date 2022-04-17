package MethodReference;

;
import java.sql.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

import static java.util.Comparator.comparing;

public class FinalPractice {

    public static <T,R> List<R> map(List<T> list, Function<T,R> f){
        List<R> result = new ArrayList<>();
        for(T t:list){
            result.add(f.apply(t));
        }
        return result;
    }

    public static <T> List<T> filter(List<T> list, Predicate<T> p){
        List<T> result = new ArrayList<>();
        for(T t : list){
            if(p.test(t)){
                result.add(t);
            }
        }
        return result;
    }



    public static void main(String...args){
        List<Integer> weights = Arrays.asList(1,4,5,7);
        List<Lemon> storage = map(weights, Lemon::new);

        storage.sort(comparing((Lemon l)->l.getWeight()));
        storage.sort(comparing(Lemon::getWeight));
        storage.sort(comparing(Lemon::getWeight).reversed());

        storage.sort(comparing(Lemon::getWeight)
                .reversed()
                .thenComparing(Lemon::getCountry));


        Predicate<Lemon> lightLemon = (lemon)-> lemon.getWeight()<5;
        List<Lemon> lightLemons = filter(storage, lightLemon);
        Predicate<Lemon> heavyLemon = lightLemon.negate();
        List<Lemon> heavyLemons = filter(storage, heavyLemon);

        lightLemons.sort(comparing(Lemon::getWeight).reversed());
        heavyLemons.sort(comparing(Lemon::getWeight)
                .thenComparing(Lemon::getCountry));

        for(Lemon l : lightLemons){
            System.out.println(l.getWeight());
        }

    }
}
