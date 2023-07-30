package com.qgStudio.socket;

import com.qgStudio.ExceptionHandler;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.socket.SocketChannel;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.concurrent.ConcurrentHashMap;

@Component
public class ChildChannelHandler extends ChannelInitializer<SocketChannel> {

    public static ConcurrentHashMap<Thread,SocketChannel> socketChannels = new ConcurrentHashMap<>();



    @Resource
    private DiscardServerHandler discardServerHandler;

    public void initChannel(SocketChannel socketChannel) {
        socketChannels.put(Thread.currentThread(),socketChannel);
        socketChannel.pipeline().addLast(discardServerHandler);

        socketChannel.pipeline().addLast(new ExceptionHandler());

    }
}
