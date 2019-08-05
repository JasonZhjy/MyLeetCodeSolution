package 剑指Offer;

/**
 * 实现单例模式
 */
@SuppressWarnings("unused")
public class Case2 {

    private static volatile Case2 case2;

    private Case2() {
    }

    public static Case2 getInstance() {
        if (case2 == null) {
            synchronized (Case2.class) {
                if (case2 == null) {
                    case2 = new Case2();
                }
            }
        }

        return case2;
    }
}
