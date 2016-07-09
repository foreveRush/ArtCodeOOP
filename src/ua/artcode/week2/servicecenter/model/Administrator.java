package ua.artcode.week2.servicecenter.model;

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

    public Administrator(String name, String bankAcc, int salary) {

        this.setName(name);
        this.setBankAcc(bankAcc);
        this.setSalary(salary);
    }

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
        System.out.printf("Generate new order #%s\n", newOrder.getId());
        workPlace.getActualOrders().add(newOrder);
        System.out.printf("Price for order is %d\n",newOrder.getOrderPrice() );
        cash+=newOrder.getOrderPrice();
        System.out.printf("Sending order to repairer...\n");
        this.giveOrderToRepairer(newOrder);
    }

    public void returnTech(Ticket ticket) {
        System.out.println("Administrator chacking order...");
        for(Tech tech : ticket.getTechList()) {
            if(tech.getCondition()==Condition.BAD) {
                System.out.println("Order in work yet...");
                return;
            }
        }
        System.out.println("Change status of order to DONE");
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
