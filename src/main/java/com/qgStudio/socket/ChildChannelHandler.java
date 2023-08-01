package com.qgStudio.socket;

import com.alibaba.fastjson.JSON;
import com.qgStudio.ExceptionHandler;
import com.qgStudio.WebSocketServer;
import com.qgStudio.entity.Strip;
import io.netty.buffer.ByteBuf;
import io.netty.channel.Channel;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.socket.SocketChannel;
import io.netty.handler.codec.http.websocketx.TextWebSocketFrame;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedDeque;

@Component
public class ChildChannelHandler extends ChannelInitializer<SocketChannel> {

    public static ConcurrentLinkedDeque<SocketChannel> socketChannels = new ConcurrentLinkedDeque<>();



    @Resource
    private DiscardServerHandler discardServerHandler;

    public void initChannel(SocketChannel socketChannel) {
        System.out.println("init socketChannel");
        socketChannels.add(socketChannel);
        System.out.println(socketChannels.size());
        socketChannel.pipeline().addLast(discardServerHandler);

        socketChannel.pipeline().addLast(new ExceptionHandler());
    }

    public static void sendMessage(String msg) {
        System.out.println("sendMessage");
        System.out.println(msg);
        System.out.println(socketChannels.size());
        socketChannels.forEach(socketChannel -> {
            ByteBuf buffer = socketChannel.alloc().buffer();
            buffer.writeBytes(msg.getBytes());
            socketChannel.writeAndFlush(buffer);
        });
    }
}
