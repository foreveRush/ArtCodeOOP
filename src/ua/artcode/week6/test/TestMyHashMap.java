package ua.artcode.week6.test;

import ua.artcode.week6.MyHashMap;

import java.util.Map;

/**
 * Created by Serhii Fursenko on 08.08.16.
 */
public class TestMyHashMap {

    public static void main(String[] args) {
        Map<String, Integer> map = new MyHashMap<>();
        System.out.println(map.size());

        map.put("1",1);
        map.put("2",2);
        map.put("3",3);
        map.put("4",4);
        map.put("2",3);
        map.put("2",6);

        System.out.println(map.size());

    }
}
