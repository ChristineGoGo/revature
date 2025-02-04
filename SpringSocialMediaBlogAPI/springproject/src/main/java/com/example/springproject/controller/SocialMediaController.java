package com.example.springproject.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.springproject.entity.Account;
import com.example.springproject.entity.Message;
import com.example.springproject.service.AccountService;
import com.example.springproject.service.MessageService;




@RestController
public class SocialMediaController {

    @Autowired
    private final MessageService messageService;
    private final AccountService accountService;

    /**
     * initialize constructor to utilize the Service package
     * @param messageService
     * @param accountService
     */
    public SocialMediaController(MessageService messageService, AccountService accountService) {
        this.messageService = messageService;
        this.accountService = accountService;
    }

    /**
     * user should be able to create new account
     * POST localhost:8080/register
     * username should not be blank - 400 error
     * password atleat 4 characters long - 400 error
     * account with that username should not already exist - 409 error
     * @param account
     * @return persisted account 200 OK response 
     */
    @PostMapping("register")
    public @ResponseBody ResponseEntity<Account> registerAccount(@RequestBody Account newAccount)
    {
        Account accountToBeadded = accountService.findUser(newAccount.getUsername());
        if (!(accountToBeadded == null)) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body(newAccount);
        } else if (newAccount.getUsername().length() == 0 || newAccount.getPassword().length() < 4) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(newAccount);
        }
        accountService.registerAccount(newAccount);
        return ResponseEntity.status(HttpStatus.CREATED).body(newAccount);
    }

    /**
     * verify login
     * @param username
     * @param password
     * @return account record in the database
     */
    @PostMapping("login")
    public @ResponseBody ResponseEntity<Account> userLogin(@RequestBody Account account) {
        if (accountService.userLogin(account) == null)
            return ResponseEntity.status(401).body(account);                                                                
        return ResponseEntity.status(HttpStatus.OK).body(account);
    }
    
    /**
     * create new message
     * @param message
     * @return newly created message
     */
    @PostMapping("messages")
    public @ResponseBody ResponseEntity<Message> addMessage(@RequestBody Message message) {
        Message newMessage = messageService.addMessage(message) ;
        if (!(newMessage == null)) {
            return ResponseEntity.status(HttpStatus.OK).body(newMessage);
        }
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(message);
    }
    
    /**
     * @return list of all the messages in the database
     */
    @RequestMapping("messages")
    public @ResponseBody List<Message> getMessages() {
        return messageService.getMessages();
    }

    /**
     * retrieve a message by the message_id
     * @param message_id
     * @return message
     */
    @GetMapping("messages/{message_id}")
    public @ResponseBody ResponseEntity<Message> getMessageById(@RequestParam int message_id) {
        Message newMessage = messageService.getMessageById(message_id);
        return ResponseEntity.status(HttpStatus.OK).body(newMessage);
    }

    /**
     * delete a message from the database
     * @param message_id
     * @return 200 response regardless of message existance/non existance 
     * and deleted message
     */
    @DeleteMapping("messages/{message_id}")
    public @ResponseBody ResponseEntity<Message> deleteMessage(@PathVariable int message_id) {
        Message messageToDelete = messageService.getMessageById(message_id);
        if (!(messageToDelete == null)) {
            messageService.deleteMessage(message_id);
        }
        return ResponseEntity.status(HttpStatus.OK).body(messageToDelete);
    }

    /**
     * update the message text of a message given its message id
     * @param message_id
     * @return updated message
     */
    @PatchMapping("messages/{message_id}")
    public @ResponseBody ResponseEntity<Message> patchMessage(@PathVariable int message_id, @RequestParam String message_text ) {
        Message messageToPatch = messageService.getMessageById(message_id);
        if (!(messageToPatch == null) && message_text.length() > 0 && message_text.length() < 255) {
            messageService.updateMessage(message_id, message_text);
            return ResponseEntity.status(HttpStatus.OK).body(messageToPatch);
        }
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
    }

    /**
     * get all message from a user given their id
     * @param account id
     * @return list of messages by a particular user
     */
    @GetMapping("accounts/{account_id}/messages}")
    public @ResponseBody ResponseEntity<Message> getMessageByUser(@PathVariable int account_id) {
        Message messages = accountService.getUserMessages(account_id);
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(messages);
    }
    


    
}
