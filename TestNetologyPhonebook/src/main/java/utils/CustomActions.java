package utils;

import enums.Group;
import model.Contact;

import java.io.File;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

public class CustomActions {
    private static final PathsToJSON PATHS = new PathsToJSON();
    private static final String DIRECTORY = PATHS.getDIRECTORY();
    private static final String PATH_TO_PHONEBOOK = PATHS.getFILE();
    static UserInputReader userInputReader = new UserInputReader();

    @SuppressWarnings("ResultOfMethodCallIgnored")
    public static void createNewFile() {
        File directory = new File(DIRECTORY);
        File file = new File(PATH_TO_PHONEBOOK);
        try {
            directory.mkdir();
            file.createNewFile();
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    public static Set<Group> getGroupsFromInput() {
        Set<Group> resultGroupSet = new HashSet<>();
        while (true) {
            boolean correctInput = true;
            String groups = userInputReader.askForInput("Выберите группы через пробел, куда хотите добавить контакт: РАБОТА, СЕМЬЯ, ДРУЗЬЯ");
            String[] groupArray = groups.split(" ", 3);

            for (String g : groupArray) {
                try {
                    resultGroupSet.add(Group.valueOf(g));
                } catch (IllegalArgumentException e) {
                    System.out.println("!Группа " + g + " не является допустимым значением. Повторите ввод!");
                    correctInput = false;
                }
            }
            if (correctInput) break;
        }
        return resultGroupSet;
    }

    public static Contact getContactFromInput(Set<Group> groupSet) {
        Contact newContact = new Contact();
        while (true) {
            boolean correctInput = true;
            try {
                String contactInfo = userInputReader.askForInput("Введите Имя, Фамилию и Номер через пробел:");
                newContact = userInputReader.getNewContact(contactInfo, groupSet);
            } catch (ArrayIndexOutOfBoundsException e) {
                System.out.println("!Количество введенных данных меньше 3!");
                correctInput = false;
            }
            if (correctInput) break;
        }
        return newContact;
    }

}