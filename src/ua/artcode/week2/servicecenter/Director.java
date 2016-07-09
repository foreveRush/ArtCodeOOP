package ua.artcode.week2.servicecenter;

import ua.artcode.week1.contactlist.Address;

/**
 * Created by Serhii Fursenko on 09.07.2016.
 * fyrsenko@gmail.com
 */
public class Director {

    private ServiceCenter workPlace;

    public void changeAddressOfWorkPlace(Address address) {
        workPlace.setAddress(address);
    }

    public void addWorker(Worker worker){
        if(worker instanceof Administrator) {
            workPlace.setAdministrator((Administrator)worker);
        } else {
            workPlace.getWorkers().add((Repairer) worker);
        }
    }

    public void removeWorker(Worker worker){
        if(worker instanceof Administrator && worker==workPlace.getAdministrator()) {
            workPlace.getAdministrator().setWorkPlace(null);
            workPlace.setAdministrator(null);
        } else {
            for(Worker currWorker : workPlace.getWorkers()){
                if(currWorker==worker) {
                    workPlace.getWorkers().remove(worker);
                    return;
                }
            }
        }
    }

    public void showAllWorkers() {
        System.out.println("Administrator: " + workPlace.getAdministrator());
        for(Worker worker : workPlace.getWorkers()) {
            System.out.println("Worker: " + worker);
        }
    }

    public void payTax() {

    }
}
