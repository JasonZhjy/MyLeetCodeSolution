package lock;

import com.sun.org.apache.xpath.internal.operations.Bool;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

/**
 * 银行家算法 - 避免死锁
 */
public class YinHangJia {

    private transient int work = 100;

    private boolean checkSafe(List<Integer> needs) {
        Boolean[] finished = new Boolean[needs.size()];
        Arrays.fill(finished, Boolean.FALSE);

        while(true) {
            boolean isChange = false;
            for (int i = 0; i < needs.size(); i++) {
                if (needs.get(i) < work && !finished[i]) {
                    isChange = true;
                    work += needs.get(i);
                    finished[i] = true;
                }
            }
            if (!isChange) {
                break;
            }
        }
        Optional<Boolean> boo =  Arrays.stream(finished).filter(b -> !b).findFirst();

        return !boo.isPresent();
    }
}
