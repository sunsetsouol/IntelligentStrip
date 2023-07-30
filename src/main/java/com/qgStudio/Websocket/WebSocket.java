package com.qgStudio;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import javax.websocket.OnClose;
import javax.websocket.OnMessage;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;

@Component
@Slf4j
@ServerEndpoint("/websocket/{userId}")
public class WebSocket {

    private Session session;

    private String userId;

    private static CopyOnWriteArrayList<WebSocket> webSockets = new CopyOnWriteArrayList<>();

    private static ConcurrentHashMap<String ,Session> sessionPool = new ConcurrentHashMap<>();

    @OnClose
    public void onClose(){
        webSockets.remove(this);
        sessionPool.remove(this.userId);
        log.info("连接断开");
    }

    @OnMessage
    public void onMessage(String message){
        log.info("收到消息" + message);
    }


}
