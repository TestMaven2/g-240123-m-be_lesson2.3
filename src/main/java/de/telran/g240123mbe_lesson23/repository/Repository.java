package de.telran.g240123mbe_lesson23.repository;

import de.telran.g240123mbe_lesson23.entity.User;

import java.util.List;

public interface Repository {

    List<User> getAllUsers();

    List<User> getUsersByUserName(String name);

    User getFirstUserByUserName(String name);

    void addUser(String name, String password);
}
