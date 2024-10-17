package com.example.task04;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

public class RotationFileHandler implements MessageHandler{
    private final String file;
    private final ChronoUnit rotationUnit;

    public RotationFileHandler(String filePath, ChronoUnit rotationUnit) {
        this.file = filePath;
        this.rotationUnit = rotationUnit;
    }

    @Override
    public void handleMessage(String message) {
        String newFile = file + LocalDateTime.now().truncatedTo(rotationUnit);

        try (FileOutputStream fos = new FileOutputStream(newFile, true)) {
            fos.write((message + "\n").getBytes());
        } catch (IOException e) {
            System.err.println("Error");
        }
    }
}
