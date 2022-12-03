package com.example.springbootmongodb.services;

import com.example.springbootmongodb.domain.User;
import com.example.springbootmongodb.repositories.UserRepository;
import com.example.springbootmongodb.services.exceptions.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository repository;

    public List<User> findAll() {
        return repository.findAll();
    }

    public User findById(String id) {

        if (!repository.existsById(id)) {
            throw new ObjectNotFoundException("Objeto não encontrado");
        }

        return repository.findById(id).get();
    }

}
