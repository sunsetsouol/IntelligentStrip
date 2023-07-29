package com.qgStudio;

import com.alibaba.fastjson.JSON;
import com.qgStudio.entity.Strip;
import com.qgStudio.service.StripService;
import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;


@Component
@ChannelHandler.Sharable
public class DiscardServerHandler extends ChannelInboundHandlerAdapter {


    @Resource
    private StripService service;

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        try {
            ByteBuf byteBuf = msg instanceof ByteBuf ? ((ByteBuf) msg) : null;
            if (byteBuf != null) {
                byte[] buf = new byte[2048];
                ByteBuf len = byteBuf.readBytes(buf, 0, byteBuf.readableBytes());
                Strip strip = (Strip) JSON.parseObject(buf, Strip.class);

                System.out.println(strip);
                service.insert(strip);
//                Server.queue.offer(strip);

            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
