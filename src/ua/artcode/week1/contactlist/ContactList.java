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

    public String toJson() {
        String json = "{ \"list\" : [";
        for (Contact contact : list) {
            json += contact.toJson();
            if (list.indexOf(contact)!=list.size()-1) {
                json += ",";
            }
        }
        json += "] }";
        return json;
    }


    public static ContactList createContactListFromJson(String json) {

        json = json.trim();
        ContactList contactList = new ContactList();
        String [] temp = json.split("\\[");
        temp = temp[1].split("\\{");

        for(int i = 1; i<temp.length; i=i+2) {

            String contact = temp[i] + "{" + temp[i+1];
            contactList.list.add(Contact.createContactFromJson(contact));
        }

        return contactList;
    }

}