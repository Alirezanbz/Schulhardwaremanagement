package com.example.schulhardwaremanagement;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SchulhardwaremanagementApplication {

    public static void main(String[] args) {
        SpringApplication.run(SchulhardwaremanagementApplication.class, args);
        SerialPortReader reader = new SerialPortReader();
        reader.initialize();

    }

}
