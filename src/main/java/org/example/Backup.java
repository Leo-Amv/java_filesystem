package org.example;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class Backup {
    /**
     * Производит копию всех файлов в текущей директории в указанную в параметре папку
     * @param backupDirectoryPath Путь папки резервной копии
     */
    public static void backup (String backupDirectoryPath) {

        File directory = new File(".");

        // Создаем папку для резервной копии
        File backupDirectory = new File(backupDirectoryPath);

        if (!backupDirectory.exists()) {
            backupDirectory.mkdirs();
        }

        File[] files = directory.listFiles();

        // Копируем каждый файл в папку с резервной копией
        for (File file : files) {
            if (file.isFile()) {
                try (FileInputStream inputStream = new FileInputStream(file);
                     FileOutputStream outputStream = new FileOutputStream(
                             backupDirectoryPath + "/" + file.getName())) {
                    byte[] buffer = new byte[4096];
                    int bytesRead;
                    while ((bytesRead = inputStream.read(buffer)) != -1) {
                        outputStream.write(buffer, 0, bytesRead);
                    }
                    System.out.println("Created a backup copy of the file: " + file.getName());
                } catch (IOException e) {
                    System.out.println("\n" +
                            "Error while backing up a file: " + file.getName());
                }
            }
        }
        System.out.println("Backup completed!");
    }
}
