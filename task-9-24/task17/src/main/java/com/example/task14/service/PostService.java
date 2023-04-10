package com.example.task14.service;

import com.example.task14.model.Post;
import com.example.task14.model.User;
import com.example.task14.repository.PostRepository;
import com.example.task14.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class PostService {
    private final PostRepository postRepository;
    private final UserService userService;

    public Post save(Post post) {
        return postRepository.save(post);
    }

    public Optional<Post> findById(int id) {
        return postRepository.findById(id);
    }

    public Post getById(int id) {
        return findById(id).orElseThrow();
    }

    public List<Post> findAll(){
        return postRepository.findAll();
    }

    public void deleteById(int id){
        postRepository.deleteById(id);
    }

    public void setUser(int postId, int userId) {
        User user = userService.getById(userId);
        Post post = getById(postId);
        post.setUser(user);
        save(post);
    }

    public void unsetUser(int id) {
        Post post = getById(id);
        post.setUser(null);
        save(post);
    }

    public List<Post> findByText(String text) {
        return postRepository.findByText(text);
    }

    public List<Post> findByCreationDate(LocalDate creationDate) {
        return postRepository.finByCreationDate(creationDate);
    }
}
