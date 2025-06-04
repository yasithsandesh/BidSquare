package notification.remote;

import core.model.Notification;
import jakarta.ejb.Remote;

import java.util.List;

@Remote
public interface NotificationService {
    List<Notification> getNotifications();
}
