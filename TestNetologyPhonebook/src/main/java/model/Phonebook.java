package model;

import enums.Group;
import utils.UserInputReader;

import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;

import static utils.CustomActions.*;
import static utils.JsonParser.jsonToMap;
import static utils.JsonParser.writeToJSON;

public class Phonebook {
    private static Map<String, Contact> phonebook;
    private static UserInputReader userInputReader;

    public Phonebook() throws IOException {
        createNewFile();
        phonebook = jsonToMap();
        userInputReader = new UserInputReader();
    }

    public void addContact() {
        Set<Group> groupSet = getGroupsFromInput();
        Contact newContact = getContactFromInput(groupSet);
        phonebook.put(newContact.getNumber(), newContact);
        System.out.println("Контакт успешно добавлен!\n");
    }

    public void printPhonebook() {
        if (!phonebook.isEmpty()) {
            phonebook
                    .values()
                    .forEach(System.out::println);
            System.out.println();
        } else {
            System.out.println("Телефонная книга пуста!");
            System.out.println();
        }
    }

    public void deleteContactByNumber() {
        if (!phonebook.isEmpty()) {
            String number = userInputReader.askForInput("Введите Номер для удаления:");
            deleteContact(number);
        } else {
            System.out.println("Телефонная книга пуста!");
            System.out.println();
        }

    }

    public void findContactByLastName() {
        if (!phonebook.isEmpty()) {
            String lastName = userInputReader.askForInput("Введите Фамилию для поиска:");
            getContactByLastName(lastName);
        } else {
            System.out.println("Телефонная книга пуста!");
            System.out.println();
        }
    }

    public void exit() throws IOException {
        writeToJSON(phonebook);
    }

    private void deleteContact(String number) {
        if (phonebook.get(number) == null) {
            System.out.println("Контакт не найден!\n");
        } else {
            phonebook.remove(number);
            System.out.println("Контакт успешно удален!\n");
        }
    }

    private void getContactByLastName(String lastName) {
        List<Contact> contactList = phonebook
                .values()
                .stream()
                .filter(contact -> contact.getLastName().equalsIgnoreCase(lastName))
                .collect(Collectors.toList());
        if (contactList.isEmpty()) {
            System.out.println("Указанная фамилия не найдена\n");
        } else {
            System.out.println("Ваш список контактов с фамилией: " + lastName);
            contactList.forEach(System.out::println);
            System.out.println();
        }
    }

}


