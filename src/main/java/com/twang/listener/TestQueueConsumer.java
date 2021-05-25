package com.twang.listener;

import org.apache.xbean.spring.context.ClassPathXmlApplicationContext;
import org.springframework.context.ApplicationContext;
import org.springframework.jms.core.JmsTemplate;

import javax.jms.JMSException;

public class TestQueueConsumer {

    public static void main(String[] args) throws JMSException {

        ApplicationContext context = new ClassPathXmlApplicationContext("classpath:application-queue-listener.xml");

        JmsTemplate jmsTemplate = context.getBean(JmsTemplate.class);

        //TextMessage textMessage = (TextMessage) jmsTemplate.receive();
        //System.out.println(textMessage.getText());

        Object object = jmsTemplate.receiveAndConvert();
        System.out.println("收到消息："+object);



    }

}
