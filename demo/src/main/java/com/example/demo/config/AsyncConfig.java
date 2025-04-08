package com.example.demo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

@Configuration
public class AsyncConfig {

    @Bean
    public ThreadPoolTaskExecutor taskExecutor() {
        ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
        executor.setCorePoolSize(10);  // Número de hilos básicos
        executor.setMaxPoolSize(20);   // Número máximo de hilos
        executor.setQueueCapacity(100); // Tamaño de la cola de tareas
        executor.setThreadNamePrefix("async-");
        executor.initialize();
        return executor;
    }
}
