
//https://leetcode.com/problems/palindromic-substrings/


public class PalindromicSubstrings {
    long[] array;
    long[] degree;
    long[] reverse;//массив, который хранит хеши перевернутой строки


    long remains = (int) Math.pow(10, 9) + 13;//делитель

    public int countSubstrings(String s) {
        int answer = s.length();


        array = new long[s.length()];
        reverse = new long[s.length()];
        degree = new long[s.length()];

        degree[0] = 1;
        long x = 257;
        array[0] = (long) s.charAt(0) % remains;
        int reverseIndex = s.length() - 1;
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
            //Нечетная длинна
            int HalfLen = Math.min(i, s.length() - i - 1);
            int left = 0;
            int right = HalfLen;
            int mid = right;
            while (left <= right) {
                int start = i - mid;
                int end = i + mid;
                if (isPalindrome(s, start, end)) {
                    left = mid + 1;
                    HalfLen = mid;
                } else right = mid - 1;
                mid = (left + right) / 2;

            }
            answer += HalfLen;


            //Четная длинна
            HalfLen = Math.min(i, s.length() - i);
            left = 0;
            right = HalfLen;
            mid = right;
            while (left <= right) {
                int start = i - mid;
                int end = i + mid - 1 >= 0 ? i + mid - 1 : 0;
                if (isPalindrome(s, start, end)) {
                    left = mid + 1;
                    HalfLen = mid;
                } else right = mid - 1;
                mid = (left + right) / 2;

            }
            answer += HalfLen;


        }


        return answer;

    }


    public boolean isPalindrome(String str, int i, int j) {
        if (i == j)
            return true;
        int len = j - i + 1;
        int beginIndexR = str.length() - j - 1;
        int endIndexR = beginIndexR + len - 1;


        if (beginIndexR > 0 && i > 0)
            return (array[j] + (reverse[beginIndexR - 1] * degree[len])) % remains == (reverse[endIndexR] + array[i - 1] * degree[len]) % remains;
        else {
            if (beginIndexR == 0 && i == 0)
                return array[j] % remains == reverse[endIndexR] % remains;
            else if (beginIndexR == 0)
                return array[j] % remains == (reverse[endIndexR] + array[i - 1] * degree[len]) % remains;
            else
                return (array[j] + (reverse[beginIndexR - 1] * degree[len])) % remains == reverse[endIndexR] % remains;

        }


    }

}
