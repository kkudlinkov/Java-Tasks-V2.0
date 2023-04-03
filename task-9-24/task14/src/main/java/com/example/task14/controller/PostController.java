package com.example.task14.controller;


import com.example.task14.model.Post;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/post")
public class PostController {
    private final List<Post> posts = new ArrayList<>();

    @PostMapping
    public Post createPost(@RequestBody Post post){
        posts.add(post);
        return post;
    }

    @GetMapping
    public List<Post> getAllLevels() {
        return posts;
    }

    @DeleteMapping("/{id}")
    public void deleteLevel(@PathVariable int id) {
        if (id < posts.size()) {
            posts.remove(id);
        }
    }
}
