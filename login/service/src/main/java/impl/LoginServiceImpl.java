package impl;

import dao.UserDAO;
import model.User;
import service.LoginService;

import java.util.Collection;

public class LoginServiceImpl implements LoginService {
    private UserDAO userDAO;

    public LoginServiceImpl(UserDAO dao){
        this.userDAO = dao;
    }

    public void createUser(String userName, String password) {
        userDAO.createUser(userName, password);
    }

    public boolean validateUser(String userName, String password) {
        return userDAO.validateUser(userName, password);
    }

    public void deleteUser(String userName) {
        userDAO.deleteUser(userName);
    }

    public Collection<User> all(){
        return userDAO.all();
    }
}
