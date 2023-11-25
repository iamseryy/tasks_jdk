package ru.task1;

import ru.task1.config.AppConfig;
import ru.task1.view.MainWindow;

import javax.swing.*;
import java.util.logging.Level;

public class ChatClientApp
{
    public static void main( String[] args ) {

        AppConfig.LOGGER.log(Level.INFO, "Application started");
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new MainWindow();
            }
        });
    }
}
