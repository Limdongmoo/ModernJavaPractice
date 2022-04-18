package streamPractice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.function.Function;

import static java.util.stream.Collectors.toList;

public class firstStream {

    public static List<Dish> map(List<Integer> list, Function<Integer,Dish> f){
        List<Dish> result = new ArrayList<>();
        for(int i : list){
            result.add(f.apply(i));
        }
        return result;
    }

    public static void main(String...args){
        List<Integer> caloriesList = Arrays.asList(100, 300, 400, 300);
        List<Dish> dishes = map(caloriesList,Dish::new);

        List<Dish> lowCaloriesList=
                dishes.parallelStream()
                        .filter(dish->dish.getCalories()<400)
                        .collect(toList());
     
        for(Dish d : lowCaloriesList){
            System.out.println("d.getCalories() = " + d.getCalories());
        }
    }
}
