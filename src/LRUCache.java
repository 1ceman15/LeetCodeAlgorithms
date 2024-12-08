
//https://leetcode.com/problems/lru-cache/

import java.util.LinkedHashMap;
import java.util.Map;

//Также можно решить без использования встроенных структур данных
//Путем написания собственного класса для DoubleLinkedList
//и хранения последнего и первого указателя
public class LRUCache {

    int capacity;
    LinkedHashMap<Integer, Integer> hm;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        hm = new LinkedHashMap<>(capacity, 0.75f, true) {
            @Override
            protected boolean removeEldestEntry(Map.Entry<Integer, Integer> eldest) {
                return size() > capacity;
            }
        };

    }

    public int get(int key) {
        return hm.getOrDefault(key,-1);
    }

    public void put(int key, int value) {
        hm.put(key, value);
    }
}
