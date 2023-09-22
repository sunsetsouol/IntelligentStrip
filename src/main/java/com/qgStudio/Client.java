//package com.qgStudio;
//
//import io.netty.bootstrap.Bootstrap;
//import io.netty.channel.Channel;
//import io.netty.channel.ChannelInitializer;
//import io.netty.channel.ChannelPipeline;
//import io.netty.channel.nio.NioEventLoopGroup;
//import io.netty.channel.socket.SocketChannel;
//import io.netty.channel.socket.nio.NioSocketChannel;
//import io.netty.handler.codec.http.HttpClientCodec;
//import io.netty.handler.codec.http.HttpObjectAggregator;
//import io.netty.handler.codec.http.HttpServerCodec;
//import io.netty.handler.codec.http.websocketx.WebSocketClientHandshakerFactory;
//import io.netty.handler.codec.http.websocketx.WebSocketClientProtocolHandler;
//import io.netty.handler.codec.http.websocketx.WebSocketVersion;
//import io.netty.handler.stream.ChunkedWriteHandler;
//
//import java.net.URI;
//
//public class Client {
//    public static void main(String[] args) throws InterruptedException {
//        Bootstrap bootstrap = new Bootstrap()
//                .group(new NioEventLoopGroup())
//                .channel(NioSocketChannel.class)
//                .handler(new ChannelInitializer<SocketChannel>() {
//                    @Override
//                    protected void initChannel(SocketChannel socketChannel) throws Exception {
//                        ChannelPipeline pipeline = socketChannel.pipeline();
//                        pipeline.addLast(new HttpClientCodec());
//                        pipeline.addLast(new HttpObjectAggregator(8192));
//
//
////                        pipeline.addLast(new ChunkedWriteHandler());
////                        pipeline.addLast(new HttpObjectAggregator(64 * 1024));
//                        pipeline.addLast(new WebSocketClientProtocolHandler(WebSocketClientHandshakerFactory.newHandshaker(new URI("ws://localhost:8081/websocket"), WebSocketVersion.V13,null,false,null)));
//                        pipeline.addLast(new WebSocketClientHandler());
//                    }
//                });
//        Channel channel = bootstrap.connect("localhost", 8081).sync().channel();
//    }
//}
