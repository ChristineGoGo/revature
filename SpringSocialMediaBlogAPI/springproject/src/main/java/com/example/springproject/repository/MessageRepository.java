package com.example.springproject.repository;

// import org.springframework.data.repository.CrudRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.springproject.entity.Message;

@Repository
public interface MessageRepository extends JpaRepository<Message, Integer>{

}
