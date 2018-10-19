package algorithm;

import java.util.*;

/**
 * 30. 与所有单词相关联的字串
 */
public class 与所有单词相关联的字串 {

    public List<Integer> findSubstring (String s, String[] words) {
        List<Integer> rs = new ArrayList<>();
        if ("".equals(s) || null == s || words == null || words.length == 0) {
            return rs;
        }
        Map<String, Integer> wordMap = new HashMap<>();
        for (int i = 0; i < words.length; i++) {
            mapAdd(wordMap, words[i]);
        }

        int eachLen = words[0].length();
        int len = words.length * words[0].length();
        for (int i = 0; i <= s.length() - len; i++) {
            Map<String, Integer> containMap = new HashMap<>();
            String strLen = s.substring(i, i + len);
            int j;
            for (j = 0; j < len; j += eachLen) {
                String str = strLen.substring(j, j + eachLen);
                if (!wordMap.containsKey(str)) {
                    break;
                }
                mapAdd(containMap, str);
                if (containMap.get(str) > wordMap.get(str)) {
                    break;
                }
            }
            if (j == len) {
                rs.add(i);
            }
        }

        return rs;
    }

    private void mapAdd (Map<String, Integer> map, String key) {
        Integer count;
        if (map.containsKey(key)) {
            count = map.get(key);
            count++;
        } else {
            count = new Integer(1);
        }
        map.put(key, count);
    }

    public static void main (String[] args) {
        String s = "wordgoodgoodgoodbestword";
        String[] words = {"word","good","best","word"};
        与所有单词相关联的字串 test = new 与所有单词相关联的字串();

        List<Integer> list = test.findSubstring(s, words);
        System.out.println(list.size());
        list.forEach(System.out::println);

    }
}
