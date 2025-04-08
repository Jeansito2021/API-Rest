package com.example.demo.listener;

import com.example.demo.event.ProductoCreadoEvent;
import org.springframework.context.event.EventListener;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

@Component
public class ProductoCreadoListener {

    @Async
    @EventListener
    public void handleProductoCreadoEvent(ProductoCreadoEvent event) {
        // Lógica para ser ejecutada en segundo plano
        System.out.println("Nuevo producto creado (asíncrono): " + event.getProducto().getNombre());
        // Otros procesos en segundo plano
    }
}
