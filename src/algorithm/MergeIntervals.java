package algorithm;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 56.
 */
public class MergeIntervals {

    public List<Interval> merge (List<Interval> intervals) {

        List<Interval> list = intervals.stream().sorted(Comparator.comparing(v -> ((Interval) v).start)
                .thenComparing(v -> ((Interval) v).end))
                .collect(Collectors.toList());

        List<Interval> rs = new ArrayList<>();
        Interval pre = null;
        for (Interval interval : list) {
            if (pre == null) {
                pre = interval;
            } else if (pre.end < interval.start) {
                rs.add(pre);
                pre = interval;
            } else if (pre.end >= interval.start) {
                pre.end = Math.max(interval.end, pre.end);
            }
        }
        if (pre != null) {
            rs.add(pre);
        }

        return rs;
    }

    public static void main (String[] args) {
        List<Interval> list = new ArrayList<>();
        list.add(new Interval(1, 4));
        list.add(new Interval(2, 3));
//        list.add(new Interval(8,10));
//        list.add(new Interval(15,18));

        MergeIntervals test = new MergeIntervals();
        List<Interval> rs = test.merge(list);

        for (Interval r : rs) {
            System.out.println(r.start + ": " + r.end);
        }
    }

    public static class Interval {
        public int start;
        public int end;

        Interval () {
            start = 0;
            end = 0;
        }

        Interval (int s, int e) {
            start = s;
            end = e;
        }
    }
}
