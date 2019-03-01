package algorithm;

public class JumpGame {

    public boolean canJump(int[] nums) {
        int global = 0;
        for (int i = 0; i < nums.length; i++) {
            if (global >= i) {
                global = Math.max(global, nums[i] + i);
            }
        }

        if (global >= nums.length - 1) {
            return true;
        }

        return false;
    }

    public static void main (String[] args) {
    }
}
