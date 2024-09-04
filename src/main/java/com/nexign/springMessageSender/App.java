package com.nexign.springMessageSender;

import com.nexign.springMessageSender.factory.BeanFactory;
import com.nexign.springMessageSender.model.Destination;
import com.nexign.springMessageSender.model.Message;
import com.nexign.springMessageSender.service.MessageSender;

public class App {
    public static void main(String[] args) {

        MessageSender messageSender = BeanFactory.getBean(MessageSender.class);
        messageSender.sendMessage();

    }
}
