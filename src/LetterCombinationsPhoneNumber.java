
//https://leetcode.com/problems/letter-combinations-of-a-phone-number/description/


import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class LetterCombinationsPhoneNumber {
    List<String> result = new ArrayList<>();
    HashMap<Character, char[]> map = new HashMap<>();
    public List<String> letterCombinations(String digits) {

        if(digits.length() == 0)
            return result;

        map.put('2',"abc".toCharArray());
        map.put('3',"def".toCharArray());
        map.put('4',"ghi".toCharArray());
        map.put('5',"jkl".toCharArray());
        map.put('6',"mno".toCharArray());
        map.put('7',"pqrs".toCharArray());
        map.put('8',"tuv".toCharArray());
        map.put('9',"wxyz".toCharArray());

        backtracking(new StringBuilder(), digits,0);



        return result;

    }

    public void backtracking(StringBuilder str, String digits, int index){
        if(str.length()==digits.length()){
            result.add(str.toString());
            return;
        }

        for (char c: map.get(digits.charAt(index))) {
            str.append(c);
            backtracking(str,digits,index+1);
            str.setLength(str.length()-1);
        }




    }

    public static void main(String[] args) {
        LetterCombinationsPhoneNumber l = new LetterCombinationsPhoneNumber();
        l.letterCombinations("23");
        System.out.println(l.result);
    }

}
