package hw9;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) {
        List<Student> students = new ArrayList<>();
        students.add(new Student("Fedia", Arrays.asList(new Course("1c"),
                new Course("Pyton"),
                new Course("Testing"))));
        students.add(new Student("Vasia", Arrays.asList(new Course("1c"),
                new Course("Java"),
                new Course("CyberSecurity"),
                new Course("Testing"))));
        students.add(new Student("Natasha", Arrays.asList(new Course("Management"),
                new Course("English"),
                new Course("C#"),
                new Course("Testing"))));

        System.out.println(students.stream()
                .map(s -> s.getCourses())
                .flatMap(f -> f.stream())
                .collect(Collectors.toSet()));

        System.out.println(students.stream()
                .sorted((s1, s2) -> s2.getCourses().size() - s1.getCourses().size())
                .limit(2)
                .collect(Collectors.toList()));

        Course course = new Course("Testing");
        System.out.println(students.stream()
                .filter(s -> s.getCourses().contains(course))
                .collect(Collectors.toList()));
    }
}
