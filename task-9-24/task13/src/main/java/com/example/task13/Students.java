package com.example.task13;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.EnvironmentAware;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

@Component
public class Students implements EnvironmentAware {
    private String name;
    private String lastName;
    private String group;

    @Value("${student.name}")
    private void setName(String name) {
        this.name = name;
    }

    @Value("${student.last_name}")
    private void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @Value("${student.group}")
    private void setGroup(String group) {
        this.group = group;
    }

    @Override
    public void setEnvironment(Environment environment) {
        System.out.println("Student name: " + name);
        System.out.println("Student last name: " + lastName);
        System.out.println("Student group: " + group);
    }
}
