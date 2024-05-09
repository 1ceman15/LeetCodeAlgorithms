
//https://leetcode.com/problems/find-smallest-letter-greater-than-target/description/
public class SmallestLetterGreaterThanTarget {
    public char nextGreatestLetter(char[] letters, char target) {
        int left = 0;
        int right = letters.length-1;

        char answer = letters[0];

        while (left<=right){
            int middle = (left+right)/2;
            if(letters[middle] > target){
                answer = letters[middle];
                right = middle-1;
            }
            else
                left = middle+1;
        }


        return answer;
    }
}
