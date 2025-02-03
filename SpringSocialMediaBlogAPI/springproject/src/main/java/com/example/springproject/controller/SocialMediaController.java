package com.example.springproject.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
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
    private MessageService messageService;
    private AccountService accountService;

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
    public @ResponseBody ResponseEntity<Account> userLogin(@RequestParam Account account) {
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
     */
    
}
