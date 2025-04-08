package com.example.demo.event;

import com.example.demo.entity.Producto;
import org.springframework.context.ApplicationEvent;

public class ProductoCreadoEvent extends ApplicationEvent {

    private final Producto producto;

    public ProductoCreadoEvent(Object source, Producto producto) {
        super(source);
        this.producto = producto;
    }

    public Producto getProducto() {
        return producto;
    }
}
