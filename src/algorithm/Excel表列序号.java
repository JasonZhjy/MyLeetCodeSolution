package algorithm;

/**
 * 171. LeetCode
 */
public class Excel表列序号 {

    public int titleToNumber (String s) {
        int rs = 0;
        char[] cs = s.toCharArray();
        for (int i = cs.length - 1; i >= 0; i--) {
            int val = cs[i] - 'A' + 1;
            val  *= (int) Math.pow(26, cs.length - 1 - i);
            rs += val;
        }
        return rs;
    }

    public static void main (String[] args) {
        Excel表列序号 test = new Excel表列序号();
        System.out.println(test.titleToNumber("AA"));
    }
}
