package ua.artcode.week6.test;

import ua.artcode.week6.MyHashtable;

import java.security.KeyStore;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

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

        Set<Map.Entry<String,Integer>> set = map.entrySet();
        int testValue = map.get("3");

        for(Map.Entry<String, Integer> entry : set) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }

        System.out.println(map.containsKey("10"));
        System.out.println(map.containsKey("1"));
        System.out.println(map.containsKey("3"));

        for(int i=0; i<50; i++) {
            map.put(String.valueOf(i),i);
        }






    }
}
