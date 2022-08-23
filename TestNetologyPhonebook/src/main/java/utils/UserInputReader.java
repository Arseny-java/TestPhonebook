package utils;

import enums.Group;
import model.Contact;

import java.util.Scanner;
import java.util.Set;

public class UserInputReader {
    Scanner scanner = new Scanner(System.in);

    public String askForInput(String message) {
        System.out.println(message);
        return scanner.nextLine();
    }

    public Contact getNewContact(String contactInfo, Set<Group> groupSet) {
        Contact newContact = new Contact();
        String[] contactArray = contactInfo.split(" ", 3);
        newContact.setGroups(groupSet);
        newContact.setFirstName(contactArray[0]);
        newContact.setLastName(contactArray[1]);
        newContact.setNumber(contactArray[2]);
        return newContact;
    }
}
