package org.example.animals;

public class Cat extends Animal {
    private static int numberOfCats = 0;
    private int catNumber;
    private String name;
    private int appetite;
    private boolean hungry;

    public String toString() {
        return "кот по кличке " + name + " cыт " + hungry;
    }
    public Cat(String name, int appetite) {
        super();
        this.name = name;
        this.appetite = appetite;
        numberOfCats++;
        this.catNumber = numberOfCats;
    }
    public Cat() {
        // Вы можете установить значения по умолчанию или не выполнять дополнительных действий.
        numberOfCats++;
        this.catNumber = numberOfCats;
    }
    public int getCatsNumber() {
        return catNumber;
    }
    @Override
    public void run(String name, int distance) {// метод в случае неверного ввода данных, выдает ошибку, иначе выполняется.
        trying:
        {
            if (distance > 200 || distance < 0) {
                System.out.println("Введено не корректное число - кот может пробежать от 0 до 200 метров включительно");
                break trying;
            }
            System.out.println(name + " Преодолел " + distance + " метров");
        }
    }
    @Override
    public void swim(String name, int distance) {
        System.out.println(name + " Плавать не может!");
    }
    public void eat(Plate p) {
        hungry = (p.food - appetite < 0) ? false : true;
        if (p.food - appetite >= 0) {
            p.decreaseFood(appetite);
        }
    }
}