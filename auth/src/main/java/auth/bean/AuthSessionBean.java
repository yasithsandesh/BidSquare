package auth.bean;

import auth.model.ActiveUserManager;
import auth.remote.AuthService;
import core.dto.UserDTO;
import core.model.User;
import jakarta.ejb.Stateless;
import jakarta.inject.Inject;


@Stateless(mappedName = "com.yasithsandesh.bidsquare.auth.remote.AuthService")
public class AuthSessionBean implements AuthService {

    @Inject
    ActiveUserManager activeUserManager;


    @Override
    public boolean createUser(UserDTO userDTO) {
        return  this.activeUserManager.setUser(new User(userDTO.getUsername(), userDTO.getPassword()));
    }


    @Override
    public User login(UserDTO userDTO) {
        return this.activeUserManager.findUser(userDTO.getUsername(), userDTO.getPassword());
    }

}
