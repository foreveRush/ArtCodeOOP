package ua.artcode.week2.servicecenter.model;

import ua.artcode.week1.contactlist.Address;

/**
 * Created by Serhii Fursenko on 09.07.2016.
 * fyrsenko@gmail.com
 */
public class Director {

    private ServiceCenter serviceCenter;

    public void changeAddress(Address address) {
        serviceCenter.setAddress(address);
    }

    public void hireWorker(Administrator administrator) {
        serviceCenter.setAdministrator(administrator);
    }

    public void hireWorker(RepairWorker worker) {
        serviceCenter.addWorker(worker);
    }

    public void removeAdministrator() {
        serviceCenter.setAdministrator(null);
    }

    public void removeWorker(Worker worker) {
        serviceCenter.removeWorker(worker);
    }

    public void showAllWorkers() {
        System.out.println("Administrator: " + serviceCenter.getAdministrator());
        String workersString = "";
        for(Worker worker : serviceCenter.getRepairWorkers()) {
            workersString += worker.getName() + ", ";
        }
        workersString = workersString.substring(0, workersString.length()-2);
        System.out.print("Workers: " + workersString);
    }

    public void payTax() {

    }

    public void increaseSalary() {
        serviceCenter.getAdministrator().setSalary((int)(serviceCenter.getAdministrator().getSalary()*1.1));
        for(Worker worker : serviceCenter.getRepairWorkers()) {
            worker.setSalary((int)(worker.getSalary()*1.1));
        }
    }




}
