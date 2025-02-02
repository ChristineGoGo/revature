package com.example.springproject.entity;

// import javax.persistence.*;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;


@Entity
@Table(name="account")
public class Account {
    @Column(name="accountId")
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)

    private Integer accountId;
    private String username;
    private String password;

    public Account() {
    }

    /**
     * for posting a new account, the account id is not needed
     * @param String password
     * @param String username
     */
    public Account(String password, String username) {
        this.password = password;
        this.username = username;
    }

    /**
     * for retrieving a new account from the database
     * all the fields are needed
     * @param int accountId
     * @param String password
     * @param String username
     */
    public Account(Integer accountId, String password, String username) {
        this.accountId = accountId;
        this.password = password;
        this.username = username;
    }

    /**
     * properly named getters and setters are needed for JacksonObjectMapper to work
     * @return accountId
     */

    public Integer getAccountId() {
        return accountId;
    }

    /**
     * properly named getters and setters are needed for JacksonObjectMapper to work
     * @param accountId
     */

    public void setAccountId(Integer accountId) {
        this.accountId = accountId;
    }

    /**
     * properly named getters and setters are needed for JacksonObjectMapper to work
     * @return username
     */

    public String getUsername() {
        return username;
    }

    /**
     * properly named getters and setters are needed for JacksonObjectMapper to work
     * @param username
     */

    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * properly named getters and setters are needed for JacksonObjectMapper to work
     * @return password
     */
    public String getPassword() {
        return password;
    }

    /**
     * properly named getters and setters are needed for JacksonObjectMapper to work
     * @param password
     */

    public void setPassword(String password) {
        this.password = password;
    }
}
