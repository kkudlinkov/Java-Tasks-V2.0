package com.example.task10;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

@SpringBootApplication
public class Task10Application {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(BeanConfig.class);
        try {
            Fighter fighter = context.getBean(args[0], Fighter.class);
            fighter.doFight();

        } catch (IndexOutOfBoundsException e) {
            e.printStackTrace();
            System.out.println("required");
        }
    }
}
