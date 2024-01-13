package org.example;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Phonebook {
    private static Map<Long, String> phonebook = new HashMap<>();

    private static void addContact(Long phoneNumber, String name) {
        phonebook.put(phoneNumber, name);
    }

    public static Set<Long> getPhoneNumbers(String name) {
        Set<Long> phoneNumbers = new HashSet<>();
        for (Map.Entry<Long, String> entry : phonebook.entrySet()) {
            if (entry.getValue().equals(name)) {
                phoneNumbers.add(entry.getKey());
            }
        }
        return phoneNumbers;
    }

    public static void main(String[] args) {

        String nameToFind = "Конор";

        addContact(375295667491L, "Конор");
        addContact(375335894786L, "Конор");
        addContact(375648934586L, "Шумидуб");
        addContact(939292923135L, "Агутин");
        Set<Long> phoneNumbers = getPhoneNumbers(nameToFind);

        if (!phoneNumbers.isEmpty()) {
            System.out.println("Телефонный номер " + nameToFind + ": " + phoneNumbers);
        } else {
            System.out.println("контакта " + nameToFind + " нет в списке");
        }
    }
}