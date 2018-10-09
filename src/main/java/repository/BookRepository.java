package repository;

import model.Book;

import java.util.List;

public interface BookRepository {


    public void addBook(Book book, Integer studentId);

    public void removeBook(Integer bookId);

    public void editBook(Book book);

    public List<Book> listBook(Integer studentId);

    public Book bookById(Integer bookId);
}
