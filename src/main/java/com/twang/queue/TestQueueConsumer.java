package com.twang.queue;

import org.apache.xbean.spring.context.ClassPathXmlApplicationContext;
import org.springframework.context.ApplicationContext;
import org.springframework.jms.core.JmsTemplate;

import javax.jms.JMSException;
import javax.jms.TextMessage;

public class TestQueueConsumer {

    public static void main(String[] args) throws JMSException {

        ApplicationContext context = new ClassPathXmlApplicationContext("classpath:application-queue.xml");

        JmsTemplate jmsTemplate = context.getBean(JmsTemplate.class);

        //TextMessage textMessage = (TextMessage) jmsTemplate.receive();
        //System.out.println(textMessage.getText());

        Object object = jmsTemplate.receiveAndConvert();
        System.out.println("收到消息："+object);



    }

}
