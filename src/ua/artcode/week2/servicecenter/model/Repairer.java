package ua.artcode.week2.servicecenter.model;

/**
 * Created by Serhii Fursenko on 09.07.2016.
 * fyrsenko@gmail.com
 */
public class Repairer extends Worker {

    private Ticket order;
    private ServiceCenter workPlace;

    public Repairer(String name, String bankAcc, int salary) {

        this.setName(name);
        this.setBankAcc(bankAcc);
        this.setSalary(salary);
    }

    public Ticket getOrder() {
        return order;
    }

    public void setOrder(Ticket order) {
        System.out.printf("Repairer %s got new order #%d\n", this.getName(), order.getId());
        this.order = order;

    }

    public ServiceCenter getWorkPlace() {
        return workPlace;
    }

    public void setWorkPlace(ServiceCenter workPlace) {
        this.workPlace = workPlace;
    }

    public void repair(Tech tech) {
        System.out.println("Trying to repair...");
        tech.setCondition(Condition.OK);
        System.out.printf("Tech %s with serial number %s is OK\n", tech.getTitle(), tech.getSerialNumber());

    }

    public void returnTech() {
        System.out.printf("Order #%s sending back to administrator...\n", order.getId());
        workPlace.getAdministrator().returnTech(order);

        this.order = null;
    }
}
