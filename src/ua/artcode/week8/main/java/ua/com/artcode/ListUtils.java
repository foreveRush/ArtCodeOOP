package ua.artcode.week8.main.java.ua.com.artcode;

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

        A<T> newHead = null;
        A<T> tempLast = null;
        A<T> tempNode;
        tempNode = head;

        while (tempNode.getNext() != null) {
            tempNode = tempNode.getNext();
            newHead = tempNode;
        }

        A<T> currentNode = newHead;
        tempLast = newHead;

        while (tempLast != head) {

            tempNode = head;
            while (tempNode.getNext() != tempLast) {
                tempNode = tempNode.getNext();
            }
            tempNode.setNext(null);
            tempLast = tempNode;
            currentNode.setNext(tempNode);
            currentNode = currentNode.getNext();
        }
        return newHead;
    }
}
