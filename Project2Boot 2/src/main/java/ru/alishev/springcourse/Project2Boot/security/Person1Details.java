package ru.alishev.springcourse.Project2Boot.security;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import ru.alishev.springcourse.Project2Boot.models.Person1;

import java.util.Collection;
import java.util.Collections;

/**
 * @author Neil Alishev
 */
public class Person1Details implements UserDetails {
    private final Person1 person1;

    public Person1Details(Person1 person1) {
        this.person1 = person1;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        // SHOW_ACCOUNT, WITHDRAW_MONEY, SEND_MONEY
        // ROLE_ADMIN, ROLE_USER - это роли
        return Collections.singletonList(new SimpleGrantedAuthority(person1.getRole()));
    }

    @Override
    public String getPassword() {
        return this.person1.getPassword();
    }

    @Override
    public String getUsername() {
        return this.person1.getUsername();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

    // Нужно, чтобы получать данные аутентифицированного пользователя
    public Person1 getPerson() {
        return this.person1;
    }
}
