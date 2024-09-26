
//https://leetcode.com/problems/palindrome-partitioning/description/


import java.util.ArrayList;
import java.util.List;

public class PalindromePartitioning {
    List<List<String>> result = new ArrayList<>();
    long[] array;
    long[] degree;
    long[] reverse;
    long remains = (int) Math.pow(10, 9) + 7;//делитель

    public List<List<String>> partition(String s) {


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



        backtracking(new ArrayList<>(),s, 0);

        return result;
    }



    public void backtracking(List<String> list, String str, int index){
        if(index>=str.length()){
            result.add(new ArrayList<>(list));
            return;
        }

        for (int i = index; i < str.length() ; i++) {
            if(isPalindrome(index, i,str)){
                list.add(str.substring(index,i+1));
                backtracking(list,str,i+1);
                list.remove(list.size()-1);
            }
        }



    }


    public boolean isPalindrome(int i, int j, String str){
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

}
