package com.example.simplemessageapp.repository;

import com.example.simplemessageapp.model.Message;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class MessageRepository {

    private final List<Message> messages = new ArrayList<>();
    private int latestId = 0;

    public MessageRepository() {
        populateMessages();
    }

    private void populateMessages() {
        int initialNumMessages = 4;
        while (latestId <= initialNumMessages - 1) {
            messages.add(new Message(getNextId(), "Dette er den " + latestId + ". besked"));
        }
    }

    public List<Message> getMessages() {
        return messages;
    }

    private int getNextId() {
        this.latestId++;
        return latestId;
    }

    public Message getMessageById(int id) {
        for (Message message : messages) {
            if (message.getId() == id) {
                return message;
            }
        }
        return null;
    }

    public Message addMessage(Message message) {

        message.setId(getNextId());

        if (message.getContent() == null) {
            message.setContent("This message has no content");
        }

        this.messages.add(message);
        return message;
    }
}
