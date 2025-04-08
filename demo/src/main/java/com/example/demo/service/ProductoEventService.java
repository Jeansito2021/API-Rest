package com.example.demo.service;

import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessageBuilder;
import org.springframework.amqp.core.MessageProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Service;

@Service
public class ProductoEventService {

    private final RabbitTemplate rabbitTemplate;

    @Autowired
    public ProductoEventService(RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }

    // Método para enviar un mensaje a la cola de RabbitMQ
    public void enviarProductoCreado(String productoInfo) {
        Message message = MessageBuilder.withBody(productoInfo.getBytes())
                .setContentType(MessageProperties.CONTENT_TYPE_TEXT_PLAIN)
                .build();
        rabbitTemplate.send("productoQueue", message);
    }
}
