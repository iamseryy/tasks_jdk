package ru.task1.view;

import ru.task1.config.AppConfig;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.logging.Level;

public class MainWindow extends JFrame {
    private static final int WIDTH = 400;
    private static final int HEIGHT = 300;
    private static final String TITLE = "Chat server";
    private static final String CONNECTED = "Server connected";
    private static final String DISCONNECTED = "Server disconnected";
    private final JButton startButton = new JButton("Start");
    private final JButton stopButton = new JButton("Stop");
    private final JTextArea log = new JTextArea();
    private final JPanel topPanel = new JPanel(new GridLayout(1, 2));

    public MainWindow() {
        init();
        addListeners();
        setVisible(true);
    }

    private void init() {
        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        setLocationRelativeTo(null);
        setSize(WIDTH, HEIGHT);
        setTitle(TITLE);
        setIconImage(new ImageIcon(AppConfig.getProperty("icon")).getImage());

        setResizable(false);

        stopButton.setEnabled(false);
        topPanel.add(startButton);
        topPanel.add(stopButton);

        add(topPanel, BorderLayout.NORTH);

        log.setEditable(false);
        var scrollLog = new JScrollPane(log);
        add(scrollLog);
    }

    private void addListeners() {
        startButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                startButton.setEnabled(false);
                stopButton.setEnabled(true);

                try {
                    Thread.sleep(2000);
                } catch (InterruptedException ex) {
                    throw new RuntimeException(ex);
                }
                var logLine = getCurrentTime() + ": " + CONNECTED + "\n";
                AppConfig.LOGGER.log(Level.INFO, logLine);
                log.append(logLine);
            }
        });

        stopButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                startButton.setEnabled(true);
                stopButton.setEnabled(false);

                try {
                    Thread.sleep(1000);
                } catch (InterruptedException ex) {
                    throw new RuntimeException(ex);
                }
                var logLine = getCurrentTime() + ": " + DISCONNECTED + "\n";
                AppConfig.LOGGER.log(Level.INFO, logLine);
                log.append(logLine);
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

    private String getCurrentTime() {
        var dateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        return dateFormat.format(Calendar.getInstance().getTime());
    }
}
