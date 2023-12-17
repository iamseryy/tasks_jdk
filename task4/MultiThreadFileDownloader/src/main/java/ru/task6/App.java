package ru.task6;


import ru.task6.utils.FileUtils;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.file.Path;


public class App {
    public static void main( String[] args ) {
        URL[] sourceUrls = new URL[0];
        try {
            sourceUrls = new URL[]{
                    new URL("https://gbcdn.mrgcdn.ru/uploads/record/295560/attachment/f26fbaea7b46f64261938ae8e57691a8.mp4"),
                    new URL("https://gbcdn.mrgcdn.ru/uploads/record/297305/attachment/281a3b2ba24e6f9c3e02f7994fda87aa.mp4"),
                    new URL("https://gbcdn.mrgcdn.ru/uploads/record/299317/attachment/ede019a087c7a773091c21c13345ade3.mp4")};
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }

        var outputPath = Path.of("i:\\temp\\");
        int threadsNumber = 2;
        FileUtils.filesMultiThreadDownload(sourceUrls, outputPath, threadsNumber);
    }
}
