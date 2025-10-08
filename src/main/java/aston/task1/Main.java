package aston.task1;

import aston.task1.stream_api.Book;
import aston.task1.stream_api.Student;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        final List<Student> studentList = new ArrayList<>();

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

            final String studentName = String.format("Student%d", count);
            final int age = 20 + count;
            final String gender = (count % 2 == 0) ? "female" : "male";

            final Student student = new Student(studentName, age, gender, books);
            studentList.add(student);
            count++;
        }

        studentList.stream()
                .peek(System.out::println)
                .map(Student::getBooks)
                .flatMap(List::stream)
                .sorted(Comparator.comparingInt(Book::getPageCount))
                .distinct()
                .filter(book -> book.getPublisherYear() > 2000)
                .limit(3)
                .peek(System.out::println)
                .findAny()
                .map(Book::getPublisherYear)
                .ifPresentOrElse(System.out::println, () -> System.out.println("Book not found"));
    }
}
