package ru.task1_tictactoe;

import ru.task1_tictactoe.controller.AppController;

public class TicTacToeApp {
    public static void main(String[] args) {
        new AppController().start();
    }

//    private JLabel label = new JLabel("Enter your e-mail: ");
//    private JTextField textField = new JTextField(20);
//    private JButton button = new JButton("OK");
//
//    public TicTacToeApp() {
//        super("Demo program for JFrame");
//
//        // sets layout manager
//        setLayout(new GridBagLayout());
//
//        GridBagConstraints constraint = new GridBagConstraints();
//        constraint.insets = new Insets(10, 10, 10, 10);
//        constraint.gridx = 0;
//        constraint.gridy = 0;
//
//        add(label, constraint);
//
//        constraint.gridx = 1;
//        add(textField, constraint);
//
//        constraint.gridx = 0;
//        constraint.gridwidth = 2;
//        constraint.gridy = 1;
//
//        add(button, constraint);
//
//        // adds menu bar
//        JMenuBar menuBar = new JMenuBar();
//        JMenu menuFile = new JMenu("File");
//        JMenuItem menuItemExit = new JMenuItem("Exit");
//        menuFile.add(menuItemExit);
//
//        menuBar.add(menuFile);
//
//        // adds menu bar to the frame
//        setJMenuBar(menuBar);
//
//        // adds window event listener
//        addWindowListener(new WindowAdapter() {
//            public void windowClosing(WindowEvent event) {
//                exitDialog();
//            }
//        });
//
//        setIconImage(new ImageIcon(AppConfig.getProperty("game.icon")).getImage());
//
//        pack();
//
//        // centers on screen
//        setLocationRelativeTo(null);
//
//        setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
//
//        setVisible(true);
//    }
//
//    public static void main(String[] args) {
//        SwingUtilities.invokeLater(new Runnable() {
//            @Override
//            public void run() {
//                new TicTacToeApp();
//            }
//        });
//    }

//    private void exitDialog() {
//        int reply = JOptionPane.showConfirmDialog(TicTacToeApp.this,
//                "Are you sure you want to quit?",
//                "Exit",
//                JOptionPane.YES_NO_OPTION,
//                JOptionPane.QUESTION_MESSAGE);
//        if (reply == JOptionPane.YES_OPTION) {
//            dispose();
//        } else {
//            return;
//        }
//    }
}