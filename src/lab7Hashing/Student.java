package lab7Hashing;

import java.util.List;
import java.util.Objects;

public class Student {
    private String name;
    private String surname;
    private int age;
    private List<Integer> grades;

    public Student(String name, String surname, int age, List<Integer> grades) {
        this.name = name;
        this.surname = surname;
        this.age = age;
        this.grades = grades;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public int getAge() {
        return age;
    }

    public List<Integer> getGrades() {
        return grades;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return age == student.age && Objects.equals(name, student.name) && Objects.equals(surname, student.surname) && Objects.equals(grades, student.grades);
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", age=" + age +
                '}';
    }
}
