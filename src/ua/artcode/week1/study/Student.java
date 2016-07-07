package ua.artcode.week1.study;

import ua.artcode.week1.contactlist.Address;

import java.util.ArrayList;

/**
 * Created by home on 07.07.2016.
 */
public class Student {

    String name;
    Address address;
    ArrayList<Subject> list;

    Student(String name, String city, String string, int age) {
        this.name = name;
        this.address = new Address(city, string, age);
        list = new ArrayList<>();
    }

    public void addSubject(Subject subject) {
        this.list.add(subject);
    }

    public void removeSubject(Subject subject) {
        this.list.remove(subject);
    }

    public void showSubjectsInfo() {
        for(Subject subject : this.list){
            subject.showInfo();
        }
    }

    public void getAverageRating() {
        int sum=0;
        for(Subject subject : this.list){
            sum+=subject.rating;
        }
        System.out.println(String.format("Average rating is: %f", sum/list.size()));
    }

    public void study() {

    }
}
