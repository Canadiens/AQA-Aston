package org.example;
import java.util.*;
import java.util.stream.Collectors;

public class Students {
    public enum Gender {
        MAN, WOMAN
    }
    private static class Student {
        private final String name;
        private final Integer age;
        private final Gender gender;
        public Student(String name, Integer age, Gender gender) {
            this.name = name;
            this.age = age;
            this.gender = gender;
        }

        public String getName() {
            return name;
        }
        public Integer getAge() {
            return age;
        }
        public Gender getGender() {
            return gender;
        }

        public String toString() {
            return "{" + "name='" + name + '\'' + ",age=" + age + ", gender=" + gender + '}';
        }

        public boolean equals(Object o) {
            if (this == o) return true;
            if (!(o instanceof Student)) return false;
            Student student = (Student) o;
            return Objects.equals(name, student.name) &&
                    Objects.equals(age, student.age) &&
                    Objects.equals(gender, student.gender);
        }

        public int hashCode() {
            return Objects.hash(name, age, gender);
        }
    }

    public static void main(String[] args) {
        Collection<Student> students = Arrays.asList(
                new Student("Дмитрий", 17, Gender.MAN),
                new Student("Максим", 20, Gender.MAN),
                new Student("Екатерина", 20, Gender.WOMAN),
                new Student("Михаил", 28, Gender.MAN)
        );

        Map<Gender, Double> averageAge = students.stream()
                .filter(student -> student.getGender() == Gender.MAN)
                .collect(
                        Collectors.groupingBy(Student::getGender,
                                Collectors.averagingInt(Student::getAge))
                );
        Map<String, List<Student>> getAgenda = students.stream()
                .filter(student -> student.getGender() == Gender.MAN && student.getAge() > 17 && student.getAge() < 28)
                .collect(Collectors.
                        groupingBy(Student::getName));
        averageAge.forEach((k, v) -> System.out.println(v));
        getAgenda.forEach((k, v) -> System.out.println(k));
    }
}
