package org.example.services;

import java.util.List;

public interface ContactService {
    void addContact(String name, String phone);

    List<String> getContactList();

    void contactMenu();
}
