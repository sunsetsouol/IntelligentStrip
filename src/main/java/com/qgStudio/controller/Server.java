package com.qgStudio.controller;

import com.alibaba.fastjson.JSON;
import com.qgStudio.entity.Strip;
import com.qgStudio.service.Impl.StripServiceImpl;
import com.qgStudio.service.StripService;
import io.netty.bootstrap.ServerBootstrap;
import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;

public class Server {
    private static StripService service;

    static {
        service = new StripServiceImpl();
    }

    public static void main(String[] args) throws InterruptedException {
        new ServerBootstrap()
                .group(new NioEventLoopGroup(), new NioEventLoopGroup())
                .channel(NioServerSocketChannel.class)
                .childHandler(new ChannelInitializer<NioSocketChannel>() {
                    @Override
                    protected void initChannel(NioSocketChannel channel) {
                        channel.pipeline().addLast(new ChannelInboundHandlerAdapter() {
                            @Override
                            public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
                                ByteBuf byteBuf = msg instanceof ByteBuf ? ((ByteBuf) msg) : null;
                                if (byteBuf != null) {
                                    byte[] buf = new byte[1024];
                                    ByteBuf len = byteBuf.readBytes(buf, 0, byteBuf.readableBytes());
                                    System.out.println(new String(buf));
                                    Strip strip = (Strip) JSON.parseObject(buf, Strip.class);
//                                    service.insert(strip);
                                    System.out.println(strip);
                                }

                            }
                        });
                    }
                }).bind("127.0.0.1", 8080).sync();
    }
}
