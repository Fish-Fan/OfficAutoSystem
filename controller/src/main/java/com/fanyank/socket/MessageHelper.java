package com.fanyank.socket;

import com.fanyank.pojo.ChatMessage;
import com.fanyank.pojo.Message;
import com.fanyank.pojo.User;
import com.fanyank.service.IMService;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.WebSocketMessage;

import java.util.Date;

@Component
public class MessageHelper {
    @Autowired
    private IMService imService;

    public ChatMessage handleChatMessage(WebSocketMessage<?> webSocketMessage) {
        Gson gson = new Gson();
        Message message = gson.fromJson(webSocketMessage.getPayload().toString(),Message.class);
        User from = message.getData().getMine();
        User to = message.getData().getTo();

        ChatMessage chatMessage = new ChatMessage();
        chatMessage.setUsername(from.getUsername());
        chatMessage.setAvatar(from.getAvatar());
        chatMessage.setId(from.getId());
        chatMessage.setType(to.getType());
        chatMessage.setContent(from.getContent());
        chatMessage.setMine(false);
        chatMessage.setFromid(from.getId());
        chatMessage.setTimestamp(new Date().getTime());
        chatMessage.setToid(to.getId());
        imService.saveChatMessage(chatMessage);

        return chatMessage;
    }
}
