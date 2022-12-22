// Пусть дан список сотрудников. Написать программу, которая найдет и выведет
// повторяющиеся имена с количеством повторений. Отсортировать по убыванию популярности.

// Чубченко Светлана

import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class main {

    public static void main(String[] args) {
        Map<String, Integer> nameMap = new HashMap<>();

        // задаем имена и фамилии сотрудников
        List<String> employees = Arrays.asList("Иван Иванов", "Светлана Петрова", "Кристина Белова",
        "Анна Мусина", "Анна Крутова", "Иван Юрин", "Петр Лыков", "Павел Чернов", "Петр Чернышов",
        "Мария Федорова", "Марина Светлова", "Мария Савина", "Мария Рыкова", "Марина Лугова",
        "Анна Владимирова", "Иван Мечников", "Петр Петин", "Иван Ежов");
        // переносим их в массив строк
        String[] employeesList = employees.toArray(new String[0]);
        // считаем популярность каждого имени
        for (int i = 0; i < employeesList.length; i++) {
            // разделим имя и фамилию
            String[] employee = employeesList[i].split(" ");
            // считаем популярность имени
            if (nameMap.containsKey(employee[0])) {
                nameMap.replace(employee[0], nameMap.get(employee[0]) + 1);
            } else {
                nameMap.put(employee[0], 1);
            }
        }
        // выводим повторяющиеся имена с количеством повторений
        System.out.println("Имена с количеством повторений:");
        nameMap.entrySet().forEach(entry -> {
            System.out.println(entry.getValue() + " - " + entry.getKey());
        });

        // сортируем
        Map<String, Integer> sortedNameMap = new LinkedHashMap<>();

        int max = 1;
        for (int value : nameMap.values()) {
            if (value > max) {
                max = value;
            }
        }

        for (int i = max; i > 0; i--) {
            for (Map.Entry<String, Integer> entry : nameMap.entrySet()) {
                String key = entry.getKey();
                if (nameMap.get(key) == i) {
                    sortedNameMap.put(key, nameMap.get(key));
                }
            }
        }

        // выводим отсортированные по убыванию популярности
        System.out.println("По убыванию популярности:");
        // повтор кода потому что выше HashMap, а тут LinkedHashMap,
        // чтобы не детектить тип через объект
        sortedNameMap.entrySet().forEach(entry -> {
            System.out.println(entry.getValue() + " - " + entry.getKey());
        });
    }

}

