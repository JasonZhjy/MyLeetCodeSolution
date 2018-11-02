package algorithm;

/*
这道题是Jump Game的扩展，区别是这道题不仅要看能不能到达终点，而且要求到达终点的最少步数。
其实思路和Jump Game还是类似的，只是原来的全局最优现在要分成step步最优和step-1步最优（假设当前步数是step）。
当走到超过step-1步最远的位置时，说明step-1不能到达当前一步，
我们就可以更新步数，将step+1。时间复杂度仍然是O(n)，空间复杂度也是O(1)。代码如下：
---------------------
作者：Code_Ganker
来源：CSDN
原文：https://blog.csdn.net/linhuanmars/article/details/21356187
版权声明：本文为博主原创文章，转载请附上博文链接！
 */
public class JumpGame2 {
    public int jump (int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int reach = 0, lastReach = 0, step = 0;
        for (int i = 0; i < nums.length; i++) {
            if (i > lastReach) {
                step++;
                lastReach = reach;
            }
            reach = Math.max(reach, nums[i] + i);
        }

        if (reach < nums.length - 1) {
            return 0;
        }

        return step;
    }

    public static void main (String[] args) {
        int[] nums = {2, 3, 1, 1, 4};
        JumpGame2 test = new JumpGame2();
        System.out.println(test.jump(nums));
    }
}
