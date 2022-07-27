
package com.mycompany.samplebankingapp;
import java.util.ArrayList;


public class UserController {
    ArrayList<User> users = new ArrayList<>(); // Create an ArrayList object
    
    // login user
    public boolean login(String userName, String passWord) {
        for (User us : users) {
            if (us.getUserName().equalsIgnoreCase(userName) && us.getPassWord().equals(passWord)) {
                return true;
            }
        }
        if (userName.equalsIgnoreCase("admin") && passWord.equals("admin")) {
            return true;
        }
        System.out.println("Invalid Login");
        return false;
    }
    
    // add a user

    public boolean addUser(String userName, String passWord) {
        if (findUser(userName) == null) {
            User us = new User(userName, passWord);
            users.add(us);
            return true;
        }
        return false;
    }
    
    // find a user
    
    public User findUser(String userName) {
        for (User us : users) {
            if (us.getUserName().equalsIgnoreCase(userName)) {
                return us;
            }
        }
        return null;
    }
    
    // delete a user
    
    public boolean deleteUser(String username) {
        if(findUser(username) != null) {
            User us  = findUser(username);
            users.remove(us);
             return true;
            }
        return false;
       }
}
