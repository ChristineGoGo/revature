package com.revature.bootpie.models;

public class Consumer {
    private String username;
    private String password;
    private Pie lastPie;

    public Consumer() {
    }

    public Consumer(Pie lastPie, String password, String username) {
        this.lastPie = lastPie;
        this.password = password;
        this.username = username;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Pie getLastPie() {
        return lastPie;
    }

    public void setLastPie(Pie lastPie) {
        this.lastPie = lastPie;
    }




}
