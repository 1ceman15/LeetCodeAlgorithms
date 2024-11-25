
//https://leetcode.com/problems/length-of-last-word/description/?envType=problem-list-v2&envId=string

public class LengthOfLastWord {
    public static int lengthOfLastWord(String s) {
        int length = 0;
        int answer = 0;

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) != ' ') {
                length++;
                answer = length;
            } else {
                while (i < s.length() && s.charAt(i) == ' ') {
                    i++;
                }
                i--;
                length = 0;
            }
        }


        return answer;
    }
}
