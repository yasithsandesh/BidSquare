package auth.remote;

import core.dto.UserDTO;
import core.model.User;
import jakarta.ejb.Remote;

@Remote
public interface AuthService {
    boolean createUser(UserDTO userDTO);
    User login(UserDTO userDTO);
}
