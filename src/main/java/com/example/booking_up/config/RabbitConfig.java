package com.example.booking_up.config;

import org.springframework.amqp.core.*;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitConfig {
    @Bean
    public DirectExchange deadLetterExchange(){return new DirectExchange("deadLetterExchange");}

    @Bean
    public Binding deadLetterBinding(){
        return BindingBuilder.bind(dlqNotifications())
                .to(deadLetterExchange())
                .with("key");
    }


    @Bean
    public Queue notifications(){
        return QueueBuilder.durable("notifications_queue")
                .withArgument("x-dead-letter-exchange", "deadLetterExchange")
                .withArgument("x-dead-letter-routing-key", "key")
                .build();
    }

    @Bean
    public Queue dlqNotifications(){return new Queue("dlq_notifications", false);}

    @Bean
    public DirectExchange directExchange(){
        return new DirectExchange("directExchange");
    }

    @Bean
    public Binding binding(){
        return BindingBuilder.bind(notifications())
                .to(directExchange())
                .with("key");
    }

    @Bean
    public MessageConverter messageConverter(){
        return new Jackson2JsonMessageConverter();
    }

    @Bean
    public AmqpTemplate amqpTemplate(ConnectionFactory connectionFactory){
        RabbitTemplate rabbitTemplate = new RabbitTemplate(connectionFactory);
        rabbitTemplate.setMessageConverter(messageConverter());
        return rabbitTemplate;
    }
}
