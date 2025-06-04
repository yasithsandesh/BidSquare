package controllers.user;

import com.google.gson.Gson;
import core.model.Notification;
import jakarta.ejb.EJB;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import notification.remote.NotificationService;

import java.io.IOException;
import java.util.List;

@WebServlet(name = "GetAllNotification",urlPatterns = {"GetAllNotification"})
public class GetAllNotification extends HttpServlet {

    @EJB
    NotificationService notificationService;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Gson gson = new Gson();
        List<Notification> notificationList = notificationService.getNotifications();
        resp.setContentType("application/json");
        resp.getWriter().print(gson.toJson(notificationList));
    }
}
