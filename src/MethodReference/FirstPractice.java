package MethodReference;

import java.util.Arrays;
import java.util.List;
import java.util.function.Supplier;

public class FirstPractice {
    public static void main(String...args){
        List<String> str = Arrays.asList("a","b","A","B");
        List<String> str2 = str;
        str2.sort(String::compareToIgnoreCase);
        for(String s : str){
            System.out.printf("%s",s);
        }
        for(String s : str2){
            System.out.printf("%s",s);
        }

    }
}
