package com.fanyank.socket;


import com.fanyank.pojo.User;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.AbstractWebSocketHandler;

import java.io.IOException;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

@Component
public class SocketHandler extends AbstractWebSocketHandler implements Serializable {
    private static final Map<Integer,WebSocketSession> userMap = new HashMap<>();
    @Override
    public void afterConnectionEstablished(WebSocketSession webSocketSession) throws Exception {

        System.out.println("成功建立起socket链接");
        User user = (User) webSocketSession.getAttributes().get("user");
        userMap.put(user.getId(),webSocketSession);
    }

    @Override
    protected void handleTextMessage(WebSocketSession webSocketSession,TextMessage message) throws Exception {
        System.out.println("handleTextMessage收到消息->" + message.getPayload());
    }

    @Override
    public void handleMessage(WebSocketSession webSocketSession, WebSocketMessage<?> webSocketMessage) throws Exception {
        System.out.println("handleMessage收到消息->" + webSocketMessage.getPayload());
    }

    @Override
    public void handleTransportError(WebSocketSession webSocketSession, Throwable throwable) throws Exception {
        if(webSocketSession.isOpen()) {
            webSocketSession.close();
        }
    }

    @Override
    public void afterConnectionClosed(WebSocketSession webSocketSession, CloseStatus closeStatus) throws Exception {
    }

    @Override
    public boolean supportsPartialMessages() {
        return false;
    }

    /**
     * 跟在线的所用用户发送消息
     * @param textMessage
     */
    public void sendMessageToAllUsers(TextMessage textMessage) {
        for(Map.Entry<Integer,WebSocketSession> entry : userMap.entrySet()) {
            WebSocketSession webSocketSession = entry.getValue();
            if(webSocketSession.isOpen()) {
                try {
                    webSocketSession.sendMessage(textMessage);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    /**
     * 给指定商家发送消息
     * @param targetId
     * @param textMessage
     */
    public void sendMessageToUser(Integer targetId, TextMessage textMessage) {
        for(Map.Entry<Integer,WebSocketSession> entry : userMap.entrySet()) {
            WebSocketSession webSocketSession = entry.getValue();
            Integer onlineUserId = entry.getKey();
            if(webSocketSession.isOpen()) {
                try {
                    if(targetId.equals(onlineUserId)) {
                        webSocketSession.sendMessage(textMessage);
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
