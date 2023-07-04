package org.example;

import org.example.services.ContactService;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

import java.util.List;

public class MyTgBot extends TelegramLongPollingBot {

    ContactService contactService;

    public MyTgBot(ContactService contactService) {
        this.contactService = contactService;
    }

    @Override
    public void onUpdateReceived(Update update) {
        if (update.hasMessage()) {
            String firstName = update.getMessage().getChat().getFirstName();
            String message = update.getMessage().getText();

            printLogs(firstName, message);
            SendMessage sendMessage = new SendMessage();
            sendMessage.setChatId(update.getMessage().getChatId());

            switch (message) {
                case "/start" -> {
                    sendMessage.setText("Salom " + firstName);
                    sendMessage.setText("1 - Add contact\n2-Get Contacts");
                }
                case "1" -> {
                    sendMessage.setText("Ismni kiriting:");
                    contactService.addContact("Abror", "+8839322331");
                    contactService.addContact("Akmal", "+5245345453");
                    contactService.addContact("Bobur", "+5245345423423453");
                }
                case "2" -> {
                    List<String> stringList = contactService.getContactList();
                    sendMessage.setText(stringList.toString());
                }
            }

            try {
                execute(sendMessage);
            } catch (TelegramApiException e) {
                throw new RuntimeException(e);
            }
        }
    }

    @Override
    public void onUpdatesReceived(List<Update> updates) {
        super.onUpdatesReceived(updates);
    }

    @Override
    public String getBotUsername() {
        return "day-26-bot";
    }

    @Override
    public void onRegister() {
        super.onRegister();
    }

    @Override
    public String getBotToken() {
        return "5464686855:AAEfEJQ7ypN20aIZd6EKDAoySsIywlD4ong";
    }

    public void printLogs(String name, String message) {
        System.out.println(name + "---> " + message);
    }
}
