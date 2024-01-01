package org.example.shapes;

public class Rectangle implements Rectangls {
    private double width;
    private double length;
    private String colorOfBorder;
    private String colorOfRectangle;
    public Rectangle(double width, double length, String colorOfBorder, String colorOfRectangle) {
        this.width = width;
        this.length = length;
        this.colorOfBorder = colorOfBorder;
        this.colorOfRectangle = colorOfRectangle;
    }
    @Override
    public void printInfo() {
        System.out.println("Периметр прямоугольника: " + perimetr(length, width));
        System.out.println("Площадь прямоугольника: " + square(length, width));
        System.out.println("Цвет границы прямоугольника:  " + colorOfBorder);
        System.out.println("Цвет фона прямоугольника: " + colorOfRectangle);
    }
}