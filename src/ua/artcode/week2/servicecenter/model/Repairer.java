package ua.artcode.week2.servicecenter.model;

/**
 * Created by Serhii Fursenko on 09.07.2016.
 * fyrsenko@gmail.com
 */
public class Repairer extends Worker {

    private Ticket order;
    private ServiceCenter workPlace;

    public Ticket getOrder() {
        return order;
    }

    public void setOrder(Ticket order) {
        System.out.printf("Repairer %s got new order #%d\n", this.getName(), order.getId());
        this.order = order;
        System.out.println("Trying to repair...");
        repair(order);
        System.out.printf("Order #%s sending back to administrator...\n", order.getId());
        workPlace.getAdministrator().returnTech(order);

        this.order = null;


    }

    public void repair(Ticket order) {
        for(Tech tech : order.getTechList()) {
            tech.setCondition(Condition.OK);
            System.out.printf("Tech %s with serial number %s is OK\n", tech.getTitle(), tech.getSerialNumber());
        }
    }

    public ServiceCenter getWorkPlace() {
        return workPlace;
    }

    public void setWorkPlace(ServiceCenter workPlace) {
        this.workPlace = workPlace;
    }
}
