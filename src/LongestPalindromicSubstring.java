
//https://leetcode.com/problems/longest-palindromic-substring/description/

import java.util.ArrayList;
import java.util.List;

public class LongestPalindromicSubstring {
    List<List<String>> result = new ArrayList<>();
    long[] array;
    long[] degree;
    long[] reverse;
    long remains = (int) Math.pow(10, 9) + 7;//делитель
    String answer = "";

    //Решение через хеширование
    public String longestPalindrome(String s) {

        array = new long[s.length()];
        reverse = new long[s.length()];
        degree = new long[s.length()];

        degree[0] = 1;
        long x = 257;
        array[0] = (long) s.charAt(0) % remains;
        int reverseIndex = s.length()-1;
        reverse[0] = (long) s.charAt(reverseIndex) % remains;
        reverseIndex--;

        //Хеширование строки и запись степеней x
        for (int i = 1; i < s.length(); i++) {

            degree[i] = (degree[i - 1] * x) % remains;
            array[i] = (array[i - 1] * x + (long) (s.charAt(i))) % remains;
            reverse[i] = (reverse[i - 1] * x + (long) s.charAt(reverseIndex)) % remains;
            reverseIndex--;
        }


        for (int i = 0; i < s.length(); i++) {
            for (int j = s.length()-1; j >= i ; j--) {
                if(j-i+1<answer.length())
                    break;
                if(isPalindrome(s,i,j)){
                    if(j-i+1>answer.length())
                        answer = s.substring(i,j+1);
                }
            }
        }


        return answer;
    }

    public boolean isPalindrome(String str,int i, int j){
        if(i==j)
            return true;
        int len = j-i+1;
        int beginIndexR = str.length()-j-1;
        int endIndexR = beginIndexR + len -1;



        if(beginIndexR>0 && i>0)
            return (array[j] + (reverse[beginIndexR-1] * degree[len]))%remains == (reverse[endIndexR] + array[i-1] * degree[len])%remains;
        else {
            if(beginIndexR==0 && i==0)
                return array[j] %remains == reverse[endIndexR] %remains;
            else if(beginIndexR==0)
                return array[j]  %remains == (reverse[endIndexR] + array[i-1] * degree[len])%remains;
            else
                return (array[j] + (reverse[beginIndexR-1] * degree[len]))%remains == reverse[endIndexR] %remains;

        }


    }




    public String longestPalindrome2(String s) {
        if (s.length() <= 1) {
            return s;
        }

        String maxStr = s.substring(0, 1);

        for (int i = 0; i < s.length() - 1; i++) {
            String odd = expandFromCenter(s, i, i);
            String even = expandFromCenter(s, i, i + 1);

            if (odd.length() > maxStr.length()) {
                maxStr = odd;
            }
            if (even.length() > maxStr.length()) {
                maxStr = even;
            }
        }

        return maxStr;
    }

    private String expandFromCenter(String s, int left, int right) {
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
        }
        return s.substring(left + 1, right);
    }
}
