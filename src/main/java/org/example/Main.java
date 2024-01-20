package org.example;

import java.util.*;
import java.util.stream.*;
public class Main {
    private static long counter;
    private static void generateNumbers(int maxSize) {
        counter = Stream.generate(new Random()::nextInt)
                .limit(maxSize)
                .filter(n -> n % 2 == 0)
                .count();
    }

    public static void main(String[] args) {
        generateNumbers(10);

        List<String> words = List.of("Highload", "High", "Load", "Highload");
        long counterHigh = words.stream()
                .filter(s -> s.equals("High"))
                .count();

        Optional<String> firstElement = words.stream().findFirst();
        firstElement.ifPresentOrElse(System.out::println, () -> System.out.println("нет элемента"));

        Optional<String> lastElement = words.stream().reduce((first, second) -> second);
        lastElement.ifPresentOrElse(System.out::println, () -> System.out.println("нет элемента"));

        List<String> sortString = List.of("f10", "f15", "f2", "f4", "f4");
        String[] sortedArray = sortString.stream()
                .sorted((s1, s2) -> {
                    int first = Integer.parseInt(s1.substring(1));
                    int second = Integer.parseInt(s2.substring(1));
                    return Integer.compare(first, second);
                })
                .toArray(String[]::new);

        Scanner scanner = new Scanner(System.in);
        Stream<String> date = Stream.generate(scanner::nextLine);
        List<String> logins = date.takeWhile(s -> !s.isEmpty())
                .filter(s -> s.startsWith("f"))
                .collect(Collectors.toList());
        logins.forEach(System.out::println);

        System.out.println(Arrays.toString(sortedArray));
        System.out.println(counterHigh);
        System.out.println(counter);
    }
}