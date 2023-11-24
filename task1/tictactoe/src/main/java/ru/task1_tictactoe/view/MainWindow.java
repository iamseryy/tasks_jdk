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
    private final JButton buttonStart = new JButton("New Game");
    private final JButton buttonExit = new JButton("Exit");

    public MainWindow(){
        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
        setLocation(WINDOW_POSX, WINDOW_POSY);
        setTitle(GAME_NAME);
        //setResizable(false);

        setIconImage(new ImageIcon(AppConfig.getProperty("game.icon")).getImage());

        var menuBar = new JMenuBar();
        var menuGame = new JMenu("Game");
        var menuHelp = new JMenu("Help");
        menuBar.add(menuGame);
        menuBar.add(menuHelp);
        var menuGameNew = new JMenuItem("New Game");
        var menuGameSettings = new JMenuItem("Settings");
        var menuGameExit = new JMenuItem("Exit");
        menuGame.add(menuGameNew);
        menuGame.add(menuGameSettings);
        menuGame.add(menuGameExit);


        menuGameExit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                exitDialog();
            }
        });

        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent event) {
                exitDialog();
            }
        });



        var panBottomGridLayout = new GridLayout(1, 2);
        panBottomGridLayout.setHgap(20);
        var panBottom = new JPanel(panBottomGridLayout);
        panBottom.add(buttonStart);
        panBottom.add(buttonExit);
        add(menuBar, BorderLayout.NORTH);
        add(panBottom, BorderLayout.SOUTH);
        setVisible(true);
    }

    private void exitDialog() {
        int reply = JOptionPane.showConfirmDialog(MainWindow.this,
                "Are you sure you want to quit?",
                "Exit",
                JOptionPane.YES_NO_OPTION,
                JOptionPane.QUESTION_MESSAGE);
        if (reply == JOptionPane.YES_OPTION) {
            dispose();
        }
    }
}
