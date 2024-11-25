
//https://leetcode.com/problems/valid-palindrome/description/


public class ValidPalindrome {
    public boolean isPalindrome(String s) {
        s = s.toLowerCase();
        int start = 0;
        int end = s.length() - 1;

        while (start < s.length() && end >= 0) {
            while (start < s.length() && !isAlphanumeric(s.charAt(start)))
                start++;
            while (end >= 0 && !isAlphanumeric(s.charAt(end)))
                end--;

            if (start < s.length() && end >= 0 && s.charAt(start) != s.charAt(end)) {
                return false;
            }
            start++;
            end--;


        }

        return true;
    }


    public boolean isAlphanumeric(char c) {
        if (c >= 'a' && c <= 'z' || c >= '0' && c <= '9') {
            return true;
        }
        return false;

    }

}
