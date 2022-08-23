package model;

import com.fasterxml.jackson.annotation.JsonProperty;
import enums.Group;

import java.util.Objects;
import java.util.Set;

public class Contact {
    @JsonProperty("Группы")
    private Set<Group> groups;

    @JsonProperty("Имя")
    private String firstName;

    @JsonProperty("Фамилия")
    private String lastName;

    @JsonProperty("Номер")
    private String number;

    public void setGroups(Set<Group> groups) {
        this.groups = groups;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Contact contact = (Contact) o;
        return number.equals(contact.number);
    }

    @Override
    public int hashCode() {
        return Objects.hash(number);
    }

    @Override
    public String toString() {
        return "Контакт{" +
                "Группы:" + groups +
                ", Имя:'" + firstName + '\'' +
                ", Фамилия:'" + lastName + '\'' +
                ", Номер:" + number + '\'' +
                '}';
    }
}
