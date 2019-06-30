package com.example.carsharingbackend.services;

import com.example.carsharingbackend.entity.userinfo.Message;
import com.example.carsharingbackend.repositories.MessageRepository;
import org.springframework.stereotype.Service;

import java.util.Collection;


@Service
public class MessageService {
    private MessageRepository repository;

    public MessageService(MessageRepository repository) {
        this.repository = repository;
    }

//    public Message get(long id) {
//        return repository.findById(id).orElseThrow(ObjectNotFoundException::new);
//    }

    public Collection<Message> findByUser(long id) {
        return repository.findByUserIdAndReadFalseOrderByDateDesc(id);
    }

    public void create(Message object) {
        repository.save(object);
    }

//    public void update(Message object) {
//        get(object.getId());
//        repository.save(object);
//    }
//
//    public void delete(Message object) {
//        repository.save(get(object.getId()));
//    }
}
