import java.util.Arrays;

//https://leetcode.com/problems/distinct-subsequences/description/
public class DistinctSubsequences {

    int[][] dp;
    public int numDistinct(String s, String t) {
        dp = new int[s.length()][t.length()];

        for (int i = 0; i < s.length(); i++) {
            Arrays.fill(dp[i],-1);
        }


        return dfs(s,t,0,0);
    }

    public int dfs(String s, String t, int i, int j){
        if(j == t.length())
            return 1;
        if(i == s.length())
            return 0;

        if(dp[i][j] != -1)
            return dp[i][j];

        if(s.charAt(i) == t.charAt(j)){
            dp[i][j] = dfs(s,t,i+1,j+1) + dfs(s,t, i+1,j);

        }else  dp[i][j] = dfs(s,t,i+1,j);

        return dp[i][j];
    }

}
