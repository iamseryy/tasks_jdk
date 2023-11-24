package ru.task1_tictactoe.view;


import ru.task1_tictactoe.config.AppConfig;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class MainWindow extends JFrame {
    private static final String GAME_NAME = AppConfig.getProperty("game.name");
    private static final int WINDOW_HEIGHT = Integer.parseInt(AppConfig.getProperty("main.window.height"));
    private static final int WINDOW_WIDTH = Integer.parseInt(AppConfig.getProperty("main.window.width"));
    private static final int WINDOW_POSX = Integer.parseInt(AppConfig.getProperty("main.window.pos.x"));
    private static final int WINDOW_POSY = Integer.parseInt(AppConfig.getProperty("main.window.pos.y"));
    private static final JMenuBar menuBar = new JMenuBar();
    private static final JMenu menuGame = new JMenu("Game");
    private static final JMenu  menuHelp = new JMenu("Help");
    private static final JMenuItem menuGameNew = new JMenuItem("New Game");
    private static final JMenuItem menuGameSettings = new JMenuItem("Settings");
    private static final JMenuItem menuGameExit = new JMenuItem("Exit");
    private static final JMenuItem menuHelpHelp = new JMenuItem("Help");
    private static final JMenuItem menuHelpAbout = new JMenuItem("About");


    public MainWindow(){
        init();
        addListeners();
        setVisible(true);
    }

    private void init() {
        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
        setLocation(WINDOW_POSX, WINDOW_POSY);
        setTitle(GAME_NAME);
        setIconImage(new ImageIcon(AppConfig.getProperty("game.icon")).getImage());

        //setResizable(false);

        menuBar.add(menuGame);
        menuBar.add(menuHelp);
        menuGame.add(menuGameNew);
        menuGame.add(menuGameSettings);
        menuGame.add(menuGameExit);
        menuHelp.add(menuHelpHelp);
        menuHelp.add(menuHelpAbout);

        add(menuBar, BorderLayout.NORTH);
    }

    private void addListeners(){
        menuGameNew.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });

        menuGameSettings.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                var settingsPanel = new SettingsPanel();
                int result = JOptionPane.showConfirmDialog(null,
                        settingsPanel,
                        "Settings",
                        JOptionPane.OK_CANCEL_OPTION,
                        JOptionPane.PLAIN_MESSAGE);
            }
        });

        menuGameExit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                exitDialog();
            }
        });

        menuHelpHelp.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });

        menuHelpAbout.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });

        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent event) {
                exitDialog();
            }
        });
    }

    private void exitDialog() {
        int result = JOptionPane.showConfirmDialog(MainWindow.this,
                "Are you sure you want to quit?",
                "Exit",
                JOptionPane.YES_NO_OPTION,
                JOptionPane.QUESTION_MESSAGE);
        if (result == JOptionPane.YES_OPTION) {
            dispose();
        }
    }
}
