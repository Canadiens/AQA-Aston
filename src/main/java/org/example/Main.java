package org.example;
class Main {
    public static void main(String[] args) throws MyArraySizeException, MyArrayDataException {
        String[][] myArray = {
                {"3", "425", "31", "k"},
                {"4", "4", "56", "8"},
                {"i", "5", "9", "5"},
                {"3", "14", "25", "199"},
        };
        System.out.println("Сумма значений массива : " + getSum(myArray, 4));
    }
    public static int getSum(String[][] arr, int arraySize) throws MyArrayDataException, MyArraySizeException {
        int result = 0;
        if (arr.length != arraySize) {
            throw new MyArraySizeException();
        }
        for (int i = 0; i < arr.length; i++) {
            if (arr[i].length != arraySize) {
                throw new MyArraySizeException();
            }
            for (int j = 0; j < arr[i].length; ++j) {
                try {
                    result += Integer.parseInt(arr[i][j]);
                } catch (NumberFormatException e) {

                    throw new MyArrayDataException("Задан не верный элемент ", i, j);
                }
            }
        }
        return result;
    }
}