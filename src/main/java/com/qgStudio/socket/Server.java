package com.qgStudio.socket;


import com.qgStudio.service.Impl.StripServiceImpl;
import com.qgStudio.service.StripService;
import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

@Component
public class Server {

//    public static LinkedBlockingQueue<Strip> queue = new LinkedBlockingQueue<>(100);

    @Autowired
    private static StripService service;

    @Resource
    private ChildChannelHandler childChannelHandler;

    static {
//        queue = new LinkedBlockingQueue<>();
        service = new StripServiceImpl();
    }

    public  void run (int port) throws InterruptedException {
        System.out.println("init");
        new ServerBootstrap()
                .group(new NioEventLoopGroup(), new NioEventLoopGroup())
                .channel(NioServerSocketChannel.class)
                .childHandler(childChannelHandler).bind("localhost", port).sync();


    }

}
