package com.example.springproject.repository;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.example.springproject.entity.Account;

public interface AccountRepository extends  CrudRepository<Account, Integer> {
    Optional<Account> findByUsernameAndPassword(String username, String password);
    Optional<Account> findByUsername(String username);
}
