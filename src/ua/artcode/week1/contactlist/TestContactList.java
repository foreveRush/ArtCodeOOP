package ua.artcode.week1.contactlist;

import java.util.Random;

/**
 * Created by Serhii Fursenko on 26.06.2016.
 */
public class TestContactList {

    public static void main(String[] args) {

        //String json = "{\"list\":[{\"name\":\"Ivan\",\"phone\":\"0934443223\",\"age\":\"20\",\"address\":{\"city\":\"Kiyv\",\"street\":\"Lepsa\",\"number\":\"20\"}},{\"name\":\"Vlad\",\"phone\":\"0956720990\",\"age\":\"22\",\"address\":{\"city\":\"Odesa\",\"street\":\"Naberezhna\",\"number\":\"33\"}},{\"name\":\"Alex\",\"phone\":\"0504332209\",\"age\":\"18\",\"address\":{\"city\":\"Kiyv\",\"street\":\"Lesi\",\"number\":\"2\"}}]}";


        ContactList contactList = new ContactList();
        ContactMenu contactMenu = new ContactMenu();

        contactMenu.start(contactList);
    }


}
