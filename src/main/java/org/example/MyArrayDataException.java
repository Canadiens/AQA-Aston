package org.example;
public class MyArrayDataException extends Throwable {
    public MyArrayDataException(String s, int i, int j) {
        super(s + "[" + i + "][" + j + "]");
    }
}