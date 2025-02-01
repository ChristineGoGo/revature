package com.revature.bootpie.services;

import java.util.ArrayList;
import java.util.List;

import javax.naming.AuthenticationException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.bootpie.Exceptions.ResourceNotFoundException;
import com.revature.bootpie.models.Consumer;

@Service
public class ConsumerService {
    
    private List<Consumer> consumerList = new ArrayList<>();
    
    private PieService pieService;

    @Autowired
    public ConsumerService(PieService pieService) {this.pieService = pieService;}

    {
        Consumer consumer = new Consumer(null, "admin", "admin");
        consumerList.add(consumer);
    }

    public void register(Consumer newConsumer) {
        consumerList.add(newConsumer);
    }

    public void order(String username, String pieName) {
        for(Consumer consumer: consumerList) {
            if (consumer.getUsername().equals(username)){
                consumer.setLastPie(pieService.findPie(pieName));
                return;
            }
        }
        throw new ResourceNotFoundException(username + " was not found in the list. Please check username and try again");
    }

    public void login(String username, String password) throws AuthenticationException {
        for (Consumer consumer:consumerList) {
            if(consumer.getUsername().equals(username) && consumer.getPassword().equals(password)) {
                return;
            }
        }
        throw new AuthenticationException("Check username and password credentials as they are invalid");
    }

}
