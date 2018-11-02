package mytest;

import java.util.concurrent.ConcurrentHashMap;

public class ThreadTest {

    public static void main (String[] args) {
        Thread t = new Thread(() -> {
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        t.start();
        for (int i = 0; i < 5000; i++) {
            System.out.println(t.getState());
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }
}
