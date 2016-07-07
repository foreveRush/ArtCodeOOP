package ua.artcode.week1.contactlist;

import java.util.Scanner;

/**
 * Created by home on 07.07.2016.
 */
public class ContactMenu {

    Scanner scanner = new Scanner(System.in);
    int item;
    private ContactList contactList;

    public void start(ContactList contactList) {

        this.contactList = contactList;
        loop:
        while (true) {
            this.showMenu();
            try {
                item = scanner.nextInt();
            } catch (Exception e) {
                System.out.println("Error! Try again...");
                continue;
            }
            scanner.nextLine();
            switch (item) {
                case 0:
                    break loop;
                case 1:
                    this.addContact();
                    break;
                case 2:
                    this.removeContact();
                    break;
                case 3:
                    this.removeLastContact();
                    break;
                case 4:
                    this.showFirstFiveContacts();
                    break ;
                case 5:
                    this.showLastFiveContacts();
                    break;
                case 6:
                    this.showAll();
                    break;
                case 7:
                    this.findContact();
                    break;
                case 8:
                    this.updateContact();
                    break;
                case 9:
                    this.showLifeContacts();
                    break;
                case 10:
                    this.showKievstarContacts();
                    break;
            }
        }

    }

    private void showMenu() {

        System.out.println("1. Add Contact");
        System.out.println("2. Remove Contact");
        System.out.println("3. Remove last Contact");
        System.out.println("4. Show first five Contacts");
        System.out.println("5. Show last five Contacts");
        System.out.println("6. Show All");
        System.out.println("7. Find Contact");
        System.out.println("8. Update Contact info");
        System.out.println("9. Show Life Contacts");
        System.out.println("10. Show Kievstar Contacts");
        System.out.println("0. Exit");

    }

    private void addContact() {

        String name = "";
        name:
        while (true) {
            System.out.println("Input name:");
            name = scanner.nextLine();
            for (Contact contact : this.contactList.list) {
                if (contact.name.equalsIgnoreCase(name)) {
                    System.out.println("This name allready exist");
                    continue name;
                }
            }
            break name;
        }

        System.out.println("Input phone: \nexample:380931234567");
        String phone = scanner.nextLine();

        System.out.println("Input age:");
        int age = scanner.nextInt();
        scanner.nextLine();

        System.out.println("Input city:");
        String city = scanner.nextLine();

        System.out.println("Input street:");
        String street = scanner.nextLine();

        System.out.println("Input number:");
        int number = scanner.nextInt();

        Contact contact = new Contact(name, phone, age, new Address(city, street, number));

        this.contactList.addContact(contact);

        System.out.println("Contact added!\n");
    }

    private void removeContact() {
        System.out.println("Input number");
        int number = scanner.nextInt();
        this.contactList.removeContact(contactList.list.get(number-1));
        System.out.println("Contact removed!\n");
    }

    private void removeLastContact() {
        this.contactList.removeLastContact();
        System.out.println("Contact removed!\n");
    }

    private void showAll() {
        this.contactList.print();
    }

    private void updateContact(){
        System.out.println("Input number");
        int number = scanner.nextInt();

        menu:
        while (true) {
            System.out.println("1. Change name");
            System.out.println("2. Change phone");
            System.out.println("3. Change age");
            System.out.println("4. Change address");
            System.out.println("0. Back to main menu");

            item = scanner.nextInt();
            scanner.nextLine();
            switch (item) {
                case 0:
                    break menu;

                case 1:
                    String name = "";
                    name:
                    while (true) {
                        System.out.println("Input new name:");
                        name = scanner.nextLine();
                        for (Contact contact : this.contactList.list) {
                            if (contact.name.equalsIgnoreCase(name)) {
                                System.out.println("This name allready exist");
                                continue name;
                            }
                        }
                        break name;
                    }
                    contactList.list.get(item-1).name = name;
                    System.out.println("Name changed");
                    break;

                case 2:
                    System.out.println("Input new phone");
                    contactList.list.get(item-1).phone = scanner.nextLine();
                    System.out.println("Phone changed");
                    break;

                case 3:
                    System.out.println("Input new age");
                    contactList.list.get(item-1).age = scanner.nextInt();
                    scanner.nextLine();
                    System.out.println("Age changed");
                    break;

                case 4:
                    System.out.println("Input new city");
                    String city = scanner.nextLine();

                    System.out.println("Input new street");
                    String street = scanner.nextLine();

                    System.out.println("Input new number");
                    int house = scanner.nextInt();
                    scanner.nextLine();

                    contactList.list.get(item-1).address = new Address(city,street,house);
                    System.out.println("Address changed");
                    break;

            }
        }
    }


    private void showFirstFiveContacts() {
        if(contactList.list.size()<6) {
            contactList.print();
        } else {
            contactList.list.get(0).printContact();
            contactList.list.get(1).printContact();
            contactList.list.get(2).printContact();
            contactList.list.get(3).printContact();
            contactList.list.get(4).printContact();
        }
    }

    private void showLastFiveContacts() {
        if(contactList.list.size()>5) {
            contactList.list.get(contactList.list.size()-5).printContact();
            contactList.list.get(contactList.list.size()-4).printContact();
            contactList.list.get(contactList.list.size()-3).printContact();
            contactList.list.get(contactList.list.size()-2).printContact();
            contactList.list.get(contactList.list.size()-1).printContact();

        } else {
            contactList.print();
        }
    }

    private void findContact() {
        System.out.println("Input name");
        String name = scanner.nextLine();
        for (Contact contact : this.contactList.list) {
            if (contact.name.equalsIgnoreCase(name)) {
                contact.printContact();
                return;
            }
        }
        System.out.println("Contact not found");
    }

    private void showLifeContacts() {

        for (Contact contact : this.contactList.list) {
            String phone = contact.phone.substring(2,5);
            System.out.println(phone);
            if (phone.equals("063") || phone.equals("093") || phone.equals("073")) {
                contact.printContact();
            }
        }
    }

    private void showKievstarContacts() {

        for (Contact contact : this.contactList.list) {
            String phone = contact.phone.substring(2,5);
            if (phone.equals("067") || phone.equals("097")) {
                contact.printContact();
            }
        }
    }
}
