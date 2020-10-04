package com.company.service;

import com.company.dao.BookDAO;
import com.company.models.Books;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BooksService {
    @Autowired
    private BookDAO bookDAO;

    public void addBooks() {
        bookDAO.createBooks(new Books("The Witcher"));
        bookDAO.createBooks(new Books("Great Expectations"));
        bookDAO.createBooks(new Books("The Great Gatsby"));
        bookDAO.createBooks(new Books("Dracula"));
    }

    public Books getBooksById(Long booksId) {
        return bookDAO.getBooksById(booksId);
    }

    public List<Books> getAllBooks() {
        return bookDAO.getAllBooks();
    }
}
