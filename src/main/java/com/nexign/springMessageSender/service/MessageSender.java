package com.nexign.springMessageSender.service;

import com.nexign.springMessageSender.annotations.Inject;
import com.nexign.springMessageSender.factory.BeanFactory;
import com.nexign.springMessageSender.model.Destination;
import com.nexign.springMessageSender.model.IMessage;
import com.nexign.springMessageSender.model.Message;

public class MessageSender {
    @Inject
    private IMessage message;
    @Inject
    private Destination destination;

//    public MessageSender(Message message, Destination destination) {
//        this.message = message;
//        this.destination = destination;
//    }

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
    }

    @Override
    public String toString() {
        return "MessageSender{" +
                "message=" + message +
                ", destination=" + destination +
                '}';
    }
}
