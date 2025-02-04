package com.example.springproject.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.springproject.entity.Account;
import com.example.springproject.entity.Message;
import com.example.springproject.repository.AccountRepository;
import com.example.springproject.repository.MessageRepository;

@Service
public class AccountService {
    @Autowired
    AccountRepository accountRepository;
    MessageRepository messageRepository;

    

    /**
     * define a constructor to initialize the accountRepository
     * @param accountRepository
     */
    public AccountService(AccountRepository accountRepository, MessageRepository messageRepository) {
        this.accountRepository = accountRepository;
        this.messageRepository = messageRepository;
    }

    /**
     * add a new account to the database
     * @param username
     * @param password
     */
    public Account registerAccount(Account account) {
        Account newAccount = new Account(account.getPassword(), account.getUsername());
        return accountRepository.save(newAccount);
    }

    /**
     * log into as a user
     * @param username
     * @param password
     * @return account ofr the user
     */
    public Account userLogin(Account account) {
        String username = account.getUsername();
        String password = account.getPassword();
        Optional<Account> optionalAccount = accountRepository.findByUsernameAndPassword(username, 
                                                                                        password);
        if (optionalAccount.isPresent()) {
            return optionalAccount.get();
        } else {
            return null;
        }
        
    }

    /**
     * find a user in the database
     * @param account
     */
    public Account findUser(String username) {
        Optional<Account> optionalAccount = accountRepository.findByUsername(username);
        if (optionalAccount.isPresent()) {
            return optionalAccount.get();
        }
        return null;
    }

    /**
     * find all the messages by a particular user
     * @param user_id/ posted_by
     * @return all the user messages
     */
    public List<Message> getUserMessages(int user_id) {
        List<Message> messages = new ArrayList<>(messageRepository.findByPostedBy(user_id));

        if (messages.isEmpty()) return null;
        return messages;
    }

    
}
