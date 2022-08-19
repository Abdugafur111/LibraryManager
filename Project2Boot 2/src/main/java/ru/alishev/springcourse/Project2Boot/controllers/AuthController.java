package ru.alishev.springcourse.Project2Boot.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.alishev.springcourse.Project2Boot.models.Person1;
import ru.alishev.springcourse.Project2Boot.services.RegistrationService;


import javax.validation.Valid;

/**
 * @author Neil Alishev
 */
@Controller
@RequestMapping("/auth")
public class AuthController {

    private final RegistrationService registrationService;

    @Autowired
    public AuthController(RegistrationService registrationService ) {
        this.registrationService = registrationService;
    }

    @GetMapping("/login")
    public String loginPage() {
        return "auth/login";
    }

    @GetMapping("/registration")
    public String registrationPage(@ModelAttribute("person") Person1 person1) {
        return "auth/registration";
    }

    @PostMapping("/registration")
    public String performRegistration(@ModelAttribute("person") Person1 person1
                                      ) {


        registrationService.register(person1);

        return "redirect:/auth/login";
    }
}
