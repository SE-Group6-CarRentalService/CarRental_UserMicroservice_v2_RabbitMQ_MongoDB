package at.fhcampuswien.carrental.carrentalservice.AMQP;

import org.springframework.amqp.core.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Profile({"rpc"})
@Configuration
public class AmqpConfiguration {
    public static final String topicExchangeName = "carRental.rpc";

    static final String queueName = "carRental.rpc.requests";

    @Bean
    //Queue queue() { return new Queue(queueName, false);
    Queue queue() { return new Queue(queueName, true);
    }

    /*
    @Bean
    TopicExchange exchange() {
        return new TopicExchange(topicExchangeName);
    }
     */
    @Bean
    DirectExchange exchange() {
        return new DirectExchange(topicExchangeName);
    }

    @Bean
    Binding binding(DirectExchange exchange, Queue queue) {
        return BindingBuilder.bind(queue).to(exchange).with("rpc");
    }
    /*
    @Bean
    Binding binding(Queue queue, TopicExchange exchange) {
        return BindingBuilder.bind(queue).to(exchange).with("foo.bar.#");
    }

     */

    //@Bean
    //public CustomerController server() {
    //    return new CustomerController();
    //}

    /*
    @Bean
    SimpleMessageListenerContainer container(ConnectionFactory connectionFactory,
                                             MessageListenerAdapter listenerAdapter) {
        SimpleMessageListenerContainer container = new SimpleMessageListenerContainer();
        container.setConnectionFactory(connectionFactory);
        container.setQueueNames(queueName);
        container.setMessageListener(listenerAdapter);
        return container;
    }

    @Bean
    MessageListenerAdapter listenerAdapter(Receiver receiver) {
        return new MessageListenerAdapter(receiver, "receiveMessage");
    }

     */
}
