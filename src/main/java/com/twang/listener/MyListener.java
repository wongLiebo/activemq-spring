package com.twang.listener;

import lombok.SneakyThrows;

import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;

public class MyListener implements MessageListener {
    @SneakyThrows
    @Override
    public void onMessage(Message message) {
        if(message instanceof TextMessage){
            TextMessage textMessage = (TextMessage) message;
            System.out.println("监听器接收到消息："+textMessage.getText());
        }
    }
}
