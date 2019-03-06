package com.fanyank.rocketmq;

import org.apache.rocketmq.client.exception.MQClientException;
import org.apache.rocketmq.client.producer.DefaultMQProducer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class RocketMQProducer {
    private final Logger logger = LoggerFactory.getLogger(RocketMQProducer.class);

    private DefaultMQProducer producer;
    private String producerGroup;
    private String namesrvAddr;

    public void init() throws MQClientException {
        //参数信息
        logger.info("DefaultMQProducer is initializing");
        logger.info(producerGroup);
        logger.info(namesrvAddr);

        //初始化
        producer = new DefaultMQProducer(producerGroup);
        producer.setNamesrvAddr(namesrvAddr);
        producer.setInstanceName("producerA");
        producer.start();

        logger.info("producer start success");
    }

    public void destroy() {
        producer.shutdown();
    }

    public DefaultMQProducer getProducer() {
        return producer;
    }

    public void setProducerGroup(String producerGroup) {
        this.producerGroup = producerGroup;
    }

    public void setNamesrvAddr(String namesrvAddr) {
        this.namesrvAddr = namesrvAddr;
    }
}
