package controller;


import model.Book;
import model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import repository.BookRepository;

import java.util.List;

@Controller
@RequestMapping(value = "/book")
public class BookController {

    @Autowired
    BookRepository bookRepository;

    @RequestMapping(method = RequestMethod.GET, value = "/bookList/{studentId}")
    public String listBook(@PathVariable("studentId") Integer studentId, Model model) {
        List<Book> books = bookRepository.listBook(studentId);
        model.addAttribute("books", books);
        return "bookList";
    }

    @RequestMapping(method = RequestMethod.GET, value = "/editBook/{bookId}")
    public String editBook(@PathVariable("bookId") Integer bookId, Model model) {
        Book book = bookRepository.bookById(bookId);
        model.addAttribute("book", book);
        return "bookEdit";
    }


    @RequestMapping(method = RequestMethod.POST, value = "/editBook/{bookId}")
    public String editBook(@PathVariable("bookId") Integer bookId, @RequestParam("author") String author, @RequestParam("title") String title, Model model) {
        Book book = bookRepository.bookById(bookId);
        book.setAuthor(author);
        book.setTitle(title);
        bookRepository.editBook(book);
        Integer studentId = book.getStudent().getId();
        model.addAttribute("studentId", studentId);
        return "redirect:/book/bookList/{studentId}";
    }

    @RequestMapping(method = RequestMethod.GET, value = "/removeBook/{bookId}")
    public String removeBook(@PathVariable("bookId") Integer bookId, Model model) {
        Integer studentId = bookRepository.bookById(bookId).getStudent().getId();
        bookRepository.removeBook(bookId);
        model.addAttribute("studentId", studentId);
        return "redirect:/book/bookList/{studentId}";
    }

    @RequestMapping(method = RequestMethod.GET, value = "/addBook/{studentId}")
    public String addBook(@PathVariable("studentId") Integer studentId, Model model) {
        model.addAttribute("studentId", studentId);
        return "bookAdd";
    }

    @RequestMapping(method = RequestMethod.POST, value = "/addBook/{studentId}")
    public String addBook(@PathVariable("studentId") Integer studentId, @RequestParam("author") String author, @RequestParam("title") String title) {
        Book book = new Book();
        book.setTitle(title);
        book.setAuthor(author);
        bookRepository.addBook(book, studentId);
        return "redirect:/book/bookList/{studentId}";
    }

}
