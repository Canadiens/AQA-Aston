package org.example;
import org.example.animals.*;
import org.example.shapes.*;
public class Main {
    public static void main(String[] args) {
        Circle circle = new Circle(3, "красный", "синий");
        Rectangle rectangle = new Rectangle(123, 231, "синий", "зеленый");
        Triangle triangle = new Triangle(12, 23, 4, 5, 67, "черный", "фиолетовый");
        circle.printInfo();
        rectangle.printInfo();
        triangle.printInfo();
        Dog dog = new Dog();
        Cat cat = new Cat();
        Cat cat1 = new Cat();
        Dog dog1 = new Dog();
        Cat cat2 = new Cat();
        dog.run("Марк", 500);
        dog.swim("Марк", 55);
        cat.run("Матрос", 150);
        cat.swim("Марк", 0);
        cat1.run("Тул", 20);
        System.out.println("Число собак " + dog1.getDogsNumber());
        System.out.println("Число котов " + cat2.getCatsNumber());
        System.out.println("Число животных " + cat2.getAnimal());

        Plate plate = new Plate(100);
        Cat[] cats = new Cat[7];
        cats[0] = new Cat("Томас", 9);
        cats[1] = new Cat("Бегемот", 7);
        cats[2] = new Cat("Филипп Маркович", 68);
        cats[3] = new Cat("Пушок", 9);
        cats[4] = new Cat("Василёк", 5);
        cats[5] = new Cat("Глазик", 6);
        cats[6] = new Cat("Barsik", 7);
        for (int i = 0; i < cats.length; i++) {
            cats[i].eat(plate);
            System.out.println(cats[i]);
        }
    }
}
