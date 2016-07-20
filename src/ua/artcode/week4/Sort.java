package ua.artcode.week4;

/**
 * Created by Serhii Fursenko on 20.07.2016.
 * fyrsenko@gmail.com
 */
public class Sort {

    public static void linearSort(int[] array) {
        int minI = 0;
        for(int i=0; i<array.length; i++) {
            for(int j=i; j<array.length; j++) {
                if(array[minI]>array[j]) {
                    minI=j;
                }
            }
            int temp = array[i];
            array[i] = array[minI];
            array[minI] = temp;
        }
    }

    public static void bubbleSort(int[] array) {
        for(int i = array.length-1; i>=0; i--) {
            for(int j = 0; j<i; j++) {

                if(array[j]>array[j+1]) {
                    int temp = array[j];
                    array[j] = array[j+1];
                    array[j+1] = temp;
                }
            }
        }
    }
}
