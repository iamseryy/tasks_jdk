package ru.task1.service;

import java.util.ArrayList;

public interface ChatService {
    String[] findAllUsers();
    String getMessageLog();
    void sendMessage(String message);

}
