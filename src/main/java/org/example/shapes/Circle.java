package org.example.shapes;

public class Circle implements Circls {
    private double radius;
    private String colorOfBorder;
    private String colorOfCircle;
    public Circle(double radius, String colorOfBorder, String colorOfCircle) {
        this.radius = radius;
        this.colorOfBorder = colorOfBorder;
        this.colorOfCircle = colorOfCircle;
    }
    public void printInfo() {
        System.out.println("Периметр круга: " + perimetr(radius));
        System.out.println("Площадь круга: " + square(radius));
        System.out.println("Цвет границы круга:  " + colorOfBorder);
        System.out.println("Цвет фона круга: " + colorOfCircle);
    }
}