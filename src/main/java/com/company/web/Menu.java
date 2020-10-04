package com.company.web;

import com.company.models.User;
import com.company.service.BooksService;
import com.company.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Scanner;

@Component
public class Menu {
    @Autowired
    UserService userService;
    @Autowired
    BooksService booksService;

    public Menu(UserService userService) {
        this.userService = userService;
    }

    private Scanner scr = new Scanner(System.in);

    private String[] items = {
            "1. Show users.",
            "2. Find user by id.",
            "3. Add user.",
            "4. Edit user.",
            "5. Delete user.",
            "6. Add book.",
            "7. Show user books.",
            "8. Exit."};


    public void dropMenu() {
        showOptions(items);
        System.out.println();
        System.out.println("*~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*");
        System.out.print("Please make a choice: ");
        String choice = scr.next();
         switch (choice) {
            case "1" -> {
                displayUsers();
            }
            case "2" -> {
                displayUserById();
            }
            case "3" -> {
                addUser();
            }
            case "4" -> {
                editUser();
            }
            case "5" -> {
                deleteUser();
            }
            case "6" -> {
                addBook();
            }
            case "7" -> {
                showUserBooks();
            }
            case "8" -> {
                System.exit(0);
            }
            default -> {
                dropMenu();
            }
        }
    }


    private void showOptions(String[] items) {
        for (String item : items) {
            System.out.println(item);
        }
    }

    public void displayUsers() {
        System.out.println("User List:");
        userService.getAllUsers().forEach(System.out::println);
        dropMenu();
    }

    public void displayUserById() {
        System.out.println("Enter userID:");
        Long id = Long.valueOf(scr.next());
        System.out.println(userService.getUserById(id));
        dropMenu();
    }

    public void addUser() {
        System.out.println("Enter user name:");
        String name = scr.next();
        userService.createUser(new User(name, new ArrayList<>()));
        dropMenu();
    }

    public void editUser() {
        System.out.println("Enter userID:");
        Long id = scr.nextLong();

        System.out.println("Enter new name:");
        String name = scr.next();

        userService.editUser(id, name);
        dropMenu();
    }

    public void deleteUser() {
        System.out.println("Enter userID:");
        Long id = scr.nextLong();
        userService.deleteUser(id);
        dropMenu();
    }

    public void addBook() {
        System.out.println("Enter userID:");
        Long id = scr.nextLong();

        System.out.println("Available books:");
        booksService.getAllBooks().forEach(System.out::println);

        System.out.println("Enter bookID:");
        Long bookId = scr.nextLong();

        userService.addUserBook(id, bookId);
        dropMenu();
    }

    public void showUserBooks() {
        System.out.println("Enter userID:");
        Long id = scr.nextLong();

        System.out.println("User book list:");
        userService.getAllUserBooks(id).forEach(System.out::println);
        dropMenu();
    }
}

