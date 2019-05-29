package mytest;

        import java.util.Arrays;

public class ThreadTest {

    public static void main (String[] args) {
        int[] arr = new int[2];


        int[] as = Arrays.copyOf(arr, 2);
        int[] as2 = Arrays.copyOf(arr, 2);
        as2 = Arrays.copyOf(arr, 2);
        as = Arrays.copyOf(arr, 2);
        System.out.println(111);
    }

}
