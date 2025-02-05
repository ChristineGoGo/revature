package com.example.springproject.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.springproject.entity.Account;
import com.example.springproject.entity.Message;
import com.example.springproject.repository.AccountRepository;
import com.example.springproject.repository.MessageRepository;

@Service
public class MessageService {
    private final MessageRepository messageRepository;
    private final AccountRepository accountRepository;
    // @Autowired
    public MessageService(MessageRepository messageRepository, AccountRepository accountRepository) {
        this.messageRepository = messageRepository;
        this.accountRepository = accountRepository;
    }

    /**
     * costructor to inject the repository into the service
     */
    
    /**
     * get all messages
     * @return list of all messages
     */

    public List<Message> getMessages() 
    {
        return messageRepository.findAll();
    }

    /**
     * get all the messages in the database according to the message id
     * @param messageId
     * @return List<Messages>
     */
    public Message getMessageById(int messageId) {
        Optional<Message> optionalMessage = messageRepository.findById(messageId);
        if (optionalMessage.isPresent()) {
            return optionalMessage.get();
        }
        return null;
    }

    /**
     * delete message from the database
     * @param message
     * @return
     */
    public void deleteMessage(int messageId) {
        messageRepository.deleteById(messageId);
    }

    /**
     * modify the messagetext in the database given its id
     * and the message to modify to
     * @param messageId
     * @param messageText
     * @return
     */
    public void updateMessage(int messageId, String messageText) {
        Optional<Message> optionalMessage = messageRepository.findById(messageId);
        if (optionalMessage.isPresent()) {
            Message message = optionalMessage.get();
            message.setMessageText(messageText);
            messageRepository.save(message);
        }
    }

    /**
     * add a new message into the database  
     * @param message
     * @return added message
     */
    public Message addMessage(Message message) {
        String message_text = message.getMessageText();
        Optional<Account> userExist = accountRepository.findById(message.getPostedBy());
        if (userExist.isPresent() && message_text.length() < 255 && message_text.length() > 0) {
            return messageRepository.save(message);
        }
        return null;
    }

}
