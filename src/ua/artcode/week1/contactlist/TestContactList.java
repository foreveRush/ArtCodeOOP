package ua.artcode.week1.contactlist;

/**
 * Created by Serhii Fursenko on 26.06.2016.
 */
public class TestContactList {

    public static void main(String[] args) {
        ContactList contactList = new ContactList();

        //Contact contact1 = new Contact("Ivan", "0934443223", 20, "Kiyv", "Lepsa", 20);
        //Contact contact2 = new Contact("Vlad", "0956720990", 22, "Odesa", "Naberezhna", 33);
        //Contact contact3 = new Contact("Alex", "0504332209", 18, "Kiyv", "Lesi", 2);

        //contactList.addContact(contact1);
        //contactList.addContact(contact2);
        //contactList.addContact(contact3);


        String json = "{" +
                "  \"list\": [" +
                "    {" +
                "      \"name\": \"Ivan\"," +
                "      \"phone\": \"0934443223\"," +
                "      \"age\": \"20\"," +
                "      \"address\": {" +
                "        \"city\": \"Kiyv\"," +
                "        \"street\": \"Lepsa\"," +
                "        \"number\": \"20\"" +
                "      }" +
                "    }," +
                "    {" +
                "      \"name\": \"Vlad\"," +
                "      \"phone\": \"0956720990\"," +
                "      \"age\": \"22\"," +
                "      \"address\": {" +
                "        \"city\": \"Odesa\"," +
                "        \"street\": \"Naberezhna\"," +
                "        \"number\": \"33\"" +
                "      }" +
                "    }," +
                "    {" +
                "      \"name\": \"Alex\"," +
                "      \"phone\": \"0504332209\"," +
                "      \"age\": \"18\"," +
                "      \"address\": {" +
                "        \"city\": \"Kiyv\"," +
                "        \"street\": \"Lesi\"," +
                "        \"number\": \"2\"" +
                "      }" +
                "    }" +
                "  ]" +
                "}";

        //String [] temp = json.split("\\[");
        //temp = temp[1].split("\\{");

        //temp = temp[1].split(",");

        //String[] temp2 = temp[0].split("\"");
        //for (String s : temp) {
          //  System.out.println(s);
        //}


        //Contact contact = Contact.createContactFromJson(json);
        //contact.printContact();

        ContactList contactList1 = ContactList.createContactListFromJson(json);
        contactList1.print();
    }
}
