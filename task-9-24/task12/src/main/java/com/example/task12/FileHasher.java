package com.example.task12;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

@Component
public class FileHasher {
    @Value("${input.file}")
    private String inputFilePath;

    @Value("${output.file}")
    private String outputFilePath;

    private byte[] hash;

    @PostConstruct
    public void hashFile() throws NoSuchAlgorithmException, IOException {
        File inputFile = new File(inputFilePath);
        if (inputFile.exists() && inputFile.isFile()) {
            MessageDigest md = MessageDigest.getInstance("SHA-256");
            try (FileInputStream fis = new FileInputStream(inputFile)) {
                byte[] buffer = new byte[8192];
                int len;
                while ((len = fis.read(buffer)) != -1) {
                    md.update(buffer, 0, len);
                }
            }
            hash = md.digest();
            File outputFile = new File(outputFilePath);
            try (FileOutputStream fos = new FileOutputStream(outputFile)) {
                fos.write(hash);
            }
            inputFile.delete();
        } else {
            hash = null;
            File outputFile = new File(outputFilePath);
            outputFile.createNewFile();
            try (FileOutputStream fos = new FileOutputStream(outputFile)) {
                fos.write("null".getBytes());
            }
        }
    }

    @PreDestroy
    public void deleteOutputFile() {
        File inputFile = new File(inputFilePath);
        inputFile.delete();
    }
}
