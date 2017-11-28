package impl;

import dao.UserDAO;
import model.User;

import java.util.ArrayList;
import java.util.Collection;

public class UserDAOImpl implements UserDAO {
    private Collection<User> users;

    public UserDAOImpl(){
        users = new ArrayList<User>();
        users.add(new User("peter", "peter"));
    }

    public void createUser(String userName, String password) {
        User newUser = new User(userName, password);
        users.add(newUser);
    }

    public boolean validateUser(String userName, String password) {
        boolean isValid = false;

        for (User user : users){
            if (user.getUserName().equals(userName)){
                if(user.getPassword().equals(password)){
                    isValid = true;
                    break;
                }
            }
        }

        return isValid;
    }

    public void deleteUser(String userName) {
        for (User user : users){
            if (user.getUserName().equals(userName)){
                users.remove(user);
                break;
            }
        }
    }

    public Collection<User> all(){
        return users;
    }
}
