package com.demowechat.util;

import jakarta.websocket.*;
import jakarta.websocket.server.PathParam;
import jakarta.websocket.server.ServerEndpoint;

import org.springframework.stereotype.Component;
import java.io.IOException;
import java.util.concurrent.ConcurrentHashMap;
import java.util.Map;

@Component
@ServerEndpoint("/ws/{userId}")
public class WebSocketServer {

    // 存在线程安全的在线用户集合
    private static final Map<String, Session> SESSION_MAP = new ConcurrentHashMap<>();

    @OnOpen
    public void onOpen(Session session, @PathParam("userId") String userId) {
        SESSION_MAP.put(userId, session);
        System.out.println(userId + " 已上线，当前在线：" + SESSION_MAP.size());
    }

    @OnMessage
    public void onMessage(String message, Session session, @PathParam("userId") String userId) throws IOException {
        System.out.println("收到消息：" + userId + " -> " + message);
        session.getBasicRemote().sendText("服务器已收到：" + message);
    }

    @OnClose
    public void onClose(@PathParam("userId") String userId) {
        SESSION_MAP.remove(userId);
        System.out.println(userId + " 已下线");
    }

    @OnError
    public void onError(Throwable error) {
        error.printStackTrace();
    }

    // 简单方法：给某个用户发消息
    public static void sendToUser(String userId, String message) throws IOException {
        Session session = SESSION_MAP.get(userId);
        if (session != null && session.isOpen()) {
            session.getBasicRemote().sendText(message);
        }
    }

    // 简单方法：群发消息
    public static void sendToAll(String message) throws IOException {
        for (Session session : SESSION_MAP.values()) {
            if (session.isOpen()) {
                session.getBasicRemote().sendText(message);
            }
        }
    }
}
