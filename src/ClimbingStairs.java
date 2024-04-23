
//https://leetcode.com/problems/climbing-stairs/description/
public class ClimbingStairs {
    public int climbStairs(int n) {
        int a = 1;
        int b = 2;
        for (int i = 3; i <= n ; i++) {
            int c = a+b;
            a = b;
            b = c;
        }
        return b;
    }
}
