package ua.artcode.week1.contactlist;

/**
 * Created by Serhii Fursenko on 26.06.2016.
 */
public class Contact {

    String name;
    String phone;
    int age;
    Address address;


    public Contact(String name, String phone, int age, Address address) {
        this.name = name;
        this.phone = phone;
        this.age = age;
        this.address = address;
    }

    public String asString() {

        return String.format("name : %s, phone : %s, age : %d, %s", name, phone, age, address.addressAsString());

    }

    public void printContact() {
        System.out.println(this.asString());
    }

    public String toJson() {
        return String.format("{\"name\" : \"%s\", \"phone\" : \"%s\", \"age\" : \"%d\", %s }", name, phone, age, address.toJson());
    }


    public static Contact createContactFromJson(String json) {

        json = json.trim();
        String [] temp = json.split("\\{");
        Address address = Address.createAddressFromJson(temp[1]);
        temp = temp[0].split(",");

        String[] temp2 = temp[0].split("\"");
        String name = temp2[3];

        temp2 = temp[1].split("\"");
        String phone = temp2[3];

        temp2 = temp[2].split("\"");
        int age = Integer.parseInt(temp2[3]);



        return new Contact(name, phone, age, address);
    }
}