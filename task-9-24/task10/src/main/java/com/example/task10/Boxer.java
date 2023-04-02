package com.example.task10;

import org.springframework.stereotype.Component;

@Component
public class Boxer implements Fighter {

    @Override
    public void doFight() {
        System.out.println("Boxer fight");
    }
}
