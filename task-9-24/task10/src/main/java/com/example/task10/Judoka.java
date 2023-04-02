package com.example.task10;

import org.springframework.stereotype.Component;

@Component
public class Judoka implements Fighter {
    @Override
    public void doFight() {
        System.out.println("Judoka Fight");
    }
}
