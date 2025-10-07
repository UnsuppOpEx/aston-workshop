package aston.task1.stream_api;

import java.util.Objects;

public class Book {
    private final String title;
    private final String author;
    private final Integer publisherYear;
    private final Integer pageCount;

    public Book(String title, String author, Integer publisherYear, Integer pageCount) {
        this.title = title;
        this.author = author;
        this.publisherYear = publisherYear;
        this.pageCount = pageCount;
    }

    public Integer getPublisherYear() {
        return publisherYear;
    }

    public Integer getPageCount() {
        return pageCount;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Book book = (Book) o;
        return Objects.equals(title, book.title) && Objects.equals(author, book.author) && Objects.equals(publisherYear, book.publisherYear) && Objects.equals(pageCount, book.pageCount);
    }

    @Override
    public int hashCode() {
        return Objects.hash(title, author, publisherYear, pageCount);
    }

    @Override
    public String toString() {
        return "Book{" +
                "title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", publisherYear=" + publisherYear +
                ", pageCount=" + pageCount +
                '}';
    }
}
