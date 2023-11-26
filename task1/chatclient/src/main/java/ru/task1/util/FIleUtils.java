package ru.task1.util;

import ru.task1.config.AppConfig;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.logging.Level;

public class FIleUtils {
    public static void writeFile(String content, String file) {
        var path = Path.of(file);
        try {
            if(!Files.exists(path)) Files.createFile(path);
            Files.writeString(path, content, StandardOpenOption.APPEND);
        } catch (IOException ex) {
            AppConfig.LOGGER.log(Level.SEVERE, ex.toString(), ex);
        }
   }

    public static String readFile(String path) {
        String content = "";
        try {
            content = Files.readString(Path.of(path));
        } catch (IOException e) {
            AppConfig.LOGGER.log(Level.SEVERE, e.toString(), e);
        }
        return content;
    }
}