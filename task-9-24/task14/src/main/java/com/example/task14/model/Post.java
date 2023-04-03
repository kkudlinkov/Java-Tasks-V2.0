package com.example.task14.model;

import java.time.LocalDate;

public class Post {
    private String text;
    private LocalDate creationDate;

    public String getText() {
        return text;
    }

    public LocalDate getCreationDate() {
        return creationDate;
    }

    public void setText(String text) {
        this.text = text;
    }

    public void setCreationDate(LocalDate creationDate) {
        this.creationDate = creationDate;
    }
}
