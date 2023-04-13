package perscholas.SpringSoapDemo.controller;

import com.perscholas.xml.book.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;
import perscholas.SpringSoapDemo.dao.BookRepository;

@Controller
public class RestController {

    @Autowired
    BookRepository bookRepository;

    @ResponseBody
    @GetMapping("/getBook/{id}")
    public Book getBook(@PathVariable int id) {
        Book book = bookRepository.findBookById(id);
        return book;
    }
}
