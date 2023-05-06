package at.fhcampuswien.carrental.carrentalservice.AMQP;
import java.util.concurrent.TimeUnit;

import at.fhcampuswien.carrental.carrentalservice.CarRentalServiceApplication;
import at.fhcampuswien.carrental.carrentalservice.entity.CustomerAttribute;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class Runner {

    private final RabbitTemplate rabbitTemplate;
    private final Receiver receiver;

    public Runner(Receiver receiver, RabbitTemplate rabbitTemplate) {
        this.receiver = receiver;
        this.rabbitTemplate = rabbitTemplate;
    }

    public void sendCustomerRabbitMqMessage(CustomerAttribute customerAttribute) throws Exception {
        System.out.println("Sending message...");
        rabbitTemplate.convertAndSend(AmqpConfiguration.topicExchangeName, "foo.bar.baz", customerAttribute);
        receiver.getLatch().await(10000, TimeUnit.MILLISECONDS);
    }


}
