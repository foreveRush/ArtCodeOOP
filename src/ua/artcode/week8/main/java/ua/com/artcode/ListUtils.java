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

        A<T> newHead = head;
        A<T> tempNode;
        int length = 0;

        while (newHead.getNext() != null) {
            newHead = newHead.getNext();
            length++;
        }

        for (int i = length - 1; i >= 0; i--) {
            tempNode = getNode(head, i);
            setLast(newHead, tempNode);
        }

        return newHead;
    }

    private static <T> A<T> getNode(A<T> head, int index) {
        A<T> nodeForRet = head;
        for (int i = 0; i < index; i++) {
            nodeForRet = nodeForRet.getNext();
        }
        nodeForRet.setNext(null);
        return nodeForRet;
    }

    private static <T> void setLast(A<T> head, A<T> nodeToPut) {
        A<T> nodeForReplace = head.getNext();
        if (nodeForReplace == null) {
            head.setNext(nodeToPut);
            return;
        }
        while (nodeForReplace.getNext() != null) {
            nodeForReplace = nodeForReplace.getNext();
        }
        nodeForReplace.setNext(nodeToPut);
    }


}
