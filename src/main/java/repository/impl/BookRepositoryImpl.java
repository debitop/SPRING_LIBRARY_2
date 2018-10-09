package repository.impl;

import model.Book;
import model.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import repository.BookRepository;

import java.util.List;

@Repository
@Transactional
public class BookRepositoryImpl implements BookRepository {

    @Autowired
    SessionFactory sessionFactory;

    // TODO: 09.10.2018 merge persist
    @Override
    public void addBook(Book book, Integer studentId) {
        Session session = sessionFactory.getCurrentSession();
        book.setStudent(session.get(Student.class, studentId));
        session.merge(book);
    }

    @Override
    public void removeBook(Integer bookId) {
        Session session = sessionFactory.getCurrentSession();
        Book book = session.get(Book.class, bookId);
        session.delete(book);
    }

    @Override
    public void editBook(Book book) {
        Session session = sessionFactory.getCurrentSession();
        Book bookOld = session.get(Book.class, book.getId());
        bookOld.setAuthor(book.getAuthor());
        bookOld.setTitle(book.getTitle());
        session.update(bookOld);
    }

    @Override
    public List<Book> listBook(Integer studentId) {
        Session session = sessionFactory.getCurrentSession();

        return session.createQuery("from Book b where b.student.id=:studentId").setParameter("studentId", studentId).list();
    }

    @Override
    public Book bookById(Integer bookId) {
        Session session = sessionFactory.getCurrentSession();
        return session.get(Book.class, bookId);
    }
}
