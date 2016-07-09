package ua.artcode.week2.servicecenter;

import ua.artcode.week1.contactlist.Address;

import java.util.ArrayList;

/**
 * Created by Serhii Fursenko on 09.07.2016.
 * fyrsenko@gmail.com
 */
public class ServiceCenter {

    private Address address;
    private Administrator administrator;
    private ArrayList<Repairer> workers = new ArrayList<>();
    private ArrayList<Client> clients = new ArrayList<>();
    private ArrayList<Ticket> actualOrders = new ArrayList<>();
    private ArrayList<Ticket> doneOrders = new ArrayList<>();

    public Address getAddress() {
        return address;
    }

    public Administrator getAdministrator() {
        return administrator;
    }

    public void setAdministrator(Administrator administrator) {
        this.administrator = administrator;
    }

    public ArrayList<Repairer> getWorkers() {
        return workers;
    }

    public void setWorkers(ArrayList<Repairer> workers) {
        this.workers = workers;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public ArrayList<Client> getClients() {
        return clients;
    }

    public void setClients(ArrayList<Client> clients) {
        this.clients = clients;
    }

    public ArrayList<Ticket> getActualOrders() {
        return actualOrders;
    }

    public void setActualOrders(ArrayList<Ticket> actualOrders) {
        this.actualOrders = actualOrders;
    }

    public ArrayList<Ticket> getDoneOrders() {
        return doneOrders;
    }

    public void setDoneOrders(ArrayList<Ticket> doneOrders) {
        this.doneOrders = doneOrders;
    }
}
