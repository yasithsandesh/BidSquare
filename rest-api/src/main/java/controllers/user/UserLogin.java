package controllers.user;

import auth.remote.AuthService;
import com.google.gson.Gson;
import core.dto.ResponseDTO;
import core.dto.UserDTO;
import core.model.User;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import java.io.IOException;

@WebServlet(name = "UserLogin", urlPatterns = {"/UserLogin"})
public class UserLogin extends HttpServlet {


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Gson gson = new Gson();
        ResponseDTO responseDTO = new ResponseDTO();
        UserDTO userDTO = gson.fromJson(request.getReader(), UserDTO.class);
        if(request.getSession().getAttribute("user") == null){
            try {
                InitialContext ctx = new InitialContext();
                AuthService authService =(AuthService)ctx.lookup("com.yasithsandesh.bidsquare.auth.remote.AuthService");
                User user = authService.login(userDTO);
                if(user != null){
                    request.getSession().setAttribute("user", user);
                    responseDTO.setStatus(true);
                    responseDTO.setMessage("User logged in");
                    responseDTO.setData(gson.toJson(user));
                }else{
                    responseDTO.setStatus(false);
                    responseDTO.setMessage("User not logged in");
                }

            } catch (NamingException e) {
                throw new RuntimeException(e);
            }

        }else{
            User user = (User) request.getSession().getAttribute("user");
            if(user.getUsername().equals(userDTO.getUsername()) && user.getPassword().equals(userDTO.getPassword())){
                responseDTO.setStatus(true);
                responseDTO.setMessage("User logged in");
                responseDTO.setData(gson.toJson(user));
            }else{
                responseDTO.setStatus(false);
                responseDTO.setMessage("User not logged in");
            }

        }

        response.setContentType("application/json");
        response.getWriter().print(gson.toJson(responseDTO));
    }
}
