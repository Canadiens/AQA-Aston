package org.example;

public class MyArrayDataException extends Throwable {
    public MyArrayDataException(String s, int i, int j) {

        this.i = i;
        this.j = j;
    }
    private int i;
    private int j;
    public String getCoordinates() {
        return "[" + i + "][" + j + "]";
    }
}
