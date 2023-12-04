package ru.task1.model;

import ru.task1.config.AppConfig;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.logging.Level;

public class ChatServer implements ServerListener{
    private static final String CONNECTED = "Server connected";
    private static final String ALREADY_CONNECTED = "Server already connected";
    private static final String DISCONNECTED = "Server disconnected";
    private static final String ALREADY_DISCONNECTED = "Server already disconnected";
    private boolean isServerWorking;
    private Listener listener;

    public ChatServer(Listener listener) {
        this.isServerWorking = false;
        this.listener = listener;
    }

    public void onStart() {
        if (!isServerWorking) {
           isServerWorking = true;
            try {
                    Thread.sleep(2000);
                } catch (InterruptedException ex) {
                    throw new RuntimeException(ex);
                }
            AppConfig.LOGGER.log(Level.INFO, CONNECTED);
            listener.messageRes(getCurrentTime() + ": " + CONNECTED + "\n");
        } else {
            AppConfig.LOGGER.log(Level.INFO, ALREADY_CONNECTED);
            listener.messageRes(ALREADY_CONNECTED + "\n");
        }
    }

    public void onStop() {
        if (isServerWorking) {
            isServerWorking = false;
            try {
                Thread.sleep(1000);
            } catch (InterruptedException ex) {
                throw new RuntimeException(ex);
            }
            AppConfig.LOGGER.log(Level.INFO, DISCONNECTED);
            listener.messageRes(getCurrentTime() + ": " + DISCONNECTED + "\n");
        } else {
            AppConfig.LOGGER.log(Level.INFO, ALREADY_DISCONNECTED);
            listener.messageRes(ALREADY_DISCONNECTED + "\n");
        }
    }

    @Override
    public void serverListener(boolean status) {
        if (status) {
            onStart();
        } else {
            onStop();
        }
    }

    private String getCurrentTime() {
        var dateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        return dateFormat.format(Calendar.getInstance().getTime());
    }
}
