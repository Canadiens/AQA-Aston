package org.example;

import java.util.ArrayList;
import java.util.Arrays;
public class Box<T extends Fruit> {
    private ArrayList<T> content;

    public Box(T... content) {
        this.content = new ArrayList<>(Arrays.asList(content));
    }
    public float getWeight() {
        if (content.size() == 0) return 0;
        float weight = 0;
        for (T fruit : content) {
            weight += fruit.getWeight();
        }
        return weight;
    }

    public void addFruit(T... content) {
        this.content.addAll(Arrays.asList(content));
    }
    public void clear() {
        content.clear();
    }
    public boolean compare(Box box) {
        return Math.abs(this.getWeight() - box.getWeight()) < 0.0001;
    }
    public void trade(Box<? super T> box) {
        box.content.addAll(this.content);
        clear();
    }
}