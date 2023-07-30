package com.qgStudio;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

import javax.annotation.Resource;

@SpringBootApplication
public class IntelligentStripApplication implements CommandLineRunner {
    @Resource
    private Server server;

    @Autowired
    private WebSocketServer webSocketServer;

    public static void main(String[] args) {
        SpringApplication.run(IntelligentStripApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        server.run(8082);
        webSocketServer.start();
    }
}
