package ua.artcode.week2.servicecenter;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by Serhii Fursenko on 09.07.2016.
 * fyrsenko@gmail.com
 */
public class Administrator extends Worker {

    private ServiceCenter workPlace;
    private int cash;
    private ArrayList<String> reportList = new ArrayList<>();
    private int indexOfRepairers;

    public ServiceCenter getWorkPlace() {
        return workPlace;
    }

    public void setWorkPlace(ServiceCenter workPlace) {
        this.workPlace = workPlace;
    }

    public void showAllClients() {
        int i = 1;
        for (Client client : workPlace.getClients()) {
            System.out.println(i++ + ". " + client);
        }
    }

    public void getTechForRepair(Client client, Tech [] tech){
        for(Client clientIterator : workPlace.getClients()) {
            if(clientIterator == client) {
                break;
            }
            workPlace.getClients().add(client);
        }
        Ticket newOrder = new Ticket(client, new ArrayList<Tech>(Arrays.asList(tech)));
        workPlace.getActualOrders().add(newOrder);
        cash+=newOrder.getOrderPrice();
        this.giveOrderToRepairer(newOrder);
    }

    public void returnTech(Ticket ticket) {
        for(Tech tech : ticket.getTechList()) {
            if(tech.getCondition()==Condition.BAD) {
                System.out.println("Order in work yet...");
                return;
            }
        }
        workPlace.getDoneOrders().add(ticket);
        workPlace.getActualOrders().remove(ticket);
        System.out.println("Client took back his tech");
        this.reportList.add(ticket.toString());
    }

    public void showReport() {
        System.out.println(this.reportList);
    }

    public void giveOrderToRepairer(Ticket ticket) {
        for(Repairer repairer : workPlace.getWorkers()) {
            if(repairer.getOrder()==null) {
                repairer.setOrder(ticket);
                return;
            }
        }
    }
}
