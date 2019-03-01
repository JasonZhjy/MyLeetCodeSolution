package rcAlgorithm.LinkedList;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ThreadPoolExecutor;

public class BST2LinkedList {



    public static void print (String word) {
        word = "Hey!";
        System.out.print(word + ":");
    }

    public static void main (String[] args) {
        Father obj = new Sun();
        obj.fun();
    }


}

class Father {
    public static void fun () {
        System.out.println("father fun");
    }
}

class Sun extends Father {
    public static void fun () {
        System.out.println("father fun");
    }
}
