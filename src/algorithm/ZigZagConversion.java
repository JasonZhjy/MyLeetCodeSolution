package algorithm;

public class ZigZagConversion {
    public String convert(String s, int numRows) {
        if (null == s || s.length() == 1 || numRows == 1) {
            return s;
        }
        StringBuilder sb = new StringBuilder();
        int len = s.length();
        int step = 2 * numRows - 2;

        for (int i = 0; i < numRows; i++) {
            for (int j = i; j < len; j += step) {
                sb.append(s.charAt(j));
                if (i != 0 && i != numRows - 1) {
                    int temp = j + step - 2 * i;
                    if (temp < len) {
                        sb.append(s.charAt(temp));
                    }
                }
            }
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        ZigZagConversion test = new ZigZagConversion();
        System.out.println(test.convert("PAYPALISHIRING", 3));
    }
}
