package com.example.task14.service;

import com.example.task14.model.Post;
import com.example.task14.repository.PostRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.*;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDate;
import java.util.List;

@ExtendWith(MockitoExtension.class)
public class PostServiceTest {
    @InjectMocks
    private PostService postService;

    @Mock
    private PostRepository postRepository;

    @Captor
    ArgumentCaptor<Post> captor;

    @Test
    void createPost() {
        LocalDate date = LocalDate.now();
        postService.save(new Post(1, "Post1", date, null));
        Mockito.verify(postRepository).save(captor.capture());
        var captured = captor.getValue();
        Assertions.assertEquals("Post1", captured.getText());
        Assertions.assertEquals(date, captured.getCreationDate());
    }

    @Test
    void deleteMarket(){
        postService.deleteById(1);
        Mockito.verify(postRepository).deleteById(1);
    }

    @Test
    void getAll() {
        var post1 = new Post(1, "Post1", LocalDate.now(), null);
        var post2 = new Post(2, "Post2", LocalDate.now(), null);
        Mockito.when(postRepository.findAll()).thenReturn(List.of(post1, post2));

        Assertions.assertEquals(2, postService.findAll().size());
        Assertions.assertEquals("Post1", postService.findAll().get(0).getText());
    }
}
