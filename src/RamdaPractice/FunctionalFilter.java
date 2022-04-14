package RamdaPractice;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

public class FunctionalFilter {
    public static <T> List<T> filter(List<T> list, Predicate<T> p){
        List<T> result = new ArrayList<T>();
        for(T t : list){
            if(p.test(t)){
                result.add(t);
            }
        }
        return result;
    }

    public static void main(String...args){
        List<String> list = Arrays.asList("aaa","","bbb","ccc");
        List<String> emptyList = filter(list, new Predicate<String>() {
            @Override
            public boolean test(String s) {
                return s.isEmpty();
            }
        });

        List<String> unEmptyList = filter(list,(String s)->!s.isEmpty());

        System.out.println("unEmptyList.size() = " + unEmptyList.size());
        System.out.println("emptyList.size() = " + emptyList.size());

    }
}
