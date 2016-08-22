package ua.artcode.week8.main.java.ua.com.artcode;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class ListUtils {

    public static A<String> createStringList() {
        A<String> head = new Node<>("A");
        A<String> second = new Node<>("B");
        A<String> third = new Node<>("C");
        A<String> fourth = new Node<>("D");
        A<String> fifth = new Node<>("E");
        A<String> sixth = new Node<>("F");
        A<String> seventh = new Node<>("G");
        head.setNext(second);
        second.setNext(third);
        third.setNext(fourth);
        fourth.setNext(fifth);
        fifth.setNext(sixth);
        sixth.setNext(seventh);
        return head;
    }

    public static <T> A<T> reversion(A<T> head) {
//        todo write your code
        List<A<T>> listOfNodes = new LinkedList<>();
        A<T> newHead = head;
        while (newHead!=null) {
            listOfNodes.add(newHead);
            newHead=newHead.getNext();
        }
        Collections.reverse(listOfNodes);
        A<T> [] arrayOfNodes = listOfNodes.stream().toArray(A[]::new);
        for(int i=0; i<arrayOfNodes.length; i++) {
            if(i==arrayOfNodes.length-1) {
                arrayOfNodes[i].setNext(null);
                return arrayOfNodes[0];
            }
            arrayOfNodes[i].setNext(arrayOfNodes[i+1]);
        }

        return arrayOfNodes[0];
    }


}
