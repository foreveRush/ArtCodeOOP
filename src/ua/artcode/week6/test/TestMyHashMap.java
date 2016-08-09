package ua.artcode.week6.test;

import ua.artcode.week6.MyHashtable;

import java.util.Map;

/**
 * Created by Serhii Fursenko on 08.08.16.
 */
public class TestMyHashMap {

    public static void main(String[] args) {
        Map<String, Integer> map = new MyHashtable<>();
        System.out.println(map.isEmpty());



        map.put("1",1);

        map.put("2",2);
        map.put("2",3);
        map.put("3",32);

        int testValue = map.get("3");
        System.out.println(testValue);





    }
}
