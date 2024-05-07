
//https://leetcode.com/problems/climbing-stairs/description/
public class ClimbingStairs {
    public int climbStairs(int n) {
        int a = 1;
        int b = 1;
        //Fibonacci Numbers
        for (int i = 2; i <= n ; i++) {
            int c = a+b;
            a = b;
            b = c;
        }
        return b;
    }
}
