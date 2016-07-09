package ua.artcode.week2.servicecenter;

import java.util.ArrayList;

/**
 * Created by Serhii Fursenko on 09.07.2016.
 * fyrsenko@gmail.com
 */
public class Worker {

    private String name;
    private String phone;
    private String bankAcc;
    private int salary;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getBankAcc() {
        return bankAcc;
    }

    public void setBankAcc(String bankAcc) {
        this.bankAcc = bankAcc;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    @Override
    public String toString() {
        return this.getName();
    }
}
