package ua.artcode.week2.servicecenter;

import ua.artcode.week1.contactlist.Address;
import ua.artcode.week2.servicecenter.model.Administrator;
import ua.artcode.week2.servicecenter.model.Director;
import ua.artcode.week2.servicecenter.model.Repairer;
import ua.artcode.week2.servicecenter.model.ServiceCenter;
import ua.artcode.week2.servicecenter.utils.Menu;

/**
 * Created by Serhii Fursenko on 09.07.2016.
 * fyrsenko@gmail.com
 */
public class AppRun {

    public static void main(String[] args) {

        Director director = new Director();
        director.setName("Boris Kirov");
        ServiceCenter serviceCenter = new ServiceCenter(director);

        serviceCenter.setAddress(new Address("Kiyv", "Lesi", 22));

        Administrator administrator = new Administrator("Ivan Petrov", "5554 6578 4697 7844", 5000);
        Repairer repairer1 = new Repairer("Oleg Korchin","2222 4678 9971 0001",6500);

        director.addWorker(administrator);
        director.addWorker(repairer1);

        Menu menu = new Menu(serviceCenter);

        menu.runMainMenu();
    }
}
