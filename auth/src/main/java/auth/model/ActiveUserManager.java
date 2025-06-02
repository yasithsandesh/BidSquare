package auth.model;

import core.model.User;
import jakarta.enterprise.context.ApplicationScoped;

import java.util.ArrayList;
import java.util.List;

@ApplicationScoped
public class ActiveUserManager {
    private int numberOfActiveUsers;

    private List<User> userList;


    public ActiveUserManager() {
        this.userList =  new ArrayList<>();
    }


    public List<User> getUserList() {
        return userList;
    }


    public boolean setUser(User user){
        this.userList.add(user);
        return true;
    }


    public User findUser(String username, String password){
        for(User user : this.userList){
            if(user.getUsername().equals(username) && user.getPassword().equals(password)){
                return user;
            }
        }
        return null;
    }

}
