package algorithm;

public class String2Integer {
    public int myAtoi(String str) {
        if (null == str) {
            return 0;
        }
        str = str.trim();
        if (str.length() < 1) {
            return 0;
        }
        int isLt0 = 1;
        if (str.charAt(0) == '-') {
            isLt0 = -1;
            str = str.substring(1);
        } else if (str.charAt(0) == '+') {
            str = str.substring(1);
        }
        int i = 0;
        Long rs = 0L;
        while (i < str.length()) {
            char c = str.charAt(i++);
            if (c >= '0' && c <= '9') {
                rs = rs * 10 + (c - '0') * isLt0;
                if (rs > Integer.MAX_VALUE) {
                    rs = Integer.MAX_VALUE + 0L;
                    break;
                }
                if (rs < Integer.MIN_VALUE) {
                    rs = Integer.MIN_VALUE + 0L;
                    break;
                }
            } else {
                break;
            }
        }

        return rs.intValue();
    }

    public static void main(String[] args) {
        String2Integer test = new String2Integer();
        System.out.println(test.myAtoi("21123123191283472332"));
    }
}
