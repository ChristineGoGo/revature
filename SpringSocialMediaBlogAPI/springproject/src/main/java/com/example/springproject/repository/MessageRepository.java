package com.example.springproject.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.springproject.entity.Message;

@Repository
public interface MessageRepository extends CrudRepository<Message, Integer>{

}
