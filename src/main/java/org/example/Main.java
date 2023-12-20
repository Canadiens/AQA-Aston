package org.example;

public class Main {
    public static void main(String[] args) {
        // задание 6
        int[] arr = new int[]{1, 1, 0, 0, 1, 0, 1, 1, 0, 0};

        {
            for (int i = 0; i < arr.length; i++) {
                if (arr[i] > 0) {
                    arr[i] = arr[i] - 1;
                } else {
                    arr[i] = arr[i] + 1;
                }
                System.out.println(arr[i]);
            }
        }
        // задание 7
        int[] arr2 = new int[100];
        for (int i = 0; i < arr2.length; i++) {
            arr2[i] = i + 1;
            System.out.println(arr2[i]);
        }
        // задание 8
        int[] arr3 = {1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1};
        for (int k = 0; k < arr3.length; k++) {
            if (arr3[k] < 6) {
                arr3[k] = arr3[k] * 2;
            }
            System.out.println(arr3[k]);
        }
        // задание 9
        int[][] arr4 = new int[5][5];
        for (int i = 0; i < arr4.length; i++) {
            for (int j = 0; j < arr4[i].length; j++) {
                arr4[i][j] = (i == j) || (i + j == arr4.length - 1) ? 1 : 0;
            }
        }
        for (int i = 0; i < arr4.length; i++) {
            for (int j = 0; j < arr4[i].length; j++) {
                System.out.print(arr4[i][j]);
            }
            System.out.println();
        }
        isTrue(5, 5);
        printNumber(0);
        integerNumber(123);
        printString("Me", 3);
        isYear(2001);
        backArray(9, 1510);
    }
       // задание 1
      public static boolean isTrue(int a, int b) {
        int sum = a + b;
        boolean res = (sum >= 10 && sum <= 20);
        System.out.println(res);
        return res;
    }
        // задание 2
        public static int printNumber(int a) {
            if (a >= 0) {
                System.out.println("Положительное число");

            } else {
                System.out.println("Отрицательное число");
            }
            return a;
        }
        // задание 3
          public static int integerNumber(int f) {
              if (f < 0) {
                  System.out.println(true);
              } else {
                  System.out.println(false);
              }
              return f;
          }
        // задание 4
            public static void printString (String inputString,int numberOfTimes){
                for (int i = 0; i < numberOfTimes; i++) {
                    System.out.println(inputString);
              }
        }
        // задание 5
            public static void isYear ( int year){
               if ((year % 4 == 0 && year % 100 != 0) || (year % 400 == 0)) {
                   System.out.println("Год высокосный");
               } else {
                   System.out.println("Год не высокосный");
               }
        }
           // задание 10
        public static void backArray (int len, int initialValue){
            int[] array = new int[len];
            for (int i = 0; i < array.length; i++) {
                array[i] = initialValue;
                System.out.println(array[i]);
            }
        }
}