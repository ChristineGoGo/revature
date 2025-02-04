package com.example.springproject.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.springproject.entity.Message;

@Repository
public interface MessageRepository extends JpaRepository<Message, Integer>{
    Optional<Message> findByPostedBy(int posted_by);
}
