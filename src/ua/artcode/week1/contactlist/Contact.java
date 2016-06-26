package ua.artcode.week1.contactlist;

/**
 * Created by Serhii Fursenko on 26.06.2016.
 */
public class Contact {

    String name;
    String phone;
    int age;
    Address address;


    public Contact(String name, String phone, int age, String city, String street, int number) {
        this.name = name;
        this.phone = phone;
        this.age = age;
        address = new Address(city, street, number);
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
}