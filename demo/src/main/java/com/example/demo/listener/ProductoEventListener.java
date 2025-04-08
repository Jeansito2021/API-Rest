package com.example.demo.listener;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class ProductoEventListener {

    @RabbitListener(queues = "productoQueue")
    public void recibirMensaje(String productoInfo) {
        // Lógica para procesar el mensaje recibido
        System.out.println("Producto creado: " + productoInfo);
    }
}
