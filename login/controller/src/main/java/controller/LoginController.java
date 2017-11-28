package controller;

import model.User;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.stereotype.Controller;
import service.LoginService;

import java.util.Collection;

@Controller
public class LoginController {
    private LoginService loginService;

    public LoginController(LoginService loginService) {
        this.loginService = loginService;
    }

    @RequestMapping(value = {"/login/createuser"})
    @ResponseBody
    public void createUser(@RequestParam("username") String userName, @RequestParam(value = "password") String password){
        loginService.createUser(userName, password);
    }

    @RequestMapping(value = {"/login/deleteuser"})
    @ResponseBody
    public void deleteUser(@RequestParam("username") String userName){
        loginService.deleteUser(userName);
    }

    @RequestMapping(value = {"/login/validateuser"})
    @ResponseBody
    public boolean validateUser(@RequestParam("username") String userName, @RequestParam(value = "password") String password){
        return loginService.validateUser(userName, password);
    }

    @RequestMapping(value = {"/login/all"})
    @ResponseBody
    public Collection<User> all(){
        return loginService.all();
    }
}
