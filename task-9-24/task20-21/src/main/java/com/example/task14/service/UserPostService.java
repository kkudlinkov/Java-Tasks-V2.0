package com.example.task14.service;

import com.example.task14.model.Post;
import com.example.task14.model.User;
import lombok.RequiredArgsConstructor;
import com.github.javafaker.Faker;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
@RequiredArgsConstructor
@Slf4j
public class UserPostService {
    private final UserService userService;
    private final PostService postService;


    public Post addNewPostToUser(int userId, Post post) {
        log.info("Add new level ({}) to gameId:{}", post, userId);
        User user = userService.getById(userId);
        post.setUser(user);
        postService.save(post);
        return post;
    }

    @Transactional
    public List<User> generateFakeData(int numberOfUsers) {
        log.info("Generate fake data (n:{})", numberOfUsers);
        Faker faker = new Faker();
        List<User> users = new ArrayList<>();
        for (int i = 0; i < numberOfUsers; i++) {
            User user = new User();
            user.setFirstName(faker.app().name());
            user.setLastName(faker.app().name());
            user.setMiddleName(faker.app().name());
            user.setBirthDate(LocalDate.now().minusDays(i));

            Set<Post> posts = new HashSet<>();
            for (int j = 0; j < faker.number().numberBetween(1, 5); j++) {
                Post post = new Post();
                post.setText(faker.app().name());
                post.setCreationDate(LocalDate.now().minusDays(i));
                post.setUser(user);
                posts.add(post);
            }

            user.setPosts(posts);
            userService.save(user);
            users.add(user);
        }
        return users;
    }
}