package notification.bean;

import com.rabbitmq.client.*;
import core.model.Notification;
import jakarta.annotation.PostConstruct;
import jakarta.ejb.Singleton;
import jakarta.ejb.Startup;
import notification.remote.NotificationService;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeoutException;

@Singleton
@Startup
public class NotificationServiceBean implements NotificationService {

    private int notificationId;

    private static final String EXCHANGE_NAME = "bid_topic_exchange";
    private static final String ROUTING_KEY = "bid.highest";
    private static final String QUEUE_NAME = "user_bid_notifications";

    private Connection connection;
    private Channel channel;

    List<Notification> notifications;


    @PostConstruct
    public void init() {
        this.notifications = new ArrayList<>();
        try{
            ConnectionFactory factory = new ConnectionFactory();
            factory.setHost("localhost");
            factory.setPort(5672);
            factory.setUsername("guest");
            factory.setPassword("guest");

            connection = factory.newConnection();
            channel = connection.createChannel();

            channel.exchangeDeclare(EXCHANGE_NAME, BuiltinExchangeType.TOPIC, true);
            channel.queueDeclare(QUEUE_NAME, true, false, false, null); // durable, not exclusive, not auto-delete
            channel.queueBind(QUEUE_NAME, EXCHANGE_NAME, ROUTING_KEY);

            DeliverCallback deliverCallback = new DeliverCallback() {

                @Override
                public void handle(String s, Delivery delivery) throws IOException {
                    String message = new String(delivery.getBody(), "UTF-8");
                    Notification notification = new Notification();
                    notification.setMessage(message);
                    notification.setId(genId());
                    notifications.add(notification);
                }

            };

            channel.basicConsume(QUEUE_NAME, true, deliverCallback, consumerTag -> {});

        }catch (Exception e){
            e.printStackTrace();
        }
    }


    @Override
    public List<Notification> getNotifications() {
        return List.of();
    }

    int genId(){
        this.notificationId++;
        return this.notificationId;
    }
}
