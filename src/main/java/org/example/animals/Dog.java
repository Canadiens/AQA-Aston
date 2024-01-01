package org.example.animals;

public class Dog extends Animal {
    private static int numberOfDogs = 0;
    private int dogNumber;
    public Dog() {
        super();
        numberOfDogs++;
        this.dogNumber = numberOfDogs;
    }
    public int getDogsNumber() {
        return dogNumber;
    }
    public void run(String name, int distance) {// метод в случае неверного ввода данных, выдает ошибку, иначе выполняется.
        trying:
        {
            if (distance > 500 || distance < 0) {
                System.out.println("Введено не корректное число - собака может пробежать от 0 до 500 метров включительно");
                break trying;
            }

            System.out.println(name + " " + "Преодолел " + distance + " метров");
        }
    }
    @Override
    public void swim(String name, int distance) {
        swiming:
        if (distance > 10 || distance < 0) {
            System.out.println("Введено не корректное число - собака может проблыть от 0 до 10 метров включительно");
            break swiming;
        }
        System.out.println(name + " " + "Проплыл " + distance + " метров");
    }
}