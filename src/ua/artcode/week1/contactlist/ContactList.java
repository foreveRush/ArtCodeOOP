package ua.artcode.week1.contactlist;

import java.util.ArrayList;

/**
 * Created by Serhii Fursenko on 26.06.2016.
 */
public class ContactList {

    ArrayList<Contact> list;

    ContactList() {
        list = new ArrayList<>();
    }

    public void addContact(Contact contact) {
        list.add(contact);
    }

    public void removeContact(Contact contact) {
        list.remove(contact);
    }

    public void print() {

        int i = 1;
        for (Contact cont : list) {
            System.out.print(i++ + ". ");
            cont.printContact();
            System.out.println("=============================");

        }
    }

}