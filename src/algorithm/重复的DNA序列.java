package algorithm;

import java.util.*;

/**
 * LeetCode 187
 */
public class 重复的DNA序列 {
    public List<String> findRepeatedDnaSequences (String s) {

        List<String> rs = new ArrayList<>();
        final int len = 10;
        if (s == null || s.length() < len) {
            return null;
        }

        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i + len <= s.length(); i++) {
            String str = s.substring(i, i + len);
            map.put(str, map.getOrDefault(str, 0) + 1);
        }
        for (Map.Entry<String, Integer> e : map.entrySet()) {
            if (e.getValue() > 1) {
                rs.add(e.getKey());
            }
        }

        return rs;
    }

    public static void main (String[] args) {
        String s = "AAAAAAAAAAA";
        重复的DNA序列 obj = new 重复的DNA序列();
        List<String> rs = obj.findRepeatedDnaSequences(s);
        rs.forEach(System.out::println);
    }
}
