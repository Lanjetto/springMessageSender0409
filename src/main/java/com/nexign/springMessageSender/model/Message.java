package com.nexign.springMessageSender.model;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Component
@Scope("prototype")
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
