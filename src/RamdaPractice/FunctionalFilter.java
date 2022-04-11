package RamdaPractice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

public class FunctionalFilter {
    
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
        List<String> stringList = Arrays.asList("sdfsdf", "", "112233", "aaa");

        Predicate<String> nonEmptyStringPredicate =
                (String s)->!s.isEmpty();

        List<String> nonStringList = filter(stringList, nonEmptyStringPredicate);

        System.out.println("nonStringList.size() = " + nonStringList.size());
    }
}

