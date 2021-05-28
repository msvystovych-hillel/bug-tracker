package com.example.demo;

import com.example.demo.producer.BroadcastConfig;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class Main {

    private static String ROUTING_KEY_USER_IMPORTANT_WARN = "user.important.warn";
    private static String ROUTING_KEY_USER_IMPORTANT_ERROR = "user.important.error";

    public static void main(String[] args) {
        SpringApplication.run(Main.class, args);
    }

    @Bean
    public ApplicationRunner runner(RabbitTemplate rabbitTemplate) {
        String message = " payload is broadcast";
        return args -> {
            rabbitTemplate.convertAndSend(BroadcastConfig.FANOUT_EXCHANGE_NAME, "", "fanout" + message);
            rabbitTemplate.convertAndSend(BroadcastConfig.TOPIC_EXCHANGE_NAME, ROUTING_KEY_USER_IMPORTANT_WARN, "topic important warn" + message);
            rabbitTemplate.convertAndSend(BroadcastConfig.TOPIC_EXCHANGE_NAME, ROUTING_KEY_USER_IMPORTANT_ERROR, "topic important error" + message);
        };
    }
}
