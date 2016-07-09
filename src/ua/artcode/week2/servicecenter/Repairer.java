package ua.artcode.week2.servicecenter;

import java.util.ArrayList;

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
        this.order = order;
        repair(order);
        workPlace.getAdministrator().returnTech(order);


    }

    public void repair(Ticket order) {
        for(Tech tech : order.getTechList()) {
            tech.setCondition(Condition.OK);
        }
    }
}
