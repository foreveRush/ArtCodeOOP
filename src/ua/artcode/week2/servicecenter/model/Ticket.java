package ua.artcode.week2.servicecenter.model;

import java.util.ArrayList;

/**
 * Created by Serhii Fursenko on 09.07.2016.
 * fyrsenko@gmail.com
 */
public class Ticket {

    private static int index = 1;
    private int id;
    private Client client;
    private ArrayList<Tech> techList = new ArrayList<>();
    private int orderPrice;

    public Ticket(Client client, ArrayList<Tech> techList) {
        this.id = index++;
        this.client = client;
        this.techList = techList;
        for(Tech tech : techList) {
            orderPrice+= tech.getPrice()*0.1;
        }
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public ArrayList<Tech> getTechList() {
        return techList;
    }

    public void setTechList(ArrayList<Tech> techList) {
        this.techList = techList;
    }

    public int getOrderPrice() {
        return orderPrice;
    }

    public int getId() {
        return id;
    }

    @Override
    public String toString() {
        return "\nTicket id= " + id + "\n" +
                "client= " + client +"\n" +
                "techList= " + techList +"\n" +
                "orderPrice= " + orderPrice;
    }
}
