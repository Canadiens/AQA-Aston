package org.example;
public class Employer {
   private String name;
   private String position;
   private String email;
   private int phoneNumber;
   private double salary;
   private int age;

   public Employer(String name,  String position, String email, int phoneNumber, double salary, int age ) {
      this.name = name;
      this.position = position;
      this.email = email;
      this.phoneNumber = phoneNumber;
      this.salary = salary;
      this.age = age;
   }
   public String toString() {
      return "Name: " + name + "\nPosition: " + position + "\nEmail: " + email +
              "\nPhone Number: " + phoneNumber + "\nSalary: " + salary + "\nAge: " + age;
   }
   public static void printInformation(Employer employer){
      System.out.println(employer);
   }
}
