package ru.task6.utils;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class FileUtils {
    private static boolean fileDownload(URL sourceUrl, Path outputPath) {
        try (InputStream inputStream = sourceUrl.openStream()){
                Files.copy(inputStream, outputPath, StandardCopyOption.REPLACE_EXISTING);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return true;
    }

    public static boolean filesMultiThreadDownload(URL[] sourceUrls, Path outputPath, int threadsNumber) {
        var executor = Executors.newFixedThreadPool(threadsNumber);
        for (URL sourceUrl: sourceUrls) {
            var urlFileParts = sourceUrl.getFile().split("/");
            var file = urlFileParts[urlFileParts.length - 1];
            var path = outputPath.resolve(file);

            executor.execute(() -> {
                System.out.println("Thread: " + Thread.currentThread().getName() + "; File: " + file);
                fileDownload(sourceUrl, path);
            });
        }

        executor.shutdown();
        try {
            executor.awaitTermination(10, TimeUnit.MINUTES);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        return true;
    }

}
