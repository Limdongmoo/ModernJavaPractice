package ActualStream;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.Comparator.comparing;
import static java.util.stream.Collectors.toList;

public class DishStream {

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

        menu.stream().sorted(Comparator.comparing(Dish::getCalories));

        List<Dish> lowCaloriesMenu = menu.stream()
                .filter(dish -> dish.getCalories() < 400)
                .sorted(comparing(Dish::getCalories))
                .collect(toList());

        for(Dish d : lowCaloriesMenu){
            System.out.print(d.getCalories()+", ");
            System.out.println(d);
        }

        List<String> threeHighCalories = menu.stream()
                .filter(d -> d.getCalories()>300)
                .map(Dish::getName)
                .limit(3)
                .toList();
        // 300칼로리 이상 음식중 선착순으로 3개 추출 -> 음식 이름으로 추출

        Stream<String> s = threeHighCalories.stream();
        s.forEach(System.out::println);
        // s.forEach(System.out::println); 이미 사용된 스트림으로 오류 발생
        Stream<String> s1 = threeHighCalories.stream();
        s1.forEach(System.out::println);
        // 스트림은 소스 반복 사용이 불가능 하다. 즉, 한번만 사용할 수 있으며 재 사용 시에는 새로 추가해야 한다.

        List<String> highCaloricDishes = menu.stream()
                .filter(dish->dish.getCalories()>300)
                .map(Dish::getName)
                .toList();
        //함수를 파라미터로 받는 메서드인 map 을 이용하여 Stream<String> 을 반환하고 이를 리스트로 반환
        List<String> names = menu.stream()
                .filter(dish -> {
                    System.out.println("filtering   " + dish.getName());
                    return dish.getCalories() > 300;
                })
                .map(dish->{
                    System.out.println("mapping " + dish.getName());
                    return dish.getName();
                })
                .limit(3)
                .toList();
        //병렬 처리 확인
        List<Dish> isVegetarian = menu.stream()
                .filter(Dish::isVegetarian)
                .toList();
        //isVegetarian 이 참인 객체들을 toList로 List<dish> 반환
        List<Integer> numbers = Arrays.asList(1,2,3,4,1,2,3,1,2,1);
        numbers.stream()
                .filter(i -> i % 2 == 0)
                .distinct()
                .forEach(System.out::println);
        //distinct() 각 요소를 고유하게 설정

        List<Dish> slicedMenu =
                menu.stream()
                        .takeWhile(d -> d.getCalories() <= 320)
                        .toList();
        //takeWhile 을 이용하여 조건 미충족시 탈출
        List<Dish> slicedMenu2=
                menu.stream()
                        .dropWhile(dish -> dish.getCalories()<320)
                        .toList();
        //dropWhile을 이용하여 조건 충족하는 값 drop
        menu.stream()
                .filter(dish -> dish.getType().equals(Dish.Type.MEAT))
                .limit(2)
                .map(Dish::getName)
                .forEach(System.out::println);
    //Map을 이용하여 Dish name 출력
        List<Integer> integers = menu.stream()
                .map(Dish::getName)
                .map(String::length)
                .toList();

        List<String> words = Arrays.asList("Hello", "World");
        List<Stream<String>> streams = words.stream()
                .map(word -> word.split(""))
                //각 문자를 각각의 배열로 변환
                .map(Arrays::stream)
                //각 배열을 별도의 스트림으로 생성
                .distinct()
                .toList();
                //반환형이 List<Stream<String>> 으로 문제 해결 x

        List<String> strings = words.stream()
                .map(word -> word.split(""))
                .flatMap(Arrays::stream)
                .distinct()
                .toList();

        //flatMap: 각 값을 다른 스트림으로 만든 다음 모든 스트림을 하나의 스트림으로 연결하는 기능

        // 숫자 리스트 -> 제곱근 리스트로 출력
        List<Integer> num = Arrays.asList(1,2,3,4,5);
        List<Integer> integers1 = num.stream()
                .map(n -> n * n)
                .toList();

        List<Integer> num1 = Arrays.asList(1, 2, 3);
        List<Integer> num2 = Arrays.asList(4,5);

        List<int[]> pairs = num1.stream()
                .flatMap(i ->
                        num2.stream()
                                .filter(j -> (i + j) % 3 == 0)
                                .map(j -> new int[]{i, j}))
                .toList();







    }
}
