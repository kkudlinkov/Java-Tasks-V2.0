package com.example.task14.service;

import com.example.task14.model.Post;
import com.example.task14.model.User;
import com.example.task14.repository.PostRepository;
import com.example.task14.repository.UserRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Slf4j
public class PostService {
    private final PostRepository postRepository;
    private final UserService userService;
//    private final EmailService emailService;

    public Post save(Post post) {
        log.info("Save Post, {}", post);
//        emailService.sendEmail("Post saved", "Post saved " + post.toString());
        return postRepository.save(post);
    }

    @Transactional
    public Optional<Post> findById(int id) {
        log.info("Find post by id:{}", id);
        return postRepository.findById(id);
    }

    public Post getById(int id) {
        log.info("Get post by Id{}", id);
        return findById(id).orElseThrow();
    }

    @Transactional
    public List<Post> findAll(){
        log.info("Find All");
        return postRepository.findAll();
    }

    @Transactional
    public void deleteById(int id){
        log.info("Delete Post by Id:{}", id);
        postRepository.deleteById(id);
    }

    @Transactional
    public void setUser(int postId, int userId) {
        log.info("Set User:{} for Post:{}", userId, postId);
        User user = userService.getById(userId);
        Post post = getById(postId);
        post.setUser(user);
        save(post);
    }

    @Transactional
    public void unsetUser(int id) {
        log.info("UnsetUser by id:{}", id);
        Post post = getById(id);
        post.setUser(null);
        save(post);
    }

    @Transactional
    public List<Post> findByText(String text) {
        log.info("Find post by Text:{}", text);
        return postRepository.findByText(text);
    }

    @Transactional
    public List<Post> findByCreationDate(LocalDate creationDate) {
        log.info("Find post by creationDate:{}", creationDate);
        return postRepository.finByCreationDate(creationDate);
    }
}
