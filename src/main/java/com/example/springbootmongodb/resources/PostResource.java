package com.example.springbootmongodb.resources;

import com.example.springbootmongodb.domain.Post;
import com.example.springbootmongodb.resources.util.URL;
import com.example.springbootmongodb.services.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value = "posts")
public class PostResource {

    @Autowired
    private PostService service;

    @RequestMapping(method = RequestMethod.GET, value = "/{id}")
    public ResponseEntity<Post> findById(@PathVariable String id) {
        Post post = service.findById(id);
        return ResponseEntity.status(HttpStatus.OK).body(post);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/titlesearch")
    public ResponseEntity<List<Post>> findByTitle(@RequestParam(value = "text", defaultValue = "") String title) {
        title = URL.decodeParam(title);
        List<Post> posts = service.findByTitle(title);
        return ResponseEntity.status(HttpStatus.OK).body(posts);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/fullsearch")
    public ResponseEntity<List<Post>> fullSearch(
            @RequestParam(value = "text", defaultValue = "") String text,
            @RequestParam(value = "minDate", defaultValue = "") String minDate,
            @RequestParam(value = "maxDate", defaultValue = "") String maxDate
    ) {
        text = URL.decodeParam(text);
        LocalDateTime min = URL.convertDate(minDate, LocalDateTime.now());
        LocalDateTime max = URL.convertDate(maxDate, LocalDateTime.now());

        List<Post> posts = service.fullSearch(text, min, max);

        return ResponseEntity.status(HttpStatus.OK).body(posts);
    }
}
