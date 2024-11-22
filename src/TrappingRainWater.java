
//https://leetcode.com/problems/trapping-rain-water/description/

public class TrappingRainWater {
    public int trap(int[] height) {
        int result = 0;

        int left = 0;
        int right = height.length - 1;
        int maxLeft = height[left];
        int maxRight = height[right];
        while (left < right) {
            if(maxLeft < maxRight) {
                left++;
                maxLeft = Math.max(maxLeft, height[left]);
                result += maxLeft - height[left];
            }else {
                right--;
                maxRight = Math.max(maxRight, height[right]);
                result += maxRight - height[right];
            }

        }

        return result;
    }
}
