package rcAlgorithm;

import java.util.*;

/**
 * 输入一个字符串，输出字符串中字符的全排列
 */
public class 字符全排列 {
    public List<String> getAllList (String s) {
        List<String> chars = Arrays.asList(s.split(""));
        List<String> list = new ArrayList<>();

        chars.forEach(st -> {
            List<String> rs1 = new ArrayList<>();
            if (list.isEmpty()) {
                list.add(st);
            } else {
                list.forEach(str -> {
                    for (int i = 0; i <= str.length(); i++) {
                        String ss = str.substring(0, i) + st + str.substring(i, str.length());
                        rs1.add(ss);
                    }
                });
                list.clear();
                list.addAll(rs1);
            }
        });

        return list;
    }

    public static void main (String[] args) {
        字符全排列 test = new 字符全排列();

        String s = "abcd";

        List<String> list = test.getAllList(s);
        list.forEach(System.out::println);
        System.out.println("size: " + list.size());
    }
}
