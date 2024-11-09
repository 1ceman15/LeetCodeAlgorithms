
//https://leetcode.com/problems/longest-common-prefix/description/?envType=problem-list-v2&envId=string

import java.util.Arrays;

public class LongestCommonPrefix {
    public String longestCommonPrefix(String[] strs) {

        StringBuilder prefix = new StringBuilder();

        int last = strs.length-1;

        Arrays.sort(strs);

        int index = 0;
        for (int i = 0; i < Math.min(strs[0].length(), strs[last].length()); i++) {
            if(strs[0].charAt(i) == strs[last].charAt(i)) {
                prefix.append(strs[last].charAt(i));
            }else return prefix.toString();
        }

        return prefix.toString();
    }


}
