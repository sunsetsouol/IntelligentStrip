package com.qgStudio;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.annotation.Resource;

@SpringBootApplication
public class IntelligentStripApplication implements CommandLineRunner {
    @Resource
    private Server server;
    public static void main(String[] args) {
        SpringApplication.run(IntelligentStripApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        server.run(8082);
    }
}
