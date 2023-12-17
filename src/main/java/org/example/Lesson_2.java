package org.example;

public class Lesson_2 {
     static void printThreeWords(){
       String fruit = "Orange\nBanana\nApple";
        System.out.println(fruit);

    }
    static void checkSumSing(){
    int a = 10;
    int b = -100;
    if(a + b >= 0) {
        System.out.println("Сумма положительная");
    }
    else {
        System.out.println("Сумма отрицательная");
        }
    }
    static void printColor (){
         int value = 101;
         if(value <= 0){
             System.out.println("Красный");
         }
         else if (0 < value && value <= 100) {
             System.out.println("Желтый");
         }
         else{
            System.out.println("Зеленый");
        }
    }
    static void compareNumber(){
         int a = 121354;
         int b = 121384;
         if(a >= b){
             System.out.println("a >= b");
         }
         else{
             System.out.println("a < b");
         }
    }
}

