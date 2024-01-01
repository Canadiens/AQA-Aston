package org.example.shapes;

public class Triangle implements Triangls {
    private double sideA;
    private double sideB;
    private double sideC;
    private double height;
    private double base;
    private String colorOfBorder;
    private String colorOfTriangle;
    public Triangle(double sideA, double sideB, double sideC, double height, double base, String colorOfBorder, String colorOfTriangle) {
        this.sideA = sideA;
        this.sideB = sideB;
        this.sideC = sideC;
        this.colorOfBorder = colorOfBorder;
        this.colorOfTriangle = colorOfTriangle;
        this.height = height;
        this.base = base;
    }
    public void printInfo() {
        System.out.println("Периметр треугольника: " + perimetr(sideA, sideB, sideC));
        System.out.println("Площадь треугольника: " + square(base, height));
        System.out.println("Цвет границы треугольника:  " + colorOfBorder);
        System.out.println("Цвет фона треугольника: " + colorOfTriangle);
    }
}