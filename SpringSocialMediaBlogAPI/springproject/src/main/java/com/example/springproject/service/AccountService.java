package com.example.springproject.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.springproject.entity.Account;
import com.example.springproject.repository.AccountRepository;

@Service
public class AccountService {
    AccountRepository accountRepository;
    @Autowired

    /**
     * define a constructor to initialize the accountRepository
     * @param accountRepository
     */
    public AccountService(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    /**
     * add a new account to the database
     * @param username
     * @param password
     */
    public Account registerAccount(Account account) {
        return accountRepository.save(account);
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

    
}
