
//https://leetcode.com/problems/container-with-most-water/description/?envType=problem-list-v2&envId=array

public class ContainerWithMostWater {
    public int maxArea(int[] height) {

        int answer = 0;
        int len = height.length-1;
        int left = 0;
        int right = len;

        while(left < right){
            answer = Math.max(answer, Math.min(height[left], height[right]) * len);
            if(height[left] < height[right]){
                left++;
            }else right--;

            len--;

        }


        return answer;
    }

}
