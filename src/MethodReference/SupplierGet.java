package MethodReference;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.function.Function;
import java.util.function.Supplier;

public class SupplierGet {
    public static <T,R> List<R> map(List<T> list, Function<T,R> f) {
        List<R> result = new ArrayList<>();
        for (T t : list) {
            result.add(f.apply(t));
        }
        return result;
    }
    

    public static void main(String...args){
        Supplier<Apple> c1 = Apple::new;
        Apple a1 = c1.get();

        Function<Integer,Lemon> c2 = Lemon::new;
        Lemon l1 = c2.apply(100);

        List<Integer> weights = Arrays.asList(5,1,2,7,8);
        List<Lemon> lemons = map(weights,Lemon::new);


    }
}
