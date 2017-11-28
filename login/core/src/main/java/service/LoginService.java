package service;

import model.User;

import java.util.Collection;

public interface LoginService {
    void createUser(String userName, String password);
    boolean validateUser(String userName, String password);
    void deleteUser(String userName);
    Collection<User> all();
}
