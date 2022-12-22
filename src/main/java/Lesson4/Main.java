package Lesson4;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        task1();
        task2();
    }

    private static void task1() {
        HashMap<String, Integer> hm = new HashMap<>();
        String[] words = {
                "Кофе", "Чай", "Рис", "Сыр", "Бита", "Луна",
                "Собака", "Кот", "Java", "Земля", "Бот", "Кофе",
                "Собака", "Бита", "Луна", "Кот", "Java", "Земля", "Собака"
        };

        for (int i = 0; i < words.length; i++) {
            if (hm.containsKey(words[i]))
                hm.put(words[i], hm.get(words[i]) + 1);
            else
                hm.put(words[i], 1);
        }
        System.out.println(hm);
    }

    private static void task2() {
        Directory directory = new Directory();

        directory.add("Иванов", "8999123321");
        directory.add("Иванов", "8912155326");
        directory.add("Петров", "8917155552");
        directory.add("Петров", "8913455672");
        directory.add("Иванов", "899999999");
        directory.add("Сидоров", "899111111");
        directory.add("Петров", "89923231999");
        directory.add("Попов", "8888123113");
        directory.add("Сидоров", "8324325234");

        System.out.println(directory.get("Иванов"));
        System.out.println(directory.get("Сидоров"));
        System.out.println(directory.get("Петров"));
        System.out.println(directory.get("Попов"));
    }
}

class Directory {
    private HashMap<String, List<String>> directory_hm = new HashMap<>();
    private List<String> phone_number_list;

    public void add(String surname, String phone_number) {
        if (directory_hm.containsKey(surname)) {
            phone_number_list = directory_hm.get(surname);
            phone_number_list.add(phone_number);
            directory_hm.put(surname, phone_number_list);
        } else {
            phone_number_list = new ArrayList<>();
            phone_number_list.add(phone_number);
            directory_hm.put(surname, phone_number_list);
        }
    }

    public List<String> get(String surname) {
        return directory_hm.get(surname);
    }

}

