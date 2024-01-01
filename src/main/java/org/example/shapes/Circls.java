package org.example.shapes;

public interface Circls {
    double PI = 3.14159;
    default double perimetr(double radius) {
        return 2 * PI * radius;
    }
    default double square(double radius) {
        return PI * (radius * radius);
    }
    void printInfo();
}