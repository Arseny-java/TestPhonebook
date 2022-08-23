import model.Phonebook;

import java.io.IOException;
import java.util.Scanner;

public class PhonebookRunner {
    private static final String MENU = "Добро пожаловать в телефонный справочник!\n" +
            "Выберите пункт (необходимо ввести цифру):\n" +
            "1.Добавление контакта\n" +
            "2.Получить список контактов\n" +
            "3.Удалить контакт по номеру\n" +
            "4.Поиск контакта по фамилии\n" +
            "0.Выход из программы";

    public static void main(String[] args) throws IOException {
        Phonebook phonebook = new Phonebook();
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println(MENU);
            String menuItem = scanner.nextLine();
            switch (menuItem) {
                case "1":
                    phonebook.addContact();
                    break;
                case "2":
                    phonebook.printPhonebook();
                    break;
                case "3":
                    phonebook.deleteContactByNumber();
                    break;
                case "4":
                    phonebook.findContactByLastName();
                    break;
                case "0":
                    phonebook.exit();
                    return;
            }
        }
    }
}
