package com.example.task14.controller;


import com.example.task14.model.Post;
import com.example.task14.service.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/posts")
@RequiredArgsConstructor
public class PostsController {

    private final PostService postService;


    @PostMapping
    public Post createPost(@RequestBody Post post) {
        return postService.save(post);
    }

    @GetMapping
    public List<Post> getAllLevels() {
        return postService.findAll();
    }

    @DeleteMapping("/{id}")
    public void deleteLevel(@PathVariable int id) {
        postService.deleteById(id);
    }

    @PostMapping("{postId}/set-user/{userId}")
    public void setPostUser(@PathVariable int postId, @PathVariable int userId) {
        postService.setUser(postId, userId);
    }

    @DeleteMapping("/unset-user/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void removeLevelFromGame(@PathVariable int id) {
        postService.unsetUser(id);
    }
}