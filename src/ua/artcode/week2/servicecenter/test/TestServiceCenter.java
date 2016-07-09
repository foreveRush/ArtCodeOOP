package ua.artcode.week2.servicecenter.test;

import ua.artcode.week1.contactlist.Address;
import ua.artcode.week2.newpost.model.MyDate;
import ua.artcode.week2.servicecenter.model.*;


/**
 * Created by Serhii Fursenko on 09.07.2016.
 * fyrsenko@gmail.com
 */
public class TestServiceCenter {

    public static void main(String[] args) {

        Director director = new Director();
        ServiceCenter serviceCenter = new ServiceCenter(director);

        serviceCenter.setAddress(new Address("Kiyv", "Lesi", 22));

        Administrator administrator = new Administrator("Ivan Petrov", "5554 6578 4697 7844", 5000);
        Repairer repairer1 = new Repairer("Oleg Korchin","2222 4678 9971 0001",6500);

        director.addWorker(administrator);
        director.addWorker(repairer1);

        Client client1 = new Client();
        Client client2 = new Client();

        Tech tech1 = new Tech("TV Samsung", "5Aff-46SF-GE7G", 8500, new MyDate(2016, 11, 05, 12, 5), Condition.BAD);
        Tech tech2 = new Tech("Telephone LG", "5654-7894-4888-7777", 3000, new MyDate(2015, 1, 02, 16, 25), Condition.BAD);
        Tech tech3 = new Tech("Tablet Asus", "ASDD-FASG-GARE-ARER", 4500, new MyDate(2015, 8, 04, 12, 12), Condition.BAD);
        Tech tech4 = new Tech("iMac", "5Aff-46SF-GE7G", 15000, new MyDate(2016, 01, 01, 12, 5), Condition.BAD);

        administrator.getTechForRepair(client1, new Tech[]{tech1,tech2});
        administrator.getTechForRepair(client2, new Tech[]{tech3});
        administrator.getTechForRepair(client1, new Tech[]{tech4});


    }
}
