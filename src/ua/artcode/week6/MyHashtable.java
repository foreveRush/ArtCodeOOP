package ua.artcode.week6;

import java.util.Collection;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * Created by Serhii Fursenko on 08.08.16.
 */
public class MyHashtable<K, V> implements Map<K, V> {

    public static final int DEFAULT_TABLE_SIZE = 32;
    private Node[] table;
    private int size;
    private Set<K> keySet;
    private Collection<V> valueSet;


    public MyHashtable() {

        table = new Node[DEFAULT_TABLE_SIZE];
        keySet = new HashSet<>();
        valueSet = new HashSet<>();
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0 ? true : false;
    }

    @Override
    public boolean containsKey(Object key) {

        for(K iterator : keySet) {

            if(iterator.equals(key)) return true;

        }
        return false;
    }

    @Override
    public boolean containsValue(Object value) {

        for(V iterator : valueSet) {
            if(iterator.equals(value)) return true;
        }
        return false;
    }

    @Override
    public V get(Object key) {

        int hash = key.hashCode();

        Node node = table[hash % table.length];

        if (node == null) return null;

        V value = tryGet(node, (K) key);

        return value;
    }

    private V tryGet(Node node, K key) {

        if (node.key.equals(key)) {
            return (V) node.value;
        }

        if (node.next == null) {
            return null;
        }

        return tryGet(node.next, key);

    }

    @Override
    public V put(K key, V value) {

        int hash = key.hashCode();

        if (table[hash % table.length] == null) {
            table[hash % table.length] = new Node(key, value, null);
            size++;
            keySet.add(key);
            valueSet.add(value);
            return value;
        }

        boolean operationSuccessfully = tryPut(table[hash % table.length], key, value);

        return operationSuccessfully ? value : null;
    }

    private boolean tryPut(Node node, K key, V value) {

        if (node.key.equals(key)) {
            valueSet.remove(node.value);
            valueSet.add(value);
            node.value = value;
            return true;
        }

        if (node.next == null) {
            node.next = new Node(key, value, null);
            valueSet.add(value);
            keySet.add(key);
            size++;
            return true;
        }

        return tryPut(node.next, key, value);
    }

    @Override
    public V remove(Object key) {

        V value;
        int hash = key.hashCode();
        Node node = table[hash % table.length];

        if (node == null) return null;

        if (node.key.equals(key)) {
            value = (V) node.value;
            table[hash % table.length] = node.next;
            size--;
            keySet.remove(key);
            valueSet.remove(value);
            return value;
        }

        value = tryRemoveFromNextNode(node, (K) key);


        return value;
    }

    private V tryRemoveFromNextNode(Node node, K key) {
        if (node.next == null) return null;
        if (key.equals(node.next.key)) {
            V value = (V) node.next;
            node.next = node.next.next;
            size--;
            keySet.remove(key);
            valueSet.remove(value);
            return value;
        }
        return tryRemoveFromNextNode(node.next, key);
    }

    @Override
    public void putAll(Map<? extends K, ? extends V> m) {
        for (Entry<? extends K, ? extends V> entry : m.entrySet()) {
            this.put(entry.getKey(), entry.getValue());
        }
    }

    @Override
    public void clear() {
        table = new Node[DEFAULT_TABLE_SIZE];
        keySet = new HashSet<>();
        valueSet = new HashSet<>();
        size = 0;
    }

    @Override
    public Set keySet() {
        return keySet;
    }

    @Override
    public Collection values() {
        return valueSet;
    }

    @Override
    public Set<Entry<K, V>> entrySet() {

        Set<Entry<K, V>> entrySet = keySet.stream().map(key -> new MyEntry<>(key, this.get(key))).collect(Collectors.toSet());

        return entrySet;
    }

    private class Node<K, V> {
        K key;
        V value;
        Node next;

        public Node(K key, V value, Node node) {
            this.key = key;
            this.value = value;
            this.next = node;
        }
    }

    private class MyEntry<K, V> implements Entry<K, V> {

        K key;
        V value;

        public MyEntry(K key, V value) {
            this.key = key;
            this.value = value;
        }

        @Override
        public K getKey() {
            return key;
        }

        @Override
        public V getValue() {
            return value;
        }

        @Override
        public Object setValue(Object value) {
            V tempValue = (V) value;
            this.value = (V) value;
            return tempValue;
        }
    }
}
