package org.example.services;


import org.example.models.Contact;

import java.util.List;
import java.util.Scanner;

public class ContactServiceImpl implements ContactService {

    FileService fileService;

    public ContactServiceImpl(FileService fileService) {
        this.fileService = fileService;
    }

    @Override
    public void addContact(String name, String phone) {
//        Scanner scanner = new Scanner(System.in);
//
//        System.out.println("Name : ");
//        String name = scanner.nextLine();
//
//        System.out.println("Phone : ");
//        String phone = scanner.nextLine();

        Contact newContact = new Contact(name, phone);
        fileService.writeFile(newContact.toString());
    }

    @Override
    public List<String> getContactList() {
        return fileService.readFile();
    }

    @Override
    public void contactMenu() {
        System.out.println("1-add contact\n2-contact list\n");
        Scanner scanner = new Scanner(System.in);
        int choice = scanner.nextInt();
        switch (choice) {
            case 1 -> {
                scanner.nextLine();
                addContact("", "");
            }
            case 2 -> {
                scanner.nextLine();
                getContactList();
            }
        }
    }
}
