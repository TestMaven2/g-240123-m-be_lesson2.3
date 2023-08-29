package de.telran.g240123mbe_lesson23.controllers;

import de.telran.g240123mbe_lesson23.entity.CommonUser;
import de.telran.g240123mbe_lesson23.entity.User;
import de.telran.g240123mbe_lesson23.repository.Repository;
import de.telran.g240123mbe_lesson23.service.PasswordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private Repository repository;

    @Autowired
    private PasswordService service;


    @GetMapping
    public List<User> getAllUsers() {
        return repository.getAllUsers();
    }

    @GetMapping("/all/{name}")
    public List<User> getUsersByName(@PathVariable String name) {
        return repository.getUsersByUserName(name);
    }

    @GetMapping("/{name}")
    public User getFirstUserByName(@PathVariable String name) {
        return repository.getFirstUserByUserName(name);
    }

    @PostMapping
    public User addUser(@RequestBody CommonUser user) {
        if (!service.checkPassword(user.getPassword())) {
            System.out.println("Password is too short!");
            return null;
        }

        repository.addUser(user.getName(), user.getPassword());
        return user;
    }
}
