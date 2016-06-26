package ua.artcode.week1.contactlist;

/**
 * Created by Serhii Fursenko on 26.06.2016.
 */
public class TestContactList {

    public static void main(String[] args) {
        ContactList contactList = new ContactList();

        Contact contact1 = new Contact("Ivan", "0934443223", 20, "Kiyv", "Lepsa", 20);
        Contact contact2 = new Contact("Vlad", "0956720990", 22, "Odesa", "Naberezhna", 33);
        Contact contact3 = new Contact("Alex", "0504332209", 18, "Kiyv", "Lesi", 2);

        contactList.addContact(contact1);
        contactList.addContact(contact2);
        contactList.addContact(contact3);

        System.out.println(contact1.toJson());
        System.out.println(contact2.toJson());
        System.out.println(contact3.toJson());

        System.out.println();
        contactList.print();

    }
}
