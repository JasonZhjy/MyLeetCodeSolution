package mytest;

import java.math.BigDecimal;

public class IntegerPrase {
    public static void main (String[] args) {
        String str = "25.00";

        int amount = new BigDecimal(str).multiply(new BigDecimal(100)).intValue();

        System.out.println(amount);
    }
}
