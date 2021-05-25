package com.twang.listener;

import org.apache.xbean.spring.context.ClassPathXmlApplicationContext;
import org.springframework.context.ApplicationContext;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.Session;
import javax.jms.TextMessage;

public class TestQueueProducer  {

    public static void main(String[] args) {

        /** 获取mq容器*/
        ApplicationContext context =  new ClassPathXmlApplicationContext("classpath:application-queue-listener.xml");
        /** 从IOC容器里面得到jmsTemplate*/
        JmsTemplate jmsTemplate = context.getBean(JmsTemplate.class);
        // 发消息
        jmsTemplate.send(new MessageCreator() {
            @Override
            public Message createMessage(Session session) throws JMSException {
                TextMessage textMessage = session.createTextMessage("MQ-spring");
                textMessage.setStringProperty("md5","天青色等烟雨而我在等你");
                return textMessage;
            }
        });//发送到默认目的地

        System.out.println("消息发送完成.......");

    }

}
