package ru.task1.service.impl;

import ru.task1.service.ChatService;

import java.util.ArrayList;

public class ChatServiceImpl implements ChatService {
    @Override
    public String[] findAllUsers() {
        return new String[]{"user10", "Alex3232", "Olga2005", "Serg2222", "dim123123", "user88", "user1099",
                "user101", "ivan111", "olegggg", "userrrr", "opopop"};
    }

    @Override
    public String getMessageLog() {
        return null;
    }
}
