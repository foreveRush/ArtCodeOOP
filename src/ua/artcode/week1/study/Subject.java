package ua.artcode.week1.study;

import java.util.Random;

/**
 * Created by home on 07.07.2016.
 */
public class Subject {

    String name;
    int hours;
    int reallyHours;
    int rating;
    boolean passed;


    public void passExam() {

        Random random = new Random();

        if (hours != reallyHours) {
            System.out.println("Need more hours");
            return;
        } else {
            int mark = random.nextInt(6);
            if (mark < 3) {
                rating = 2;
            } else {
                rating = mark;
                passed = true;
            }
        }

    }

    public void getRating() {
        if(!passed) {
            System.out.println("Not passed");
        } else {
            System.out.println(rating);
        }
    }

    public void showInfo() {
        System.out.println("\n");
        System.out.println(name);
        System.out.println(String.format("Scheduled hours: %d", hours));
        System.out.println(String.format("Hours passed: %d", reallyHours));
        System.out.println(String.format("Rating: %d\n", rating));
    }
}
