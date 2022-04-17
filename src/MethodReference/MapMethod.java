package MethodReference;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.BiFunction;
import java.util.function.Function;

public class MapMethod {
    // 무게 리스트를 생성하고
    public static <T, R> List<R> map(List<T> list, Function<T, R> f) {
        List<R> result = new ArrayList<>();
        for(T t:list){
            result.add(f.apply(t));
        }
        return result;
    }

    public static void main(String...args){
        List<Integer> weights = Arrays.asList(1, 4, 5, 8, 9);
        List<Lemon> lemonList = map(weights,Lemon::new);

    }
}
