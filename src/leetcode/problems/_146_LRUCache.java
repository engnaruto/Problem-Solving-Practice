package leetcode.problems;


import java.util.HashMap;

/*
    Design and implement a data structure for Least Recently Used (LRU) cache. It should support
    the following operations: get and put.

    get(key) - Get the value (will always be positive) of the key if the key exists in the cache, otherwise return -1.
    put(key, value) - Set or insert the value if the key is not already present. When the cache reached its capacity,
    it should invalidate the least recently used item before inserting a new item.

    Follow up:
    Could you do both operations in O(1) time complexity?

    Example:

    LRUCache cache = new LRUCache( 2 / capacity / );

            cache.put(1, 1);
            cache.put(2, 2);
            cache.get(1);       // returns 1
            cache.put(3, 3);    // evicts key 2
            cache.get(2);       // returns -1 (not found)
            cache.put(4, 4);    // evicts key 1
            cache.get(1);       // returns -1 (not found)
            cache.get(3);       // returns 3
            cache.get(4);       // returns 4
*/


class LRUCache {

    public static class DoubleLinkedList {
        Node head;
        Node tail;

        public DoubleLinkedList() {

        }

        public void addToHead(Node n) {
            if (head == null) {
                head = n;
                tail = head;
            } else {
                head.next = n;
                head.next.prev = head;
                head = head.next;
            }
        }

        public void moveToHead(Node n) {
            if (n == head) {
                return;
            } else if (n == tail) {
                tail = tail.next;
                if (tail == null) {
                    tail = head;
                } else {
                    tail.prev = null;
                }
            } else {
                n.prev.next = n.next;
                n.next.prev = n.prev;
            }
            n.next = null;
            n.prev = head;
            head.next = n;
            head = head.next;
        }

        public void remove(Node n) {
            moveToHead(n);
            head = head.prev;
            n.prev = null;
            head.next = null;
        }

        public int removeTail() {
            int key = -1;
            if (tail == null) {
                return key;
            }
            if (tail == head) {
                key = tail.key;
                tail = null;
                head = null;
            } else {
                key = tail.key;
                tail = tail.next;
                tail.prev.next = null;
                tail.prev = null;
            }
            return key;
        }

        public static class Node {

            Node prev;
            Node next;

            int key;
            int value;

            public Node(int key, int value) {
                this.key = key;
                this.value = value;
            }

            @Override
            public boolean equals(Object obj) {
                return this.key == ((Node) obj).key;
            }
        }
    }

    DoubleLinkedList list;
    HashMap<Integer, DoubleLinkedList.Node> map;
    int capacity;

    public LRUCache(int capacity) {
        list = new DoubleLinkedList();
        map = new HashMap<>();
        this.capacity = capacity;
    }

    /*
        Time: O(1)
    */

    public int get(int key) {
        if (map.containsKey(key)) {
            list.moveToHead(map.get(key));
            return map.get(key).value;
        }
        return -1;
    }

    /*
        Time: O(1)
    */

    public void put(int key, int value) {
        if (map.containsKey(key)) {
            map.get(key).value = value;
            list.moveToHead(map.get(key));
        } else {
            DoubleLinkedList.Node node = new DoubleLinkedList.Node(key, value);
            if (capacity <= map.size()) {
                int val = list.removeTail();
                map.remove(val);
            }
            list.addToHead(node);
            map.put(key, node);
        }
    }
}


public class _146_LRUCache {

    /**
     * Your LRUCache object will be instantiated and called as such:
     * LRUCache obj = new LRUCache(capacity);
     * int param_1 = obj.get(key);
     * obj.put(key,value);
     */

    public static void main(String[] args) {

//        LRUCache cache = new LRUCache( 2 /* capacity */ );
//
//        cache.put(1, 1);
//        cache.put(2, 2);
//        System.out.println(cache.get(1));       // returns 1
//        cache.put(3, 3);                        // evicts key 2
//        System.out.println(cache.get(2));       // returns -1 (not found)
//        cache.put(4, 4);                        // evicts key 1
//        System.out.println(cache.get(1));       // returns -1 (not found)
//        System.out.println(cache.get(3));       // returns 3
//        System.out.println(cache.get(4));       // returns 4


        LRUCache cache = new LRUCache(1 /* capacity */);

        cache.put(2, 1);
        System.out.println(cache.get(2));       // returns 1
        cache.put(3, 2);                        // evicts key 2
        System.out.println(cache.get(2));       // returns -1 (not found)
        System.out.println(cache.get(3));       // returns 2
    }
}
