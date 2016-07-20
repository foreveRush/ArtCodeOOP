package ua.artcode.week4;

import java.util.Random;

/**
 * Created by Serhii Fursenko on 20.07.2016.
 * fyrsenko@gmail.com
 */
public class Utils {

    public static int[] genArray(int size) {

        int[] array = new int[size];
        Random random = new Random();
        for (int i=0; i<array.length; i++){
            array[i] = random.nextInt(50);
        }

        return array;
    }

    public static void showArray(int[] array) {
        for (int t: array) {
            System.out.print(t+" ");
        }
        System.out.println();
    }
}
