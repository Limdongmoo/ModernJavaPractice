package MethodReference;

import java.util.function.Function;

public class FunctionCollaborate {
    public static void main(String...args){
        Function<Integer, Integer> f = x -> x + 1;
        Function<Integer, Integer> g = x -> x * 2;
        Function<Integer, Integer> h = f.andThen(g);
        Function<Integer, Integer> i = f.compose(g);

        System.out.printf("%d", h.apply(1));
        System.out.println();
        System.out.printf("%d", i.apply(1));


    }
}
