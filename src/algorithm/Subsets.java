package algorithm;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
78.
 */
public class Subsets {
    public List<List<Integer>> subsets (int[] nums) {
        List<List<Integer>> rs = new ArrayList<>();
        Arrays.sort(nums);
        List<Integer> item = new ArrayList<>();
        dfs(nums, 0, rs, item);

        return rs;
    }

    public void dfs (int[] nums, int k, List<List<Integer>> rs, List item) {
        if (k == nums.length) {
            rs.add(new ArrayList<>(item));
            return;
        }

        item.add(nums[k]);
        dfs(nums, k + 1, rs, item);
        item.remove((Integer) nums[k]);
        dfs(nums, k + 1, rs, item);
    }

    public static void main (String[] args) {
        Subsets subsets = new Subsets();
        int[] nums = {1, 2, 3};
        List<List<Integer>> rs = subsets.subsets(nums);
        rs.forEach(list -> {
            list.forEach(item -> System.out.print(item + " "));
            System.out.println();
        });
        System.out.println("size: " + rs.size());
    }
}
