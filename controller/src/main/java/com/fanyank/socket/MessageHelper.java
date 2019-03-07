package com.fanyank.socket;

import com.fanyank.pojo.ChatMessage;
import com.fanyank.pojo.Message;
import com.fanyank.pojo.User;
import com.fanyank.rocketmq.RocketMQProducer;
import com.fanyank.service.IMService;
import com.google.gson.Gson;
import org.apache.rocketmq.client.exception.MQBrokerException;
import org.apache.rocketmq.client.exception.MQClientException;
import org.apache.rocketmq.client.producer.SendResult;
import org.apache.rocketmq.remoting.common.RemotingHelper;
import org.apache.rocketmq.remoting.exception.RemotingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.WebSocketMessage;


import java.io.UnsupportedEncodingException;
import java.util.Date;

@Component
public class MessageHelper {
    @Autowired
    private RocketMQProducer producer;

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

        try {
            org.apache.rocketmq.common.message.Message msg = new org.apache.rocketmq.common.message.Message(
                    "SocketTopic","SocketTag",gson.toJson(chatMessage).getBytes(RemotingHelper.DEFAULT_CHARSET));
            SendResult sendResult = producer.getProducer().send(msg);
            System.out.println("SendResult: " + sendResult);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (RemotingException e) {
            e.printStackTrace();
        } catch (MQClientException e) {
            e.printStackTrace();
        } catch (MQBrokerException e) {
            e.printStackTrace();
        }

        return chatMessage;
    }
}
