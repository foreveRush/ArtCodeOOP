package ua.artcode.week2.servicecenter.test;

import ua.artcode.week1.contactlist.Address;
import ua.artcode.week2.newpost.model.MyDate;
import ua.artcode.week2.servicecenter.model.*;

import java.lang.reflect.Array;

/**
 * Created by Serhii Fursenko on 09.07.2016.
 * fyrsenko@gmail.com
 */
public class TestServiceCenter {

    public static void main(String[] args) {

        Director director = new Director();
        ServiceCenter serviceCenter = new ServiceCenter();
        director.setWorkPlace(serviceCenter);

        serviceCenter.setAddress(new Address("Kiyv", "Lesi", 22));

        Administrator administrator = new Administrator();
        administrator.setName("Ivan Petrov");
        administrator.setSalary(5000);
        administrator.setBankAcc("5554 6578 4697 7844");

        Repairer repairer1 = new Repairer();
        repairer1.setName("Oleg Korchin");
        repairer1.setBankAcc("2222 4678 9971 0001");
        repairer1.setSalary(6500);

        Repairer repairer2 = new Repairer();
        repairer2.setName("Anton Ruk");
        repairer2.setBankAcc("3001 8845 6504 3350");
        repairer2.setSalary(8000);

        director.addWorker(administrator);
        director.addWorker(repairer1);
        director.addWorker(repairer2);

        Client client1 = new Client();
        Client client2 = new Client();


        Tech tech1 = new Tech("TV Samsung", "5Aff-46SF-GE7G", 8500, new MyDate(2016,11,05,12,5), Condition.BAD);
        Tech tech2 = new Tech("Telephone LG", "5654-7894-4888-7777", 3000, new MyDate(2015,1,02,16,25), Condition.BAD);
        Tech tech3 = new Tech("Tablet Asus", "ASDD-FASG-GARE-ARER", 4500, new MyDate(2015,8,04,12,12), Condition.BAD);
        Tech tech4 = new Tech("iMac", "5Aff-46SF-GE7G", 15000, new MyDate(2016,01,01,12,5), Condition.BAD);

        Tech[] techForRepair = {tech1,tech2};
        Tech[] techForRepair1 = {tech3};
        Tech[] techForRepair2 = {tech4};
        administrator.getTechForRepair(client1, techForRepair);
        administrator.getTechForRepair(client2, techForRepair1);
        administrator.getTechForRepair(client1, techForRepair2);




    }
}
