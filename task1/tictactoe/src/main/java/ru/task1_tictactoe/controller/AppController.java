package ru.task1_tictactoe.controller;

import ru.task1_tictactoe.view.MainWindow;

import javax.swing.*;

public class AppController {
    public void start(){
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new MainWindow();
            }
        });
    }
}
