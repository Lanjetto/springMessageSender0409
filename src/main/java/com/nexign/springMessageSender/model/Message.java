package com.nexign.springMessageSender.model;

import org.springframework.stereotype.Component;

@Component
public class Message implements IMessage{

    private Title title;

    public Message(Title title) {
        this.title = title;
    }

    @Override
    public String toString() {
        return title.getText();
    }
}
