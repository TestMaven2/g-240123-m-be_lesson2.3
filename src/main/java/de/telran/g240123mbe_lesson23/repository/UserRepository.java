package de.telran.g240123mbe_lesson23.repository;

import de.telran.g240123mbe_lesson23.database.DataBase;
import de.telran.g240123mbe_lesson23.entity.User;
import org.springframework.beans.factory.annotation.Autowired;

import java.sql.SQLException;
import java.util.List;

public class UserRepository implements Repository {

    @Autowired
    private DataBase dataBase;

    @Override
    public List<User> getAllUsers() {
        try {
            return dataBase.select("Select *");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<User> getUsersByUserName(String name) {
        try {
            return dataBase.select("Select * where name = " + name);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public User getFirstUserByUserName(String name) {
        try {
            return dataBase.select("Select * where name = " + name).get(0);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void addUser(String name, String password) {
        try {
            dataBase.execute(String.format("Add user name = %s password = %s", name, password));
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
