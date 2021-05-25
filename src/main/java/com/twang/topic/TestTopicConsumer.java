package com.twang.topic;

import org.apache.xbean.spring.context.ClassPathXmlApplicationContext;
import org.springframework.context.ApplicationContext;
import org.springframework.jms.core.JmsTemplate;

public class TestTopicConsumer {

    public static void main(String[] args) {

        ApplicationContext context = new ClassPathXmlApplicationContext("classpath:application-topic.xml");

        JmsTemplate jmsTemplate = context .getBean(JmsTemplate.class);

        Object object = jmsTemplate.receiveAndConvert();
        System.out.println("接收到消息："+object);

    }
}
