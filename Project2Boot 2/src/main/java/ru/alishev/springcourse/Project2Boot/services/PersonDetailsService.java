package ru.alishev.springcourse.Project2Boot.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import ru.alishev.springcourse.Project2Boot.models.Person1;
import ru.alishev.springcourse.Project2Boot.repositories.People1Repository;
import ru.alishev.springcourse.Project2Boot.security.Person1Details;


import java.util.Optional;

/**
 * @author Neil Alishev
 */
@Service
public class PersonDetailsService implements UserDetailsService {

    private final People1Repository people1Repository;

    @Autowired
    public PersonDetailsService(People1Repository people1Repository) {
        this.people1Repository = people1Repository;
    }

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        Optional<Person1> person = people1Repository.findByUsername(s);

        if (person.isEmpty())
            throw new UsernameNotFoundException("User not found");

        return new Person1Details(person.get());
    }
}
