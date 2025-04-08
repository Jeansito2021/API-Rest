package com.example.demo.service;

import com.example.demo.entity.Producto;
import com.example.demo.repository.ProductoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.concurrent.CompletableFuture;

@Service
public class ProductoService {

    private final ProductoRepository productoRepository;

    @Autowired
    public ProductoService(ProductoRepository productoRepository) {
        this.productoRepository = productoRepository;
    }

    // Crear un nuevo producto
    public Producto crearProducto(Producto producto) {
        return productoRepository.save(producto);
    }

    // Obtener todos los productos
    public List<Producto> obtenerProductos() {
        return productoRepository.findAll();
    }

    // Obtener un producto por su ID
    public Optional<Producto> obtenerProductoPorId(Long id) {
        return productoRepository.findById(id);
    }

    // Actualizar un producto
    public Producto actualizarProducto(Long id, Producto producto) {
        if (productoRepository.existsById(id)) {
            producto.setId(id);  // Aseguramos que el id no se pierda al actualizar
            return productoRepository.save(producto);
        }
        return null;
    }

    // Eliminar un producto
    public boolean eliminarProducto(Long id) {
        if (productoRepository.existsById(id)) {
            productoRepository.deleteById(id);
            return true;
        }
        return false;
    }

    // Método asíncrono para simular una operación de larga duración
    @Async
    public CompletableFuture<Void> realizarTareaEnSegundoPlano(Long id) {
        try {
            // Simulando una operación larga (ej. enviar un correo, procesar datos, etc.)
            Thread.sleep(5000); // Simula una tarea que tarda 5 segundos
            System.out.println("Tarea completada para el producto con id: " + id);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return CompletableFuture.completedFuture(null);
    }
}