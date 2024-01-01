package org.example.shapes;

public interface Triangls {
    default double perimetr(double sideA, double sideB, double sideC) {
        return sideA + sideB + sideC;
    }
    default double square(double base, double height) {
        return 0.5 * base * height;
    }
    void printInfo();
}