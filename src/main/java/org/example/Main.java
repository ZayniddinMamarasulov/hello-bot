package org.example;

import org.example.services.ContactService;
import org.example.services.ContactServiceImpl;
import org.example.services.FileService;
import org.example.services.FileServiceImpl;
import org.telegram.telegrambots.meta.TelegramBotsApi;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import org.telegram.telegrambots.updatesreceivers.DefaultBotSession;

import java.io.File;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world");

        FileService fileService = new FileServiceImpl(new File("contact.txt"));
        ContactService contactService = new ContactServiceImpl(fileService);

        try {
            TelegramBotsApi botsApi = new TelegramBotsApi(DefaultBotSession.class);
            botsApi.registerBot(new MyTgBot(contactService));
        } catch (TelegramApiException e) {
            throw new RuntimeException(e);
        }
    }
}