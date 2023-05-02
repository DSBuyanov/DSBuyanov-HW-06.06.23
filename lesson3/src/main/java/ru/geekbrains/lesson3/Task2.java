package ru.geekbrains.lesson3;

import java.util.*;

/**
 * Пусть дан список сотрудников: Иван Иванов, Светлана Петрова, Кристина Белова,
 * Анна Мусина,
 * Анна Крутова, Иван Юрин, Петр Лыков, Павел Чернов, Петр Чернышов, Мария
 * Федорова, Марина Светлова,
 * Мария Савина, Мария Рыкова, Марина Лугова, Анна Владимирова, Иван Мечников,
 * Петр Петин, Иван Ежов.
 * Написать программу, которая найдет и выведет повторяющиеся имена с
 * количеством повторений.
 * Отсортировать по убыванию популярности. Для сортировки использовать TreeMap.
 */

public class Task2 {

    public static void main(String[] args) {

        List<String> employees = Arrays.asList("Иван Иванов", "Светлана Петрова", "Кристина Белова", "Анна Мусина",
                "Анна Крутова", "Иван Юрин", "Петр Лыков", "Павел Чернов", "Петр Чернышов", "Мария Федорова",
                "Марина Светлова", "Мария Савина", "Мария Рыкова", "Марина Лугова", "Анна Владимирова", "Иван Мечников",
                "Петр Петин", "Иван Ежов");

        Map<String, Integer> countMap = new HashMap<>();

        for (String employee : employees) {
            String name = employee.split(" ")[0];
            countMap.compute(name, (k, v) -> (v == null) ? 1 : v + 1);
        }

        TreeMap<Integer, List<String>> sortedMap = new TreeMap<>(Collections.reverseOrder());

        countMap.forEach((name, count) -> {
            List<String> list = sortedMap.getOrDefault(count, new ArrayList<>());
            list.add(name);
            sortedMap.put(count, list);
        });

        sortedMap.forEach((count, names) -> {
            System.out.println(names + ": " + count);
        });
    }
}