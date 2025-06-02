package controllers.user;

import auth.remote.AuthService;
import com.google.gson.Gson;
import core.dto.ResponseDTO;
import core.dto.UserDTO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import javax.naming.InitialContext;
import java.io.IOException;

@WebServlet(name = "UserCreate", urlPatterns = {"/UserCreate"})
public class UserCreate extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Gson gson = new Gson();
        ResponseDTO responseDTO = new ResponseDTO();
        UserDTO userDTO = gson.fromJson(request.getReader(), UserDTO.class);
        try {
            InitialContext ctx = new InitialContext();
            AuthService authService = (AuthService) ctx.lookup("com.yasithsandesh.bidsquare.auth.remote.AuthService");

            boolean status = authService.createUser(userDTO);
            if (status) {
                responseDTO.setMessage("User Created");
                responseDTO.setStatus(status);

            }else{
                responseDTO.setMessage("User Not Created");
                responseDTO.setStatus(false);
            }

        }catch (Exception e) {
            e.printStackTrace();
        }

        response.setContentType("application/json");
        response.getWriter().print(gson.toJson(responseDTO));

    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.getWriter().print("hello");
    }
}
