package com.company.dao;

import com.company.models.Books;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public class BookDAO {

    @Autowired
    private SessionFactory sessionFactory;

    private Session getCurrentSession() {
        return sessionFactory.getCurrentSession();
    }

    @Transactional
    public void createBooks(Books books) {
        getCurrentSession().persist(books);
    }

    @Transactional
    public Books getBooksById(Long booksId) {
        return getCurrentSession().get(Books.class, booksId);
    }

    @Transactional
    public List<Books> getAllBooks() {
        return getCurrentSession().createQuery("SELECT b FROM Books b").list();
    }

}
