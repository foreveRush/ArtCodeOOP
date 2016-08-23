package ua.artcode.week8.main.java.ua.com.artcode;

import java.util.Objects;

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

        A<T> newHead = head;
        A<T> tempNode;

        while (head.getNext()!=null) {
            tempNode = head.getNext();
            head.setNext(tempNode.getNext());
            tempNode.setNext(newHead);
            newHead = tempNode;
        }
        return newHead;
    }
}
