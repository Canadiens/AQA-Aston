package org.example;
public class Main {
    public static void main(String[] args) {
        Employer[] employee = new Employer[5];
        employee[0] = new Employer("Derkach Yuri", "Medic", "YuriM@mailbox.com", 892312314, 40000, 40);
        employee[1] = new Employer("Ivanov Ivan", "Engineer", "Ivivan@mailbox.com", 892312312, 30000, 30);
        employee[2] = new Employer("Turkin Vasia", "Driver", "Turkin@mailbox.com", 892312732, 33000, 45);
        employee[3] = new Employer("Golovanov Fedor", "Politician", "Golovanov@mail.ru", 754312505, 50000, 42);
        employee[4] = new Employer("Dub Ivan", "Engineer", "dubI@mailbox.com", 892312322, 31000, 41);
    }
}