package ActualStream;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class SearchAndMatching {
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

        if(menu.stream().anyMatch(Dish::isVegetarian)){
            System.out.println("The menu is (somewhat) vegetarian friendly!!");
        }

        boolean isHealthy = menu.stream()
                .allMatch(dish -> dish.getCalories() < 1000);
        if (isHealthy) {
            System.out.println("It is healthy menu");
        }

        boolean isHealthyWithNone = menu.stream()
                .noneMatch(d -> d.getCalories() >= 1000);
        if(isHealthyWithNone){
            System.out.println("It is healthy menu");
        }

        Optional<Dish> dish = menu.stream()
                .filter(Dish::isVegetarian)
                .findAny();
        // 하나 발견시 Optional 로 감싼 값을 반환

        menu.stream()
                .filter(Dish::isVegetarian)
                .findAny()
                .ifPresent(d -> System.out.println(d.getName()));
        // 값이 있으면 출력되고 값이 없으면 아무것도 출력되지 않는다. 이때 ifPresent()가 void 형이다.

        List<Integer> someNumbers = Arrays.asList(1, 2, 3, 4, 5);
        Optional<Integer> firstSquareDivisibleByThree = someNumbers.stream()
                .map(n -> n * n)
                .filter(n -> n % 3 == 0)
                .findFirst();
        System.out.println(firstSquareDivisibleByThree.get());

        //제곱근중 3으로 나누어지는 첫번째 숫자를 반환
        /*
        findAny() VS findFirst()
        병렬성을 요구하는 경우 첫번째로 반환하는 값이 달라질 수 있다. 그렇기에 findAny() 는 순서에 제약이 없는(병렬적인 상황)
        에서 사용되고 findFirst()는 어떠한 로직에 의해 정렬된 상태에서 첫번째로 조건을 충족하는 값을 반환할때 사용한다.
         */
    }

}
