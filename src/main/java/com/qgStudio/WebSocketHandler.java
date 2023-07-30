package com.qgStudio;

import com.qgStudio.entity.Strip;
import com.qgStudio.mapper.StripMapper;
import io.netty.channel.Channel;
import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.handler.codec.http.websocketx.TextWebSocketFrame;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
@ChannelHandler.Sharable
public class WebSocketHandler extends SimpleChannelInboundHandler<TextWebSocketFrame> {

    @Autowired
    private StripMapper stripMapper;

    @Override
    protected void channelRead0(ChannelHandlerContext channelHandlerContext, TextWebSocketFrame textWebSocketFrame) throws Exception {
        System.out.println("chennelRead0-======================");
        String text = textWebSocketFrame.text();
        System.out.println("text="+text);
        channelHandlerContext.channel().writeAndFlush(new TextWebSocketFrame(text));
    }

    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        Strip strip = stripMapper.selectNew("strip_" + Strip.format1.format(new Date()));
        System.out.println(strip);
        for (Channel channel : WebSocketServer.channelGroup) {
            System.out.println(channel.remoteAddress());
            channel.writeAndFlush(strip.toString() + "\n");
        }
    }

    @Override
    public void channelInactive(ChannelHandlerContext ctx) throws Exception {
        WebSocketServer.channelGroup.remove(ctx.channel());
    }

    @Override
    public void handlerAdded(ChannelHandlerContext ctx) throws Exception {
        System.out.println("handlerAdded");
    }

    public void sendMessage(String string) {
        System.out.println("send message");
        for (Channel channel : WebSocketServer.channelGroup) {
            System.out.println(channel.remoteAddress());
            channel.writeAndFlush(string );
            channel.flush();
        }
    }
}
