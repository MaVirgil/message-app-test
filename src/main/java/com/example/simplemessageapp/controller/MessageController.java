package com.example.simplemessageapp.controller;

import com.example.simplemessageapp.model.Message;
import com.example.simplemessageapp.service.MessageService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("messages")
public class MessageController {
    private final MessageService service;

    public MessageController(MessageService service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<List<Message>> getMessages() {
        return new ResponseEntity<>(service.getMessages(), HttpStatus.OK);
    }

    @GetMapping("/find/{messageId}")
    public ResponseEntity<Message> findMessageById(@PathVariable int messageId, @RequestParam String caps) {
        return new ResponseEntity<>(service.findMessageById(messageId, caps), HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<Message> addMessage(@RequestBody Message message) {
        return new ResponseEntity<>(this.service.addMessage(message), HttpStatus.CREATED);
    }
}
