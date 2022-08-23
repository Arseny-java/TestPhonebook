package utils;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import model.Contact;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class JsonParser {

    private static final String PATH_TO_PHONEBOOK = new PathsToJSON().getFILE();

    public static Map<String, Contact> jsonToMap() throws IOException {
        Map<String, Contact> contactMap = new HashMap<>();
        String jsonString = readString();
        if (jsonString != null) {
            contactMap = new ObjectMapper().
                    readValue(jsonString, new TypeReference<HashMap<String, Contact>>() {
                    });
        }
        return contactMap;
    }

    private static String readString() throws IOException {
        File f = new File(PATH_TO_PHONEBOOK);
        BufferedReader buf = new BufferedReader(new FileReader(f));
        return buf.readLine();
    }

    public static void writeToJSON(Map<String, Contact> contacts) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        mapper.writeValue(new File(PATH_TO_PHONEBOOK), contacts);
    }
}
