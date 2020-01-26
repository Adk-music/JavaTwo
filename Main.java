package geekbrains.lessons.lessonone.lessonTree;

import java.util.HashMap;
import java.util.HashSet;

public class Main {

    public static void main(String[] args) {
        String words = "Я хотел бы летать как птицы летать как свободное существо" +
                " только прикованы мои крылья давно давно и не летать мне все равно";

        String[] splitWords = words.split(" ");

        HashSet<String> hashSet = new HashSet<>();
        for (String word : splitWords ){
            hashSet.add(word);
        }
        System.out.println(hashSet.size());
        HashMap<String, Integer> hashMap = new HashMap<>();
        for (String word : splitWords){
            Integer value = hashMap.get(word);
            if(value == null){
                hashMap.put(word,1);
            } else {
                hashMap.put(word,++value);
            }
        }
        System.out.println(hashMap);

        PhoneBook phoneBook = new PhoneBook();
        phoneBook.put("Colins",new Person("+7001","001@mail.ru"));
        phoneBook.put("Fist",new Person("+7002","002@mail.ru"));
        phoneBook.put("Dest",new Person("+7003","003@mail.ru"));
        phoneBook.put("Colins",new Person("+7004","004@mail.ru"));

        System.out.println(phoneBook.personPhone("Colins"));
        System.out.println(phoneBook.personEmail("Colins"));
        
    }


}
