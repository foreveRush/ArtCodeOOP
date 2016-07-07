package ua.artcode.week1.garage;

import ua.artcode.week1.contactlist.Address;

/**
 * Created by home on 07.07.2016.
 */
public class Parking {
    Moto[] garage;
    Address address;
    boolean isOpen;

    Parking(int size, String city, String string, int number) {
        garage = new Moto[size];
        address = new Address(city, string, number);
    }

    public void open(){
        if(isOpen){
            System.out.println("Allready opened");
        } else {
            isOpen = true;
            System.out.println("Done! Now garage is opened");
        }
    }
    public void close(){
        if(!isOpen){
            System.out.println("Allready closed");
        } else {
            isOpen = false;
            System.out.println("Done! Now garage is closed");
        }
    }

    public void changeAddress(Address address){
        this.address = address;
    }

    public void addMotoOnLastFreePlace(Moto moto){
        for(int i=garage.length-1; i>=0; i--){
            if(garage[i]==null) {
                garage[i] = moto;
            }
        }
        System.out.println("Done!");
    }

    public Moto takeLastMoto() {
        for(int i=garage.length-1; i>=0; i--){
            if(garage[i]==null) {
                return garage[i];
            }
        }
        return null;
    }

    public void addMotoByPlaceNumber(Moto moto, int placeNumber) {
        if(garage[placeNumber]!=null) {
            System.out.println("This place is busy");
        } else {
            garage[placeNumber] = moto;
            System.out.println("Done!");
        }
    }

    public Moto takeMotoByPlaceNumber(int placeNumber) {
        if(garage[placeNumber]==null) {
            System.out.println("Place is empty");
            return null;
        } else {
            return garage[placeNumber];
        }
    }

    public void clearGaragePlaces() {
        for(Moto moto : garage) {
            moto = null;
        }
    }

    public void showAllInGarage() {
        int i=1;
        for(Moto moto : garage) {
            System.out.print(i+". ");
            if(moto==null) {
                System.out.println("free");
            } else {
                System.out.println(String.format("Brand: %s, number: %s", moto.brand, moto.number));
            }
        }
    }


}
