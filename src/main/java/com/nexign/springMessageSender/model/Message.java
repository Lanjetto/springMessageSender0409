package com.nexign.springMessageSender.model;

import com.nexign.springMessageSender.annotations.Inject;

public class Message implements IMessage{

    @Inject
    private Title title;

//    public Message(Title title) {
//        this.title = title;
//    }

    @Override
    public String toString() {
        return "Message{}";
    }
}
