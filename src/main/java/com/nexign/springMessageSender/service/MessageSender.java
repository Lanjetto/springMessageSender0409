package com.nexign.springMessageSender.service;

import com.nexign.springMessageSender.dao.MessageDAO;
import com.nexign.springMessageSender.model.Destination;
import com.nexign.springMessageSender.model.IMessage;
import com.nexign.springMessageSender.model.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

@Component
public class MessageSender {


    private IMessage message;
    private Destination destination;
    private MessageDAO messageDAO;

    @Autowired
    public MessageSender(Message message, Destination destination, MessageDAO messageDAO) {
        this.message = message;
        this.destination = destination;
        this.messageDAO = messageDAO;
    }

    public IMessage getMessage() {
        return message;
    }

    public void setMessage(IMessage message) {
        this.message = message;
    }

    public Destination getDestination() {
        return destination;
    }

    public void setDestination(Destination destination) {
        this.destination = destination;
    }

    public void sendMessage() {
        System.out.println(message + " отправлено в " + destination);
        messageDAO.send(message.toString());
    }

    public void sendMessage(List<Message> m) {
        m.stream().peek(System.out::println)
                .forEach(message1 -> messageDAO.send(message1.toString()));
    }

    @Override
    public String toString() {
        return "MessageSender{" +
                "message=" + message +
                ", destination=" + destination +
                '}';
    }
}
