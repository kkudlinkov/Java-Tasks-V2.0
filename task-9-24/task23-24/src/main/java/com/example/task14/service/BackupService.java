package com.example.task14.service;

import com.example.task14.model.Post;
import com.example.task14.model.User;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.jmx.export.annotation.ManagedOperation;
import org.springframework.jmx.export.annotation.ManagedResource;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j
@RequiredArgsConstructor
@ManagedResource(objectName = "com.example.service:type=BackupService", description = "Backup Service")
public class BackupService {
    private final PostService postService;
    private final UserService userService;

    @Scheduled(cron = "0 * * * * *") // каждую минуту
//    @Scheduled(cron = "0 0/30 * * * *") // каждые 30 минут
    public void createBackupFiles() {
        log.info("Backup started");
        File backupDir = new File("backup");
        if (!backupDir.exists()) {
            backupDir.mkdir();
        } else {
            for (File file : backupDir.listFiles()) {
                file.delete();
            }
        }

        // создание файла для сущности User
        List<User> users = userService.findAll();
        String gameData = users.stream()
                .map(User::toString)
                .collect(Collectors.joining(System.lineSeparator()));
        writeFile("backup/users.txt", gameData);

        // создание файла для сущности post
        List<Post> levels = postService.findAll();
        String levelData = levels.stream()
                .map(Post::toString)
                .collect(Collectors.joining(System.lineSeparator()));
        writeFile("backup/posts.txt", levelData);
    }

    private void writeFile(String filePath, String data) {
        try {
            FileWriter writer = new FileWriter(filePath);
            writer.write(data);
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @ManagedOperation(description = "Generates files and clears directory.")
    public void generateFiles() {
        createBackupFiles();
    }

}