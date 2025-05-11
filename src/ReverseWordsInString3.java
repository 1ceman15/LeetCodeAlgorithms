
//https://leetcode.com/problems/reverse-words-in-a-string-iii/description/

public class ReverseWordsInString3 {
    public static String reverseWords(String s) {
        String[] words = s.split(" ");

        StringBuilder reversed = new StringBuilder();
        for(String word: words) {
            reversed.append(new StringBuilder(word).reverse());
            reversed.append(" ");

        }

        reversed.setLength(reversed.length() -1 );

        return reversed.toString();
    }

}
