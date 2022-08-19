package ru.alishev.springcourse.Project2Boot.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.alishev.springcourse.Project2Boot.models.Person1;
import ru.alishev.springcourse.Project2Boot.repositories.People1Repository;


/**
 * @author Neil Alishev
 */
@Service
public class RegistrationService {

    private final People1Repository people1Repository;
    private final PasswordEncoder passwordEncoder;

    @Autowired
    public RegistrationService(People1Repository people1Repository, PasswordEncoder passwordEncoder) {
        this.people1Repository = people1Repository;
        this.passwordEncoder = passwordEncoder;
    }

    @Transactional
    public void register(Person1 person1) {
        person1.setPassword(passwordEncoder.encode(person1.getPassword()));
        person1.setRole("ROLE_USER");
        people1Repository.save(person1);
    }
}
