package ActualStream.Practice;

import java.util.*;
import java.util.stream.Stream;

public class Practice5_6 {
    public static void main(String...args){

        Trader raoul = new Trader("raoul", "Cambridge");
        Trader mario = new Trader("mario", "Milan");
        Trader alan = new Trader("alan", "Cambridge");
        Trader brian = new Trader("brian", "Cambridge");

        List<Trader> traders = new ArrayList<>();
        traders.add(raoul);
        traders.add(mario);
        traders.add(alan);
        traders.add(brian);

        List<Transaction> transactions = Arrays.asList(
                new Transaction(brian, 2011, 300),
                new Transaction(raoul, 2012, 1000),
                new Transaction(raoul, 2011, 400),
                new Transaction(mario, 2012, 710),
                new Transaction(mario, 2012, 700),
                new Transaction(alan, 2012, 950)
        );

        //2011년에 일어난 모든 transactions 를 찾아 오름차순으로 정리
        /*
        출력 및 확인용
        transactions.stream()
                .filter(t -> t.getYear() == 2011)
                .sorted(Comparator.comparing(Transaction::getPrice)
                        .thenComparing(t -> t.getTrader().getName())
                        .reversed())
                .map(t->t.getTrader().getName())
                .forEach(System.out::println);
        */

        List<Transaction> transactions2011 = transactions.stream()
                .filter(t -> t.getYear() == 2011)
                .sorted(Comparator.comparing(Transaction::getPrice)
                        .thenComparing(t -> t.getTrader().getName())
                        .reversed())
                .toList();

        // 2. 모든 도시를 중복 없이 나열
        /* 출력용
        transactions.stream()
                .map(t -> t.getTrader().getCity())
                .distinct()
                .forEach(System.out::println);
        */
        List<String> allCities = transactions.stream()
                .map(t -> t.getTrader().getCity())
                .distinct()
                .toList();
        //3. 케임브릿지 근무자 이름순 정렬
        /* 출력용
        transactions.stream()
                .filter(t->t.getTrader().getCity()=="Cambridge")
                .sorted(Comparator.comparing(Transaction::getName))
                .map(t->t.getName())
                .distinct()
                .forEach(System.out::println);
         */
        List<String> traderInCambridge = transactions.stream()
                .filter(t -> t.getTrader().getCity() == "Cambridge")
                .sorted(Comparator.comparing(Transaction::getName))
                .map(Transaction::getName)
                .distinct()
                .toList();
        //4. 모든 근무자의 이름을 알파벳 순으로 정렬해서 반환
        /*
        traders.stream()
                .sorted(Comparator.comparing(Trader::getName))
                .map(Trader::getName)
                .forEach(System.out::println);

         */

        List<String> strings = traders.stream()
                .sorted(Comparator.comparing(Trader::getName))
                .map(Trader::getName)
                .toList();

        //5. 밀라노에 거래자가 있는가.
        traders.stream()
                .filter(t -> t.getCity() == "Milan")
                .findAny()
                .ifPresent(t->System.out.println("밀라노에 거래자가 존재"));

        //6. 케임브릿지에 거주하는 거래자의 모든 트랜잭션 값을 출력하시오
        transactions.stream()
                .filter(t -> t.getTrader().getCity() == "Cambridge")
                .map(Transaction::getPrice)
                .forEach(System.out::println);

        //7. 전체 트랜잭션중 최대값
        Optional<Transaction> max = transactions.stream()
                .max(Comparator.comparing(Transaction::getPrice));
        System.out.println("max = " + max.get().getPrice());

        Optional<Transaction> min = transactions.stream()
                .min(Comparator.comparing(Transaction::getPrice));
        System.out.println("min = " + min.get().getPrice());
    }
}
