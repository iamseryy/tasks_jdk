package ru.task1_tictactoe.controller;

import ru.task1_tictactoe.config.AppConfig;
import ru.task1_tictactoe.view.MainWindow;
import javax.swing.*;
import java.util.logging.Level;

public class AppController {
    public void start(){
        AppConfig.LOGGER.log(Level.INFO, "Application started");
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new MainWindow();
            }
        });
    }
}
