package org.example;

import org.example.homework1.stream_api.Book;
import org.example.homework1.stream_api.Student;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

public class Main {
    public static void main(String[] args) {
        List<Student> studentList = new ArrayList<>();

        int count = 1;
        while (count <= 5) {
            List<Book> books = new ArrayList<>();
            for (int j = 1; j <= 5; j++) {
                books.add(new Book(
                        "Book" + j + "_S" + count,
                        "Author" + j,
                        1998 + j,
                        100 + j * 10
                ));
            }

            String studentName = String.format("Student%d", count);
            int age = 20 + count;
            String gender = (count % 2 == 0) ? "female" : "male";

            Student student = new Student(studentName, age, gender, books);
            studentList.add(student);
            count++;
        }

        Optional<Book> needBook = studentList.stream()
                .peek(System.out::println)
                .flatMap(student -> student.getBooks().stream().sorted(Comparator.comparingInt(Book::getPageCount)))
                .distinct()
                .filter(book -> book.getPublisherYear() > 2000)
                .limit(3)
                .peek(System.out::println)
                .findAny();

        if (needBook.isPresent()) {
            System.out.println(needBook.get().getPublisherYear());
        } else
            System.out.println("Book not found");
    }

}

