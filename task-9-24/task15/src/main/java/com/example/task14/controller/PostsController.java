package com.example.task14.controller;


import com.example.task14.model.Post;
import com.example.task14.repository.PostsRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/post")
@RequiredArgsConstructor
public class PostsController {

    private final PostsRepository postsRepository;

    @PostMapping
    public Post createPost(@RequestBody Post post) {
        return postsRepository.save(post);
    }

    @GetMapping
    public List<Post> getAllLevels() {
        return postsRepository.findAll();
    }

    @DeleteMapping("/{id}")
    public void deleteLevel(@PathVariable int id) {
        postsRepository.deleteById(id);
    }
}
