package ua.artcode.week2.servicecenter.model;

import ua.artcode.week1.contactlist.Address;

import java.util.ArrayList;

/**
 * Created by Serhii Fursenko on 09.07.2016.
 * fyrsenko@gmail.com
 */
public class ServiceCenter {

    private Administrator administrator;
    private ArrayList<Worker> workers = new ArrayList<>();
    private Address address;

    public ServiceCenter(Address address, Administrator administrator, RepairWorker repairWorker) {
        this.address = address;
        this.administrator = administrator;
        this.workers.add(repairWorker);


    }

    public Administrator getAdministrator() {
        return administrator;
    }

    public void setAdministrator(Administrator administrator) {
        this.administrator = administrator;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public ArrayList<Worker> getRepairWorkers() {
        return workers;
    }

    public void addWorker(Worker worker) {
        this.workers.add(worker);
    }

    public void removeWorker(Worker worker) {
        this.workers.remove(worker);
    }
}
