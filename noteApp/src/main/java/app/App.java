package app;

import com.sun.xml.internal.ws.policy.privateutil.PolicyUtils;
import gateway.Gateway;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Collection;
import java.util.Date;

public class App 
{
    public static void main( String[] args )
    {
        boolean isValid = false;
        ApplicationContext context = null;
        try {
            context = new ClassPathXmlApplicationContext("/si-config.xml");
        }
        catch (Exception exception){
            exception.printStackTrace();
            System.exit(0);
        }
        Gateway gateway = context.getBean("Gateway", Gateway.class);

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        while (true){
            System.out.print("> ");
            String command = "";

            try {
                command = bufferedReader.readLine();
            }
            catch (IOException exception){
                exception.printStackTrace();
                break;
            }

            if(command.equals("")){
                break;
            }

            if(command.equals("login")){
                String userName = "";
                String password = "";
                System.out.print("username: ");
                try {
                    userName = bufferedReader.readLine();
                }
                catch (IOException exception){
                    exception.printStackTrace();
                }

                System.out.print("password: ");
                try {
                    password = bufferedReader.readLine();
                }
                catch (IOException exception){
                    exception.printStackTrace();
                }

                isValid = gateway.validateUser(userName, password);

                if(isValid){
                    System.out.println("You are logged in!");
                }
            }

            if (!isValid){
                System.out.println("You must login first!");
                continue;
            }

            if(command.equals("add")){
                String name = "";
                String content = "";
                System.out.print("name: ");
                try {
                    name = bufferedReader.readLine();
                }
                catch (IOException exception){
                    exception.printStackTrace();
                }

                System.out.print("content: ");
                try {
                    content = bufferedReader.readLine();
                }
                catch (IOException exception){
                    exception.printStackTrace();
                }

                if (!name.equals("")) {
                    //DateFormat df = new SimpleDateFormat("yyyy.MM.dd HH:mm");
                    Note note = new Note(name, content, new Date());
                    gateway.addNote(note);
                }
            }

            if(command.equals("edit")){
                String name = "";
                String content = "";
                System.out.print("name: ");
                try {
                    name = bufferedReader.readLine();
                }
                catch (IOException exception){
                    exception.printStackTrace();
                }

                System.out.print("content: ");
                try {
                    content = bufferedReader.readLine();
                }
                catch (IOException exception){
                    exception.printStackTrace();
                }

                if (!name.equals("")) {
                    gateway.editNote(name, content);
                }
            }

            if(command.equals("delete")){
                String name = "";
                System.out.print("name: ");
                try {
                    name = bufferedReader.readLine();
                }
                catch (IOException exception){
                    exception.printStackTrace();
                }

                if(!name.equals("")){
                    gateway.deleteNote(name);
                }
            }

            if(command.equals("list")){
                for(Note n : gateway.listAllNotes()){
                    System.out.println("name: " + n.getName());
                    System.out.println("content: " + n.getContent());
                    System.out.println("date: " + n.getDate());
                }
            }

            if(command.equals("createuser")){
                String name = "";
                String password = "";
                System.out.print("name: ");
                try {
                    name = bufferedReader.readLine();
                    System.out.print("password: ");
                    password = bufferedReader.readLine();
                }
                catch (IOException exception){
                    exception.printStackTrace();
                }

                if (!name.equals("") && !password.equals("")) {
                    gateway.createUser(name, password);
                }
            }

            if(command.equals("deleteuser")){
                String name = "";
                System.out.print("name: ");
                try {
                    name = bufferedReader.readLine();
                }
                catch (IOException exception){
                    exception.printStackTrace();
                }

                if (!name.equals("")) {
                    gateway.deleteUser(name);
                }
            }

            if(command.equals("listuser")){
                for(User u : gateway.listAllUser()){
                    System.out.println("name: " + u.getUserName());
                    System.out.println("password: " + u.getPassword());
                }
            }
        }
    }
}
