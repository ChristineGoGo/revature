package com.example.springproject.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.springproject.entity.Message;
import com.example.springproject.repository.MessageRepository;

import java.util.List;

@Service
public class MessageService {

    @Autowired
    private MessageRepository messageRepository;
    /**
     * get all messages
     * @return list of all messages
     */
    public List<Message> getMessages() {
        return messageRepository.findAll();
    }
}
