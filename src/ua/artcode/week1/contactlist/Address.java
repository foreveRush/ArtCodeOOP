package ua.artcode.week1.contactlist;

/**
 * Created by Serhii Fursenko on 26.06.2016.
 */
public class Address {

    String city;
    String street;
    int number;

    public Address(String city, String street, int number) {
        this.city = city;
        this.street = street;
        this.number = number;
    }

    public String addressAsString() {

        return String.format("city : %s, street : %s, number : %d", city, street, number);

    }

    public void printAddress() {
        System.out.println(this.addressAsString());
    }

    public String toJson() {
        return String.format("\"address\" : { \"city\" : \"%s\", \"street\" : \"%s\", \"number\" : \"%d\" }", city, street, number);
    }

    public static Address createAddressFromJson(String json) {

        String[] temp = json.split(",");

        String[] temp2 = temp[0].split("\"");
        String city = temp2[3];

        temp2 = temp[1].split("\"");
        String street = temp2[3];

        temp2 = temp[2].split("\"");
        int number = Integer.parseInt(temp2[3]);

        return new Address(city, street, number);
    }


}