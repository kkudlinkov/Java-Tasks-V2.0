package com.example.task14.repository;

import com.example.task14.model.Post;
import jakarta.transaction.Transactional;

import java.time.LocalDate;
import java.util.List;

@Transactional
public interface PostFilter {
    List<Post> findByText(String text);
    List<Post> finByCreationDate(LocalDate creationDate);
}
