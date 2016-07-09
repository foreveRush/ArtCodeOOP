package ua.artcode.week2.servicecenter;

import java.util.ArrayList;

/**
 * Created by Serhii Fursenko on 09.07.2016.
 * fyrsenko@gmail.com
 */
public class Client {

    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void giveTechToRepair(Tech[] tech, ServiceCenter serviceCenter) {

        serviceCenter.getAdministrator().getTechForRepair(this, tech);
    }

    public void getTechServiceById(Ticket ticket, ServiceCenter serviceCenter) {
        serviceCenter.getAdministrator().returnTech(ticket);
    }

    @Override
    public String toString() {
        return this.getName();
    }
}
