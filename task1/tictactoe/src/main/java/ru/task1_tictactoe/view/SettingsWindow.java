package ru.task1_tictactoe.view;

import ru.task1_tictactoe.config.AppConfig;

import javax.swing.*;
import java.awt.*;

public class SettingsWindow extends JFrame {
    private static final int WINDOW_HEIGHT = 230;
    private static final int WINDOW_WIDTH = 350;
    private static final JLabel fieldSizeLabel = new JLabel("Select field sizes");
    private static final JLabel setFieldSizeLabel = new JLabel("Set field size:");
    private static final JLabel setFieldLengthLabel = new JLabel("Set length:");
    private static final JSlider fieldSizeLabelSlider = new JSlider(3,10);
    private static final JSlider fieldLengthLabelSlider = new JSlider(3,10);

    SettingsWindow(MainWindow mainWindow) {
        init(mainWindow);
    }

    private void init(MainWindow mainWindow) {
        setLocationRelativeTo(mainWindow);
        setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
//        setLocation(WINDOW_POSX, WINDOW_POSY);
//        setTitle(GAME_NAME);
//        setIconImage(new ImageIcon(AppConfig.getProperty("game.icon")).getImage());
//
//        //setResizable(false);
//
//        var menuBar = new JMenuBar();
//        menuBar.add(menuGame);
//        menuBar.add(menuHelp);
//        menuGame.add(menuGameNew);
//        menuGame.add(menuGameSettings);
//        menuGame.add(menuGameExit);
//        menuHelp.add(menuHelpHelp);
//        menuHelp.add(menuHelpAbout);
//
//        add(menuBar, BorderLayout.NORTH);
    }

}
