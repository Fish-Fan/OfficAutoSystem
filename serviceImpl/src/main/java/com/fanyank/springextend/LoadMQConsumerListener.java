package com.fanyank.springextend;

import com.fanyank.pojo.ChatMessage;
import com.fanyank.serviceImpl.IMServiceImpl;
import com.google.gson.Gson;
import org.apache.rocketmq.client.consumer.DefaultMQPushConsumer;
import org.apache.rocketmq.client.consumer.listener.ConsumeConcurrentlyContext;
import org.apache.rocketmq.client.consumer.listener.ConsumeConcurrentlyStatus;
import org.apache.rocketmq.client.consumer.listener.MessageListenerConcurrently;
import org.apache.rocketmq.client.exception.MQClientException;
import org.apache.rocketmq.common.message.MessageExt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import java.io.UnsupportedEncodingException;
import java.util.List;

@Component
public class LoadMQConsumerListener implements ApplicationListener<ContextRefreshedEvent> {
    @Autowired
    private IMServiceImpl imServiceImpl;
    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {
        DefaultMQPushConsumer consumer = new DefaultMQPushConsumer("OAConsumer");
        consumer.setNamesrvAddr("localhost:9876");
        try {
            consumer.subscribe("SocketTopic","*");
            consumer.registerMessageListener(new MessageListenerConcurrently() {
                @Override
                public ConsumeConcurrentlyStatus consumeMessage(List<MessageExt> list, ConsumeConcurrentlyContext consumeConcurrentlyContext) {
                    Gson gson = new Gson();
                    for(MessageExt messageExt : list) {
                        System.out.println("messageExt: " + messageExt);
                        try {
                            String messageBody = new String(messageExt.getBody(),"utf-8");
                            ChatMessage chatMessage = gson.fromJson(messageBody,ChatMessage.class);
                            imServiceImpl.saveChatMessage(chatMessage);
                            System.out.println(Thread.currentThread().getName() + " receive message : " + messageBody);
                        } catch (UnsupportedEncodingException e) {
                            e.printStackTrace();
                        }


                    }
                    return ConsumeConcurrentlyStatus.CONSUME_SUCCESS;

                }
            });
        } catch (MQClientException e) {
            e.printStackTrace();
        }
        try {
            consumer.start();
        } catch (MQClientException e) {
            e.printStackTrace();
        }
        System.out.println("Consumer start...");
    }
}
