package src;

import java.util.*;

public class LRUCache {

    public int capacity,size;

    class Node {
        int key;
        int data;
        Node next;
        Node prev;
        public Node(int key, int data) {
            this.data = data;
            this.key = key;
        }
        public Node(){}
    }

    private HashMap<Integer, Node> map;
    private Node head, tail;

    public LRUCache(int capacity) {

        map = new HashMap<Integer, Node>();
        head = new Node();
        tail = new Node();
        head.next = tail;
        tail.prev = head;
        this.capacity = capacity;
        size = 0;
    }

    public void makeRecent(Node t) {
        t.prev.next = t.next;
        t.next.prev = t.prev;
        t.next = tail;
        t.prev = tail.prev;
        tail.prev.next = t;
        tail.prev = t;
    }

    public int removeLru() {
        Node t = head.next;
        head.next = t.next;
        t.next.prev = head;
        t.next = null;
        t.prev = null;
        return t.key;
    }

    public void insertRecent(Node t) {
        t.next = tail;
        t.prev = tail.prev;
        tail.prev.next = t;
        tail.prev = t;
    }

    public int get(int key) {
        if (!(map.containsKey(key))) return -1;
        Node t = map.get(key);
        makeRecent(t);
        return t.data;

    }

    public void put(int key, int value) {
        if(map.containsKey(key)) {
            Node temp = map.get(key);
            temp.data = value;
            makeRecent(temp);
            //map.put(key,temp);
        }
        else if (size >= capacity) {
            map.remove(removeLru());
            insertRecent(new Node(key, value));
            map.put(key,tail.prev);
        }
        else {
            insertRecent(new Node(key, value));
            map.put(key,tail.prev);
            ++size;
        }
    }
}

/**
 * Your LRUCache objecyt will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
