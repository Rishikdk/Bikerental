package com.rental.bikerent.controller;

public class Message {
    private String content;
    private String type;

    public Message(String s, String s1) {
    }

    public String getContent() {
        return content;
    }

    public String getType() {
        return type;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public void setType(String type) {
        this.type = type;
    }
}
