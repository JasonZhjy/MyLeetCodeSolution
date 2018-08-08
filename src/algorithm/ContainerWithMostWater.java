package algorithm;

/**
 * 本来想使用双指针指向中间位置，向两边扩展的方法， 后来发现不可行
 */
public class ContainerWithMostWater {
    public int maxArea(int[] height) {
        int leftIdx = 0, rightIdx = height.length - 1;
        int maxArea = 0;
        while(leftIdx < rightIdx) {
            int subMaxArea = (rightIdx - leftIdx) * Math.min(height[rightIdx], height[leftIdx]);
            maxArea = subMaxArea > maxArea ? subMaxArea : maxArea;
            if (height[leftIdx] < height[rightIdx]) {
                leftIdx++;
            } else {
                rightIdx--;
            }
        }

        return maxArea;
    }

    public static void main(String[] args) {
        ContainerWithMostWater test = new ContainerWithMostWater();
        int[] height = {1, 8, 6, 2, 5, 4, 8, 3, 7};
        System.out.println(test.maxArea(height));
    }
}
