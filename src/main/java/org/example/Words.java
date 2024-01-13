package org.example;
import java.util.*;

public class Words {
    public static void main(String[] args) {
        String[] arrays = {"yes", "she", "rus", "me", "you", "it", "me", "we", "they", "yes", "yes", "they", "yes", "he", "yes", "she", "no"};
        Map<String, Integer> repetitive = new HashMap<>();
        for (String x : arrays) {
            int newValue = repetitive.getOrDefault(x, 0) + 1;
            repetitive.put(x, newValue);
        }
        System.out.println(repetitive);
    }
}