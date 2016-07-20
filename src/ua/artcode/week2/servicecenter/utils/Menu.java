package ua.artcode.week2.servicecenter.utils;

import ua.artcode.week1.contactlist.Address;
import ua.artcode.week2.newpost.model.Client;
import ua.artcode.week2.newpost.model.MyDate;
import ua.artcode.week2.servicecenter.model.*;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by Serhii Fursenko on 09.07.2016.
 * fyrsenko@gmail.com
 */
public class Menu {

    private ServiceCenter serviceCenter;
    static Scanner scanner = new Scanner(System.in);

    public Menu(ServiceCenter serviceCenter) {
        this.serviceCenter = serviceCenter;
    }

    public void runMainMenu() {

        while (true) {
            System.out.println("Login as:");
            System.out.println("1. Director");
            System.out.println("2. Administrator");
            System.out.println("3. Repairer");
            System.out.println("4. Client");
            System.out.println("0. Exit");

            int choise = scanner.nextInt();
            scanner.nextLine();

            switch (choise) {
                case 0:
                    return;
                case 1:
                    runDirectorMenu();
                    break;
                case 2:
                    runAdministratorMenu();
                    break;
                case 3:
                    runRepairerMenu();
                    break;
                case 4:
                    runClientMenu();
                    break;
            }
        }
    }

    private void runDirectorMenu() {

        System.out.printf("\nHello %s\n", this.serviceCenter.getDirector().getName());
        while (true) {
            System.out.println();
            System.out.println("1. Change address of service center");
            System.out.println("2. Add new worker");
            System.out.println("3. Remove worker");
            System.out.println("4. Show all workers");
            System.out.println("5. Pay tax");
            System.out.println("0. Log out");

            int choise = scanner.nextInt();
            scanner.nextLine();

            switch (choise) {
                case 0:
                    System.out.printf("\nGoodbye %s\n", this.serviceCenter.getDirector().getName());
                    return;
                case 1:
                    System.out.println("Input new address");
                    System.out.println("City:");
                    String city = scanner.nextLine();
                    System.out.println("Street:");
                    String street = scanner.nextLine();
                    System.out.println("Number:");
                    int number = scanner.nextInt();
                    scanner.nextLine();
                    serviceCenter.getDirector().changeAddressOfWorkPlace(new Address(city, street, number));
                    System.out.println("Address changed");
                    break;
                case 2:
                    System.out.println("1. Administrator");
                    System.out.println("2. Repairer");
                    System.out.println("0. Back");

                    choise = scanner.nextInt();
                    scanner.nextLine();

                    switch (choise) {
                        case 0:
                            break;
                        case 1:
                            System.out.println("Input name");
                            String name = scanner.nextLine();
                            System.out.println("Input bank acc");
                            String bankAcc = scanner.nextLine();
                            System.out.println("Input salary");
                            int salary = scanner.nextInt();
                            scanner.nextLine();
                            serviceCenter.getDirector().addWorker(new Administrator(name, bankAcc, salary));
                            break;
                        case 2:
                            System.out.println("Input name");
                            String name1 = scanner.nextLine();
                            System.out.println("Input bank acc");
                            String bankAcc1 = scanner.nextLine();
                            System.out.println("Input salary");
                            int salary1 = scanner.nextInt();
                            scanner.nextLine();
                            serviceCenter.getDirector().addWorker(new Repairer(name1, bankAcc1, salary1));
                            break;
                    }

                    break;
                case 3:
                    removeWorker();
                    break;
                case 4:
                    showAllWorkers();
                    break;
                case 5:
                    serviceCenter.getDirector().payTax();
                    break;
                default:
                    break;
            }
        }


    }

    private void removeWorker() {

        System.out.println("Choise worker to remove:");
        showAllWorkers();
        System.out.println("0. Back");
        int index = scanner.nextInt();
        scanner.nextLine();
        switch (index) {
            case 0:
                return;
            case 1:
                System.out.println("You can't remove director");
                break;
            case 2:
                serviceCenter.getAdministrator().setWorkPlace(null);
                serviceCenter.setAdministrator(null);
                System.out.println("Administrator removed");
                break;
            default:
                serviceCenter.getWorkers().remove(index - 3);
                System.out.println("Worker removed");
                break;
        }
    }

    private void showAllWorkers() {
        System.out.printf("1. Director - %s\n", serviceCenter.getDirector().getName());
        System.out.printf("2. Administrator - %s\n", serviceCenter.getAdministrator().getName());
        int i = 3;
        for (Repairer repairer : serviceCenter.getWorkers()) {
            System.out.printf("%d. Worker - %s\n", i++, repairer.getName());
        }
    }

