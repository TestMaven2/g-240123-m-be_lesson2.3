package de.telran.g240123mbe_lesson23.service;

public class SimplePasswordService implements PasswordService {
    @Override
    public boolean checkPassword(String password) {
        return password.length() >= 5;
    }
}
