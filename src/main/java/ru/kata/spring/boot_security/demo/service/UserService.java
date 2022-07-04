package ru.kata.spring.boot_security.demo.service;

import ru.kata.spring.boot_security.demo.models.User;

import java.util.Set;

public interface UserService {

    void saveUser(User user);

    Set<User> listUsers();

    User getUserById(long id);

    void deleteUserById(long id);

    User findByUsername(String username);

}
