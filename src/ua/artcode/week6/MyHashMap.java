package ua.artcode.week6;

import java.util.Collection;
import java.util.Map;
import java.util.Set;

/**
 * Created by Serhii Fursenko on 08.08.16.
 */
public class MyHashMap<K, V> implements Map<K, V> {

    public static final int DEFAULT_TABLE_SIZE = 32;

    private Node[] table;
    private int size;

    public MyHashMap() {
        table = (Node[]) new Object[DEFAULT_TABLE_SIZE];
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return table == null ? true : false;
    }

    @Override
    public boolean containsKey(Object key) {
        return false;
    }

    @Override
    public boolean containsValue(Object value) {
        return false;
    }

    @Override
    public V get(Object key) {
        return null;
    }

    @Override
    public V put(K key, V value) {
        int hash = key.hashCode();
        if (table[hash % table.length] == null) {
            table[hash % table.length] = new Node(key, value, null);
        } else {
            putToFreeNode(table[hash % table.length], key, value);
        }
        size++;

        return value;
    }

    private void putToFreeNode(Node node, K key, V value) {
        if (node.next == null) {
            node.next = new Node(key, value, null);
        } else {
            putToFreeNode(node.next, key, value);
        }
    }

    @Override
    public V remove(Object key) {
        return null;
    }

    @Override
    public void putAll(Map m) {

    }

    @Override
    public void clear() {

    }

    @Override
    public Set keySet() {
        return null;
    }

    @Override
    public Collection values() {
        return null;
    }

    @Override
    public Set<Entry<K, V>> entrySet() {

        return null;
    }

    private class Node<K,V> {
        K key;
        V value;
        Node next;

        public Node(K key, V value, Node node) {
            this.key = key;
            this.value = value;
            this.next = node;
        }


    }
}
