
//https://leetcode.com/problems/decode-ways/description/


import java.util.Arrays;

public class DecodeWays {

    int[] dp;

    public int numDecodings(String s) {
        dp = new int[s.length()];
        Arrays.fill(dp, -1);


        return dfs(s,0);
    }

    public int dfs(String s, int index){
        if(index == s.length())
            return 1;
        if(s.charAt(index) == '0')
            return 0;
        if(dp[index]!=-1)
            return dp[index];

        int res = dfs(s, index+1);
        if(index+1<s.length() && ('1' == s.charAt(index) || ('2' == s.charAt(index)  && s.charAt(index+1) <= '6')) ){
            res+= dfs(s,index+2);
        }

        return dp[index] = res;




    }

}
