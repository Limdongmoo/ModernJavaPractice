package MethodReference;

import java.util.function.DoubleFunction;
import java.util.function.Function;

public class FunctionCollaborate {

    public static double integrate(DoubleFunction<Double> f, double a, double b){
        return (f.apply(a)+f.apply(b))*(b-a)/2;
    }

    public static void main(String...args){
        Function<Integer, Integer> f = x -> x + 1;
        Function<Integer, Integer> g = x -> x * 2;
        Function<Integer, Integer> h = f.andThen(g);
        Function<Integer, Integer> i = f.compose(g);

        DoubleFunction<Double> fx = x -> x + 10;

        double trapezoid= integrate(x->x+10,4,8);

        System.out.println(trapezoid);

        System.out.printf("%d", h.apply(1));
        System.out.println();
        System.out.printf("%d", i.apply(1));


    }
}
