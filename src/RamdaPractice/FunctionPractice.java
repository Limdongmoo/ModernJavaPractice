package RamdaPractice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;

public class FunctionPractice {

    public static <T,R> List<R> map(List<T> list, Function<T,R> f){
        List<R> result = new ArrayList<>();
        for(T t : list){
            result.add(f.apply(t));
        }
        return result;
    }

    public static void main(String...args){
        List<Integer> list = map(Arrays.asList("String", "to", "Integer"),
                (String s) -> s.length());
        for(int i : list) {
            System.out.printf("%d   ", i);
        }
    }
}
