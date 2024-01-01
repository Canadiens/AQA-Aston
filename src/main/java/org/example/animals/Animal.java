package org.example.animals;

public abstract class Animal {
    private static int numberOfAnimals = 0;
    private int animalNumber;
    public Animal() {
        numberOfAnimals++;
        this.animalNumber = numberOfAnimals;
    }
    public int getAnimal() {
        return animalNumber;
    }
    abstract void run(String name, int x);
    abstract void swim(String name, int x);
}