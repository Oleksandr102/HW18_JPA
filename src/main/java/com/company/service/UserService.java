package com.company.service;

import com.company.dao.BookDAO;
import com.company.dao.UserDAO;
import com.company.models.Books;
import com.company.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {
    @Autowired
    private UserDAO userDAO;

    @Autowired
    private BookDAO bookDAO;

    public void addUsers() {
        createUser(new User("Max", new ArrayList<>()));
        createUser(new User("John", new ArrayList<>()));
        createUser(new User("Ivan", new ArrayList<>()));
        createUser(new User("Petro", new ArrayList<>()));
        createUser(new User("Lola", new ArrayList<>()));

    }

    public User getUserById(Long id) {
        return userDAO.getUserById(id);
    }

    public List<User> getAllUsers() {
        return userDAO.getAllUsers();
    }

    public void createUser(User user) {
        userDAO.createUser(user);
    }

    public void editUser(Long userId, String name) {
        User user = getUserById(userId);

        user.setName(name);

        userDAO.editUser(user);
    }

    public void deleteUser(Long id) {
        userDAO.deleteUser(id);
    }

    public void addUserBook(Long userId, Long bookId) {
        User user = getUserById(userId);
        Books books = bookDAO.getBooksById(bookId);

        List<Books> userBooks = user.getBookList();
        userBooks.add(books);
        books.setOwner(user);
        userDAO.editUser(user);
    }

    public List<Books> getAllUserBooks(Long userId) {
        return getUserById(userId).getBookList();
    }
}
