package ActualStream;

import java.util.Arrays;
import java.util.List;

public class Reducing {
    public static void main(String...args){
        List<Dish> menu = Arrays.asList(
                new Dish("pork", false, 800, Dish.Type.MEAT),
                new Dish("beef", false, 700, Dish.Type.MEAT),
                new Dish("chicken", false, 400, Dish.Type.MEAT),
                new Dish("french frise", true, 530, Dish.Type.OTHER),
                new Dish("rice", true, 350, Dish.Type.OTHER),
                new Dish("season fruit", true, 120, Dish.Type.OTHER),
                new Dish("pizza", true, 550, Dish.Type.OTHER),
                new Dish("prawns", false, 300, Dish.Type.FISH),
                new Dish("salmon", false, 450, Dish.Type.FISH)
        );

        List<Integer> numbers = Arrays.asList(1,2,3,4,5);
        int sum = numbers.stream()
                .reduce(0, (a, b) -> a + b);
        System.out.println(sum);
        /* reduce 를 이용하면
        1. 초기값에 대한 변수 선언 필요 x
        2. 연산 반복문 생략 가능
        reduce 의 인수는 1. 초기값 2. BinaryOperator<T> 이며
        이 식에서 B<T> 에 대한 인수는 람다를 통해
        a 와 b 가 들어왔을 때 그 합으로 표현했다.
         */
        int sumWithMethodReference = numbers.stream()
                .reduce(0, Integer::sum);
        System.out.println("sumWithMethodReference = " + sumWithMethodReference);
        // 메소드 참조를 이용하여 합을 표현하는 방법

        int multiply = numbers.stream()
                .reduce(1, (a, b) -> a * b);
        System.out.println("multiply = " + multiply);
        // 곱에 대한 연산

        int multiplyWithMethodReference
                = numbers.stream()
                .reduce(1,Math::multiplyExact);
        System.out.println("multiplyWithMethodReference = " + multiplyWithMethodReference);
        // 메소드 참조를 이용한 곱을 표현하는 방식 , Math.multiplyExact 메소드를 사용하였다.

        //map 과 reduce 를 이용하여 스트림의 요리 개수 계산
        Integer numOfMenu = menu.stream()
                .map(dish -> 1)
                .reduce(0, (a, b) -> a + b);
        System.out.println("numOfMenu = " + numOfMenu);

        //count를 이용하여 스트림 개수 계산
        long count = menu.stream().count();
        System.out.println("count = " + count);
    }
}
