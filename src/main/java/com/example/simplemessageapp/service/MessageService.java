package com.example.simplemessageapp.service;

import com.example.simplemessageapp.model.Message;
import com.example.simplemessageapp.repository.MessageRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MessageService {
    private final MessageRepository repository;

    public MessageService(MessageRepository repository) {
        this.repository = repository;
    }

    public List<Message> getMessages() {
        return repository.getMessages();
    }

    public Message findMessageById(int id, String caps) {
        Message message = repository.getMessageById(id);

        if (caps != null && caps.equalsIgnoreCase("yes")) {
            message = new Message(id, message.getContent().toUpperCase());
        }

        return message;
    }

    public Message addMessage(Message message) {
        return this.repository.addMessage(message);
    }




}
