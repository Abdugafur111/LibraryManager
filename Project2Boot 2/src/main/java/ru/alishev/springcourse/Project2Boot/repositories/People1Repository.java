package ru.alishev.springcourse.Project2Boot.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.alishev.springcourse.Project2Boot.models.Person1;

import java.util.Optional;

/**
 * @author Neil Alishev
 */
@Repository
public interface People1Repository extends JpaRepository<Person1, Integer> {
    Optional<Person1> findByUsername(String username);
}