    private void runAdministratorMenu() {

        System.out.printf("\nHello %s\n", this.serviceCenter.getAdministrator().getName());

        while (true) {
            System.out.println("1. Show all clients");
            System.out.println("2. Take tech for repair");
            System.out.println("3. Show report");
            System.out.println("4. Return done order");
            System.out.println("5. Send tech to repairer");
            System.out.println("0. Log out");

            int choise = scanner.nextInt();
            scanner.nextLine();

            switch (choise) {
                case 0:
                    System.out.printf("\nGoodbye %s\n", this.serviceCenter.getAdministrator().getName());
                    return;
                case 1:
                    serviceCenter.getAdministrator().showAllClients();
                    break;
                case 2:
                    System.out.println("Input Client name");
                    String name = scanner.nextLine();
                    ua.artcode.week2.servicecenter.model.Client client = new ua.artcode.week2.servicecenter.model.Client();
                    client.setName(name);
                    ArrayList<Tech> teches = new ArrayList<>();
                    AddClient:
                    while (true) {
                        System.out.println("1. Add tech");
                        System.out.println("0. Done");

                        int index = scanner.nextInt();
                        scanner.nextLine();

                        switch (index) {
                            case 0:
                                Tech[] techArray = new Tech[teches.size()];
                                teches.toArray(techArray);
                                serviceCenter.getAdministrator().getTechForRepair(client, techArray);
                                break AddClient;
                            case 1:
                                System.out.println("Input tech name");
                                String techName = scanner.nextLine();
                                System.out.println("Input tech serial number");
                                String techSerial = scanner.nextLine();
                                System.out.println("Input tech price");
                                int techprice = scanner.nextInt();
                                scanner.nextLine();
                                teches.add(new Tech(techName, techSerial, techprice, new MyDate(2000, 12, 12, 20, 0), Condition.BAD));
                                break;
                        }
                    }
                    break;
                case 3:
                    serviceCenter.getAdministrator().showReport();
                    break;

                case 4:
                    System.out.println("Input ticket of order");
                    int ticket = scanner.nextInt();
                    scanner.nextLine();
                    /////////////////////////////////////////////////////////
                    Ticket order = serviceCenter.getAdministrator().findTicketById(ticket);
                    serviceCenter.getAdministrator().returnTech(order);
                    break;
                case 5:
                    System.out.println("Please choose the ticket to send");
                    int index = 1;
                    for (Ticket ticket1 : serviceCenter.getActualOrders()) {
                        System.out.printf("%d. Order #%d from %s\n", index++, ticket1.getId(), ticket1.getClient().getName());
                    }
                    int choiseTicket = scanner.nextInt();
                    scanner.nextLine();
                    serviceCenter.getAdministrator().giveOrderToRepairer(serviceCenter.getActualOrders().get(choiseTicket - 1));
                    break;

            }

        }
    }

    private void runRepairerMenu() {

        System.out.printf("\nLogin as:\n");
        int iteraor = 1;
        for(Repairer repairer : serviceCenter.getWorkers()) {
            System.out.printf("%d. %s\n", iteraor++, repairer.getName());
        }
        int index = scanner.nextInt();
        scanner.nextLine();

        Repairer repairer = serviceCenter.getWorkers().get(index-1);
        System.out.println("1. Show actual tasks");
        System.out.println("2. Return done order");
        System.out.println("0. Log out");

        index = scanner.nextInt();
        scanner.nextLine();

        switch (index) {
            case 0:
                return;
            case 1:
                iteraor = 0;
                System.out.printf("Order #%d:", repairer.getOrder().getId());
                for(Tech tech : repairer.getOrder().getTechList()) {
                    System.out.printf("%d. %s serial = %s , status = %s",
                            iteraor++, tech.getTitle(), tech.getSerialNumber(), tech.getCondition());
                }
                System.out.println("0. Go back");
                index = scanner.nextInt();
                scanner.nextLine();

                if(repairer.getOrder().getTechList().get(index-1).getCondition()==Condition.BAD) {
                    repairer.repair(repairer.getOrder().getTechList().get(index-1));
                }
                break;
            case 2:
                for(Tech tech : repairer.getOrder().getTechList()) {
                    if(tech.getCondition()!=Condition.OK) {
                        System.out.println("Order not done yet");
                        break;
                    }
                }
                serviceCenter.getAdministrator().changeStatusToDone(repairer.getOrder());
        }

    }

    private void runClientMenu() {
    }
}
