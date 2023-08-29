package de.telran.g240123mbe_lesson23.database;

import de.telran.g240123mbe_lesson23.entity.CommonUser;
import de.telran.g240123mbe_lesson23.entity.User;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class CommonDataBase implements DataBase {

    private List<User> users = new ArrayList<>();

    public CommonDataBase() {
        users.add(new CommonUser("Vanya", "qwerty"));
        users.add(new CommonUser("Petya", "asdfgh"));
        users.add(new CommonUser("Petya", "lkjhgf"));
        users.add(new CommonUser("Sidor", "zxcvbn"));
    }

    @Override
    public void execute(String query) throws SQLException {
        // Add user name = Vasya password = qwerty
        if (!query.startsWith("Add")) {
            throw new SQLException();
        }

        String[] parts = query.split(" ");
        users.add(new CommonUser(parts[4], parts[7]));
    }

    @Override
    public List<User> select(String query) throws SQLException {
        // Select *
        // Select * where name = Vasya

        if (!query.startsWith("Select")) {
            throw new SQLException();
        }

        String[] parts = query.split(" ");
        if (parts.length == 2) {
            return users;
        } else {
            return users.stream().filter(x -> x.getName().equals(parts[5])).collect(Collectors.toList());
        }
    }
}
