package ua.artcode.week4;

import java.util.Random;

/**
 * Created by Serhii Fursenko on 20.07.2016.
 * fyrsenko@gmail.com
 */
public class Testing {

    public static void main(String[] args) {


        int[] array1 = Utils.genArray(300000);

        TimeCounter timeCounter1 = new TimeCounter() {
            @Override
            public double action() {
                double start = System.currentTimeMillis();
                double end = System.currentTimeMillis();
                System.out.println("bubble time: " + (end - start));
                return end-start;
            }
        };

        timeCounter1.action();

        int[] array = Utils.genArray(50000);

        TimeCounter timeCounter = new TimeCounter() {
            @Override
            public double action() {
                double start = System.currentTimeMillis();
                Sort.linearSort(array);
                double end = System.currentTimeMillis();
                System.out.println("linear time: " + (end - start));
                return end-start;
            }
        };

        timeCounter.action();






    }

}
