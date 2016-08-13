package ua.artcode.week6;

import java.util.*;
import java.util.stream.Collectors;

/**
 * Created by Serhii Fursenko on 08.08.16.
 */
public class MyHashtable<K, V> implements Map<K, V>, Iterable<Map.Entry<K,V>> {

    public static final int DEFAULT_TABLE_SIZE = 32;
    public static final double DEFAULT_LOAD_FACTOR = 0.7f;
    private Node<K,V>[] table;
    private int size;
    private Set<K> keySet;
    private Collection<V> valueSet;
    private double loadFactor;


    public MyHashtable() {

        table = new Node[DEFAULT_TABLE_SIZE];
        keySet = new HashSet<>();
        valueSet = new HashSet<>();
        loadFactor = DEFAULT_LOAD_FACTOR;
    }

    public MyHashtable(int loadFactor) {

        this();
        this.loadFactor = loadFactor;
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

        return keySet.contains(key);
    }

    @Override
    public boolean containsValue(Object value) {

        return valueSet.contains(value);
    }

    @Override
    public V get(Object key) {

        Node node = table[numberForKey((K) key)];

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

        if (table[numberForKey(key)] == null) {
            table[numberForKey(key)] = new Node(key, value, null);
            size++;
            keySet.add(key);
            valueSet.add(value);
            if (getActualLoad() >= loadFactor) rehash();
            return null;
        }

        V valueToReturn = tryPut(table[numberForKey(key)], key, value);

        if (getActualLoad() >= loadFactor) rehash();

        return valueToReturn;
    }

    private double getActualLoad() {
        return (double) size / table.length;
    }


    private V tryPut(Node node, K key, V value) {

        if (node.key.equals(key)) {
            V valueToReturn = (V) node.value;
            valueSet.remove(node.value);
            valueSet.add(value);
            node.value = value;
            return valueToReturn;
        }

        if (node.next == null) {
            node.next = new Node(key, value, null);
            valueSet.add(value);
            keySet.add(key);
            size++;
            return null;
        }

        return tryPut(node.next, key, value);
    }

    private boolean rehash() {

        Set<Entry<K, V>> entrySet = entrySet();
        table = new Node[table.length * 2];

        for (Entry<K, V> entry : entrySet) {
            this.put(entry.getKey(), entry.getValue());
        }

        return true;
    }

    private int numberForKey(K key) {
        return Math.abs(key.hashCode() % table.length);
    }

    @Override
    public V remove(Object key) {

        V value;
        Node node = table[numberForKey((K) key)];

        if (node == null) return null;

        if (node.key.equals(key)) {
            value = (V) node.value;
            table[numberForKey((K) key)] = node.next;
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

    @Override
    public Iterator<Entry<K, V>> iterator() {
        return new MyHashMapIterator();
    }

    private class Node<K, V> implements Entry<K,V>{
        K key;
        V value;
        Node<K,V> next;

        public Node(K key, V value, Node<K,V> node) {
            this.key = key;
            this.value = value;
            this.next = node;
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
        public V setValue(V value) {
            return null;
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
        public V setValue(V value) {
            V tempValue = this.value;
            this.value = value;
            return tempValue;
        }
    }

    private class MyHashMapIterator implements Iterator<Entry<K, V>> {

        private Node<K, V> currentNode;
        private int currBucketIndex;

        public MyHashMapIterator() {

            if (!isEmpty()) {
                currBucketIndex = findFirstNotNull(0);
                currentNode = table[currBucketIndex];
            }

        }

        private int findFirstNotNull(int start){
            for (; start < table.length && table[start] == null; start++) {
            }
            return start;
        }

        @Override
        public boolean hasNext() {
            return currentNode != null;
        }

        @Override
        public Entry<K, V> next() {
            Node<K,V> forRet = currentNode;

            // find next current node
            if(forRet.next != null){
                currentNode = forRet.next;
            } else {
                int notNullIndex = findFirstNotNull(currBucketIndex + 1);
                if(notNullIndex == table.length){
                    currentNode = null;
                } else {
                    currBucketIndex = notNullIndex;
                    currentNode = table[currBucketIndex];
                }
            }

            return forRet;
        }
    }

}
