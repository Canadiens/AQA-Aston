package org.example.shapes;

public interface Rectangls {
    default double perimetr(double length, double width) {
        return (length + width) * 2;
    }

    default double square(double length, double width) {
        return length * width;
    }

    void printInfo();
}