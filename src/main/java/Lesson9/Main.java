package Lesson9;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
        List<Student> students = new ArrayList<>();
        students.add(new Student("Антон", Arrays.asList(new Course("Культура"),
                new Course("Информатика"), new Course("Биология"), new Course("Физика"))));
        students.add(new Student("Оксана", Arrays.asList(new Course("Информатика"),
                new Course("Биология"), new Course("Физика"))));
        students.add(new Student("Иван", Arrays.asList(new Course("Информатика"),
                new Course("Биология"))));
        students.add(new Student("Тимур", Arrays.asList(new Course("Информатика"),
                new Course("Культура"), new Course("Экономика"), new Course("Биология"),
                new Course("Физика"))));


        System.out.println(students.stream()
                .map(s -> s.getCourses())
                .flatMap(c -> c.stream())
                .map(c -> c.getName())
                .collect(Collectors.toSet()));



        System.out.println(students.stream()
                .sorted((s1, s2) -> s2.getCourses().size() - s1.getCourses().size())
                .limit(3)
                .collect(Collectors.toList()));



        Course course = new Course("Культура");
        System.out.println(students.stream()
                .filter(s -> s.getCourses().contains(course))
                .collect(Collectors.toList()));

    }
}
