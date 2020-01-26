package geekbrains.lessons.lessonone.lessonTree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

public class PhoneBook {
    private HashMap<String, ArrayList<Person>> hashMap = new HashMap<>();


    public void put(String secondName, Person person){
        ArrayList<Person> persons = hashMap.get(secondName);
        if(persons == null) {
            ArrayList<Person> newPersons = new ArrayList<>();
            newPersons.add(person);
            hashMap.put(secondName,newPersons);
        } else {
            persons.add(person);
        }
    }

    public ArrayList<String> personPhone (String secondName){
        ArrayList<Person> persons = hashMap.get(secondName);
        ArrayList<String> phoneNumbers = new ArrayList<>();
        for (Person person : persons ) {
           phoneNumbers.add(person.getPhone());
        }
        return phoneNumbers;
    }

    public ArrayList<String> personEmail (String secondName){
        ArrayList<Person> persons = hashMap.get(secondName);
        ArrayList<String> emails = new ArrayList<>();
        for (Person person: persons) {
            emails.add(person.getEmail());
        }
        return emails;
    }

    @Override
    public String toString() {
        return hashMap.toString();
    }
}
