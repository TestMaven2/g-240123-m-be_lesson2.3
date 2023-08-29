package de.telran.g240123mbe_lesson23.database;

import de.telran.g240123mbe_lesson23.entity.User;

import java.sql.SQLException;
import java.util.List;

public interface DataBase {

    void execute(String query) throws SQLException;

    List<User> select(String query) throws SQLException;
}
