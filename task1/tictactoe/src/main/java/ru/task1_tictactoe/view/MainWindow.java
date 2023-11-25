package ru.task1_tictactoe.view;


import ru.task1_tictactoe.config.AppConfig;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.logging.Level;

public class MainWindow extends JFrame {
    private static int mapSize = 3;
    private static int winLength = 3;
    private static int gameMode = 0;
    private static final String GAME_NAME = AppConfig.getProperty("game.name");
    private static final int WINDOW_HEIGHT = Integer.parseInt(AppConfig.getProperty("main.window.height"));
    private static final int WINDOW_WIDTH = Integer.parseInt(AppConfig.getProperty("main.window.width"));
    private static final int WINDOW_POSX = Integer.parseInt(AppConfig.getProperty("main.window.pos.x"));
    private static final int WINDOW_POSY = Integer.parseInt(AppConfig.getProperty("main.window.pos.y"));
    private static final String SETTINGS_PANEL_TITLE = "Settings";
    private static final String START_GAME_PANEL_TITLE = "Start new game";
    private static final JMenuBar menuBar = new JMenuBar();
    private static final JMenu menuGame = new JMenu("Game");
    private static final JMenu  menuHelp = new JMenu("Help");
    private static final JMenuItem menuGameNew = new JMenuItem("New Game");
    private static final JMenuItem menuGameSettings = new JMenuItem("Settings");
    private static final JMenuItem menuGameExit = new JMenuItem("Exit");
    private static final JMenuItem menuHelpHelp = new JMenuItem("Help");
    private static final JMenuItem menuHelpAbout = new JMenuItem("About");
    private MapPanel mapPanel;



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

        setResizable(false);

        mapPanel = new MapPanel();

        menuBar.add(menuGame);
        menuBar.add(menuHelp);
        menuGame.add(menuGameNew);
        menuGame.add(menuGameSettings);
        menuGame.add(menuGameExit);
        menuHelp.add(menuHelpHelp);
        menuHelp.add(menuHelpAbout);

        add(menuBar, BorderLayout.NORTH);
        add(mapPanel);
    }

    private void addListeners(){
        menuGameNew.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                var gameModePanel = new GameModePanel();
                int result = JOptionPane.showConfirmDialog(null,
                        gameModePanel,
                        START_GAME_PANEL_TITLE,
                        JOptionPane.OK_CANCEL_OPTION,
                        JOptionPane.PLAIN_MESSAGE);

                if (result == JOptionPane.YES_OPTION) {
                    gameMode = gameModePanel.getGameMode();
                    AppConfig.LOGGER.log(Level.INFO, "Mode=" + gameModePanel.getGameModeDesc() + "; Size=" +
                            mapSize + "; Win Length=" + winLength);
                    mapPanel.start(gameMode, mapSize, mapSize, winLength);
                }
            }
        });

        menuGameSettings.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                var settingsPanel = new SettingsPanel(mapSize, winLength);
                int result = JOptionPane.showConfirmDialog(null,
                        settingsPanel,
                        SETTINGS_PANEL_TITLE,
                        JOptionPane.OK_CANCEL_OPTION,
                        JOptionPane.PLAIN_MESSAGE);

                if (result == JOptionPane.YES_OPTION) {
                    mapSize = settingsPanel.getFieldSize();
                    winLength = settingsPanel.getWinLength();
                }
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
