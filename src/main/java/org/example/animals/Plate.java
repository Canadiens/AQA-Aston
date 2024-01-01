package org.example.animals;

public class Plate {
    protected int food;
    public Plate(int food) {
        this.food = food;
    }
    public void decreaseFood(int n) {
        if (food >= n) {
            food -= n;
        }
    }
    public void addFood(int n) {
        food += n;
    }
}
