package com.example.springbootmongodb.services;

import com.example.springbootmongodb.domain.Post;
import com.example.springbootmongodb.repositories.PostRepository;
import com.example.springbootmongodb.services.exceptions.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PostService {

    @Autowired
    private PostRepository repository;

    public Post findById(String id) {

        if (!repository.existsById(id)) {
            throw new ObjectNotFoundException("Post não encontrado");
        }

        return repository.findById(id).get();
    }

    public List<Post> findByTitle(String text) {
        return repository.findByTitleContainingIgnoreCase(text);
    }

}
