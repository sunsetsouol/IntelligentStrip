package com.qgStudio;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.Channel;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.group.ChannelGroup;
import io.netty.channel.group.DefaultChannelGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.handler.codec.http.HttpObjectAggregator;
import io.netty.handler.codec.http.HttpServerCodec;
import io.netty.handler.codec.http.websocketx.WebSocketServerProtocolHandler;
import io.netty.handler.stream.ChunkedWriteHandler;
import io.netty.handler.timeout.ReadTimeoutHandler;
import io.netty.handler.timeout.WriteTimeoutHandler;
import io.netty.util.concurrent.GlobalEventExecutor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class WebSocketServer {

    public static ChannelGroup channelGroup = new DefaultChannelGroup(GlobalEventExecutor.INSTANCE);
    private Integer port ;

    @Autowired
    private WebSocketHandler webSocketHandler;

    public WebSocketServer() {
    }

    public WebSocketServer(Integer port) {
        this.port = port;
    }

    public void start(int port) throws InterruptedException {
        EventLoopGroup bossGroup = new NioEventLoopGroup();
        EventLoopGroup workerGroup = new NioEventLoopGroup();

        try {
            ServerBootstrap b = new ServerBootstrap();
            b.group(bossGroup, workerGroup)
                    .channel(NioServerSocketChannel.class)
                    .childHandler(new ChannelInitializer<SocketChannel>() {
                        @Override
                        public void initChannel(SocketChannel ch) throws Exception {
                            channelGroup.add(ch);
                            System.out.println("init" + ch.localAddress());
                            System.out.println(channelGroup.size());
                            ChannelPipeline pipeline = ch.pipeline();


                            // HTTP 编解码器
                            pipeline.addLast(new HttpServerCodec());
                            // 写文件内容
                            pipeline.addLast(new ChunkedWriteHandler());
                            // 聚合解码 HttpRequest/HttpContent/LastHttpContent 到 FullHttpRequest
                            pipeline.addLast(new HttpObjectAggregator(64 * 1024));
                            // 处理其他的 WebSocketFrame
                            pipeline.addLast(new WebSocketServerProtocolHandler("/websocket"));
                            // 自定义处理 WebSocket 消息的逻辑
                            pipeline.addLast(webSocketHandler);
                            pipeline.addLast(new ExceptionHandler());
                        }

                    });

            Channel ch = b.bind(port).sync().channel();

            ch.closeFuture().sync();
        } finally {
            bossGroup.shutdownGracefully();
            workerGroup.shutdownGracefully();
        }
    }
}
