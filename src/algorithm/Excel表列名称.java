package algorithm;

/**
 * LeetCode 168.
 */
public class Excel表列名称 {

    public String convertToTitle (int n) {
        StringBuilder sb = new StringBuilder();

        while (n != 0) {
            int k = (n - 1) % 26; //0-25
            char val = (char) ('A' + k);
            sb.append(val);
            n = (n - 1) / 26;
        }


        return sb.reverse().toString();
    }

    public static void main (String[] args) {
        Excel表列名称 test = new Excel表列名称();

        System.out.println(test.convertToTitle(52));
    }
}
