package org.example.homework1.stream_api;

import java.util.List;
import java.util.Objects;

public class Student {
    private String name;
    private int age;
    private String gender;
    private List<Book> books;

    public Student(String name, int age, String gender, List<Book> books) {
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.books = books;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public List<Book> getBooks() {
        return books;
    }

    public void setBooks(List<Book> books) {
        this.books = books;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return age == student.age && Objects.equals(name, student.name) && Objects.equals(gender, student.gender) && Objects.equals(books, student.books);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, age, gender, books);
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", gender='" + gender + '\'' +
                '}';
    }
}
