package product.message;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

public class RabbitMqPublisher {

    private final String EXCHANGE_NAME = "bid_topic_exchange";
    private static RabbitMqPublisher rabbitMqPublisher;

    private RabbitMqPublisher(){
    }

    public void publish(String message){
        try {
            ConnectionFactory factory = new ConnectionFactory();
            factory.setHost("localhost");
            factory.setPort(5672);
            factory.setUsername("guest");
            factory.setPassword("guest");

            try (Connection connection = factory.newConnection();
                 Channel channel = connection.createChannel()) {

                channel.exchangeDeclare(this.EXCHANGE_NAME, "topic", true);
                String routingKey = "bid.highest";

                channel.basicPublish(this.EXCHANGE_NAME, routingKey, null, message.getBytes("UTF-8"));

            } catch (IOException e) {
                throw new RuntimeException(e);
            } catch (TimeoutException e) {
                throw new RuntimeException(e);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public static RabbitMqPublisher getInstance(){
        if(rabbitMqPublisher == null){
            rabbitMqPublisher = new RabbitMqPublisher();
        }
        return rabbitMqPublisher;
    }

}
