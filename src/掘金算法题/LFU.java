package 掘金算法题;

import java.util.Map;
import java.util.PriorityQueue;

/**
 * 设计并实现最不经常使用（LFU）缓存的数据结构。它应该支持以下操作：get 和 put。
 * get(key) - 如果键存在于缓存中，则获取键的值（总是正数），否则返回 -1。
 * put(key, value) - 如果键不存在，请设置或插入值。当缓存达到其容量时，它应该在插入新项目之前，
 * 使最不经常使用的项目无效。在此问题中，当存在平局（即两个或更多个键具有相同使用频率）时，
 * 最近最少使用的键将被去除。
 * 进阶：
 * 你是否可以在 O(1) 时间复杂度内执行两项操作？
 */
public class LFU {

    PriorityQueue<Map.Entry<Integer, Long>> queue = new PriorityQueue<>();


//todo
    public static void main (String[] args) {

    }
}
