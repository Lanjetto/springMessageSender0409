package com.nexign.springMessageSender.model;

import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.Random;

@Component
@Scope("prototype")
public class Title {

    @Value("${strings}")
    private String[] randomString;
    private String text ;

    @PostConstruct
    public void init() {
        Random random = new Random();
        int i = random.nextInt(randomString.length);
        this.text = randomString[i];
    }


    public String getText() {
        return text;
    }
}
