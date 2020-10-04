package com.company;

import com.company.config.Config;
import com.company.service.BooksService;
import com.company.service.UserService;
import com.company.web.Menu;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Executor {
    public static void run(){
        var context = new AnnotationConfigApplicationContext(Config.class);

        UserService userService = context.getBean(UserService.class);
        userService.addUsers();

        BooksService booksService = context.getBean(BooksService.class);
        booksService.addBooks();

        Menu menu = context.getBean(Menu.class);
        menu.dropMenu();
    }
}
