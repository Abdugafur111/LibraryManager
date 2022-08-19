package ru.alishev.springcourse.Project2Boot.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import ru.alishev.springcourse.Project2Boot.security.Person1Details;
import ru.alishev.springcourse.Project2Boot.services.AdminService;
import ru.alishev.springcourse.Project2Boot.services.BooksService;
import ru.alishev.springcourse.Project2Boot.services.PeopleService;


/**
 * @author Neil Alishev
 */
@Controller
public class HelloController {
    private final AdminService adminService;

    private final BooksService booksService;
    private final PeopleService peopleService;


    @Autowired
    public HelloController(AdminService adminService, BooksService booksService, PeopleService peopleService) {
        this.adminService = adminService;
        this.booksService = booksService;
        this.peopleService = peopleService;
    }

    @GetMapping("/hello")
    public String sayHello() {
        return "hello";
    }

    @GetMapping("/showUserInfo")
    public String showUserInfo() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        Person1Details person1Details = (Person1Details) authentication.getPrincipal();
        System.out.println(person1Details.getPerson());

        return "hello";
    }

    @GetMapping("/admin")
    public String adminPage() {
        //adminService.doAdminStuff();
        return "admin";
    }
    @GetMapping("/indexAdmin")
    public String adminIndexBook(Model model){
        model.addAttribute("books", booksService.findAll()); // выдача всех книг

        return "books/indexAdmin";
    }


}
