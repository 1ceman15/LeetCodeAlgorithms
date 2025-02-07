
//https://leetcode.com/problems/lru-cache/

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

//Также можно решить без использования встроенных структур данных
//Путем написания собственного класса для DoubleLinkedList
//и хранения последнего и первого указателя


//public class LRUCache {
//
//    int capacity;
//    LinkedHashMap<Integer, Integer> hm;
//
//    public LRUCache(int capacity) {
//        this.capacity = capacity;
//        hm = new LinkedHashMap<>(capacity, 0.75f, true) {
//            @Override
//            protected boolean removeEldestEntry(Map.Entry<Integer, Integer> eldest) {
//                return size() > capacity;
//            }
//        };
//
//    }
//
//    public int get(int key) {
//        return hm.getOrDefault(key,-1);
//    }
//
//    public void put(int key, int value) {
//        hm.put(key, value);
//    }
//}




public class LRUCache {

    class Node{
        int key;
        int val;
        Node prev;
        Node next;

        Node(int key, int val){
            this.key = key;
            this.val = val;
        }

    }

    int capacity;
    HashMap<Integer, Node> cache;
    Node left;
    Node right;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.left = new Node(0,0);
        this.right = new Node(0,0);

        this.left.next = right;
        this.right.prev = left;

        this.cache = new HashMap<>();

    }

    public int get(int key){
        if(cache.containsKey(key)){
            remove(cache.get(key));
            insert(cache.get(key));
            return cache.get(key).val;
        }
        return -1;
    }

    public void put(int key, int value) {
        if(cache.containsKey(key)){
            remove(cache.get(key));
        }
        Node node = new Node(key,value);
        cache.put(key,node);
        insert(node);

        if(cache.size() > capacity){
            Node lru = this.left.next;
            remove(lru);
            cache.remove(lru.key);
        }

    }


    private void remove(Node node){
        Node prev = node.prev;
        Node next = node.next;
        prev.next = next;
        next.prev = prev;
    }


    private void insert(Node node){
        Node prev = this.right.prev;
        prev.next = node;
        node.prev = prev;
        node.next = this.right;
        this.right.prev = node;
    }


}