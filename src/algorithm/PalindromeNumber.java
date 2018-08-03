package algorithm;

public class PalindromeNumber {
    public boolean isPalindrome(int x) {
        return isPalindrome(String.valueOf(x));
    }

    public boolean isPalindrome(String s) {
        String s1 = new StringBuilder(s).reverse().toString();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) != s1.charAt(i)) {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        PalindromeNumber test = new PalindromeNumber();
        System.out.println(test.isPalindrome(10));
    }
}
