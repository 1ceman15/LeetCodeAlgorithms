
//https://leetcode.com/problems/interleaving-string/description/

public class InterleavingString {
    Boolean[][] dp;

    public boolean isInterleave(String s1, String s2, String s3) {
//
//        int m = s1.length(), n = s2.length();
//        if (m + n != s3.length()) {
//            return false;
//        }
//
//        boolean[][] dp = new boolean[m + 1][n + 1];
//        dp[m][n] = true;
//
//        for (int i = m; i >= 0; i--) {
//            for (int j = n; j >= 0; j--) {
//                if (i < m && s1.charAt(i) == s3.charAt(i + j) && dp[i + 1][j]) {
//                    dp[i][j] = true;
//                }
//                if (j < n && s2.charAt(j) == s3.charAt(i + j) && dp[i][j + 1]) {
//                    dp[i][j] = true;
//                }
//            }
//        }
//        return dp[0][0];
//



        if (s1.length() + s2.length() != s3.length())
            return false;
        dp = new Boolean[s1.length() + 1][s2.length() + 1];
        return dfs(s1, s2, s3, 0, 0, 0);
    }


    public boolean dfs(String s1, String s2, String s3, int i, int j, int k) {
        if (k == s3.length())
            return (i == s1.length() && j == s2.length());
        if (dp[i][j] != null)
            return dp[i][j];


        boolean res = false;
        if (i < s1.length() && s1.charAt(i) == s3.charAt(k))
            res = dfs(s1, s2, s3, i + 1, j, k + 1) ;
        if (!res && j < s2.length() && s2.charAt(j) == s3.charAt(k))
            res =  dfs(s1, s2, s3, i, j + 1, k + 1);

        return dp[i][j] = res;

    }
}
