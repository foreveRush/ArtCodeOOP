package ua.artcode.week4.structure;

import java.util.List;

/**
 * Created by Serhii Fursenko on 20.07.2016.
 * fyrsenko@gmail.com
 */
public class MyStructure {
    public int amount;
    public List<MyStructure> myStructures;

    public MyStructure(int amount) {
        this.amount = amount;
    }

    public MyStructure(int amount, List<MyStructure> myStructures) {
        this.amount = amount;
        this.myStructures = myStructures;
    }
}
