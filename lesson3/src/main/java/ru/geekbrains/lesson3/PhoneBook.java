package ru.geekbrains.lesson3;

/**
    Реализуйте структуру телефонной книги с помощью HashMap,
    учитывая, что 1 человек может иметь несколько телефонов. 
    Нужны методы добавления новой записи в книгу и метод поиска записей в телефонной книге
 */


import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class PhoneBook {

    private Map<String, Set<String>> phoneBook;

    public PhoneBook() {
        phoneBook = new HashMap<>();
    }

    public void addContact(String name, String phone) {
        if (!phoneBook.containsKey(name)) {
            phoneBook.put(name, new HashSet<>());
        }
        phoneBook.get(name).add(phone);
    }

    public Set<String> getPhones(String name) {
        return phoneBook.getOrDefault(name, new HashSet<>());
        // return phoneBook.get(name);
    }

    public static void main(String[] args) {
        PhoneBook phoneBook = new PhoneBook();

        phoneBook.addContact("Иванов Петр", "123-456-7890");
        phoneBook.addContact("Иванов Петр", "098-765-4321");
        phoneBook.addContact("Сидоров Иван", "555-123-4567");

        System.out.println(phoneBook.getPhones("Иванов Петр"));
    }
}
