package ua.artcode.week4.structure;

import java.util.Arrays;
import java.util.List;

/**
 * Created by Serhii Fursenko on 20.07.2016.
 * fyrsenko@gmail.com
 */
public class TestStructure {

    public static void main(String[] args) {
        MyStructure myStructure = new MyStructure(1000);
        MyStructure myStructure1 = new MyStructure(1000);
        MyStructure myStructure2 = new MyStructure(1000);
        MyStructure myStructure3 = new MyStructure(1000);

        MyStructure myStructure4 = new MyStructure(1000, Arrays.asList(myStructure,myStructure1));
        MyStructure myStructure5 = new MyStructure(1000, Arrays.asList(myStructure2,myStructure3));

        MyStructure myStructure6 = new MyStructure(1000, Arrays.asList(myStructure4,myStructure5));

        System.out.println(testRec(myStructure6));


    }

    public static int testRec(MyStructure myStructure) {
        int amount = myStructure.amount;
        List<MyStructure> list = myStructure.myStructures;
        if (list == null) {
            return amount;
        }
        for (MyStructure myStructure1 : list) {

            amount += testRec(myStructure1);
        }

        return amount;
    }


}
