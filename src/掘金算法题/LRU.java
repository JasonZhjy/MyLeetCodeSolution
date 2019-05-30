package 掘金算法题;

import java.util.LinkedHashMap;
import java.util.Map;

public class LRU {
    private LinkedHashMap<Integer, Integer> map;

    private int capacity;

    public LRU () {
        capacity = 3;
        map = new LinkedHashMap<Integer, Integer>(capacity, 0.75f, true) {
            @Override
            protected boolean removeEldestEntry (Map.Entry eldest) {
                if (capacity + 1 == map.size()) {
                    return true;
                }
                return false;
            }
        };
    }

    public LRU (int capacity) {
        this.capacity = capacity;
        map = new LinkedHashMap<Integer, Integer>(capacity, 0.75f, true) {
            @Override
            protected boolean removeEldestEntry (Map.Entry eldest) {
                return capacity + 1 == map.size();
            }
        };
    }

    public void put (Integer key, Integer value) {
        map.put(key, value);
    }

    public Integer get (Integer key) {
        return map.get(key);
    }

    public static void main (String[] args) {
        LRU lru = new LRU(5);
//        System.out.println(lru.map.);

    }

}
