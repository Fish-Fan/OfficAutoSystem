import com.google.gson.Gson;
import org.apache.rocketmq.client.consumer.DefaultMQPushConsumer;
import org.apache.rocketmq.client.consumer.listener.ConsumeConcurrentlyContext;
import org.apache.rocketmq.client.consumer.listener.ConsumeConcurrentlyStatus;
import org.apache.rocketmq.client.consumer.listener.MessageListenerConcurrently;
import org.apache.rocketmq.client.exception.MQClientException;
import org.apache.rocketmq.common.message.MessageExt;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException, MQClientException {
        ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("classpath*:application*.xml");
        ctx.start();
        System.out.println("running...");

        DefaultMQPushConsumer consumer = new DefaultMQPushConsumer("OAConsumer");
        consumer.setNamesrvAddr("localhost:9876");
        consumer.subscribe("SocketTopic","*");
        consumer.registerMessageListener(new MessageListenerConcurrently() {
            @Override
            public ConsumeConcurrentlyStatus consumeMessage(List<MessageExt> list, ConsumeConcurrentlyContext consumeConcurrentlyContext) {
                Gson gson = new Gson();
                for(MessageExt messageExt : list) {
                    System.out.println("messageExt: " + messageExt);
                    try {
                        String messageBody = new String(messageExt.getBody(),"utf-8");
//                        MyContent content = gson.fromJson(messageBody,MyContent.class);
                        System.out.println(Thread.currentThread().getName() + " receive message : " + messageBody);
                    } catch (UnsupportedEncodingException e) {
                        e.printStackTrace();
                    }


                }
                return ConsumeConcurrentlyStatus.CONSUME_SUCCESS;
            }
        });

        consumer.start();
        System.out.println("Consumer start...");

        System.in.read();
    }
}
