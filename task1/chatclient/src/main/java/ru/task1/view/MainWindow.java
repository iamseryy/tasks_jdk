package ru.task1.view;

import ru.task1.config.AppConfig;
import ru.task1.service.ChatService;
import ru.task1.service.impl.ChatServiceImpl;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import java.util.List;

public class MainWindow extends JFrame {
    private static final int WIDTH = 400;
    private static final int HEIGHT = 300;
    private static final String TITLE = "Chat client";
    private static final String NO_CONNECTION = "No Connection";
    private final JPanel topPanel = new JPanel(new GridLayout(2, 3));
    private final JTextField addrIpTextField = new JTextField("127.0.0.1");
    private final JTextField portTextField = new JTextField("8089");
    private final JTextField loginTextField = new JTextField("test_user");
    private final JPasswordField jPasswordField = new JPasswordField("12345678");
    private final JButton loginButton = new JButton("Login");
    private final JPanel bottomPanel = new JPanel(new BorderLayout());
    private final JTextField messageTextField = new JTextField();
    private final JButton buttonSend = new JButton("Send");
    private final JTextArea log = new JTextArea();
    private final JList userList = new JList();

    private final ChatService chatService = new ChatServiceImpl();




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

        topPanel.add(addrIpTextField);
        topPanel.add(portTextField);
        topPanel.add(loginTextField);
        topPanel.add(jPasswordField);
        topPanel.add(loginButton);
        bottomPanel.add(messageTextField, BorderLayout.CENTER);
        bottomPanel.add(buttonSend, BorderLayout.EAST);

        add(bottomPanel, BorderLayout.SOUTH);
        add(topPanel, BorderLayout.NORTH);

        log.append(NO_CONNECTION);
        log.setEditable(false);
        var scrollLog = new JScrollPane(log);
        add(scrollLog);

        userList.setListData(new String[]{NO_CONNECTION});
        var scrollUserList = new JScrollPane(userList);
        add(scrollUserList, BorderLayout.EAST);
    }

    private void addListeners() {
        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                loginButton.setEnabled(false);
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException ex) {
                    throw new RuntimeException(ex);
                }

                userList.remove(0);
                userList.setListData(chatService.findAllUsers());
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
