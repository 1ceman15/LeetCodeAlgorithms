
//    public boolean isHappy(int n) {
//
//    }

import java.util.HashSet;

public class HappyNumber {
    public boolean isHappy(int n) {
        HashSet<Integer> set = new HashSet<>();

        while (!set.contains(n)){
            set.add(n);
            n = sumOfSquares(n);
            if(n == 1)
                return true;
        }


        return false;
    }


    private int sumOfSquares(int n) {
        int output = 0;

        while (n > 0) {
            int digit = n % 10;
            digit = digit * digit;
            output += digit;
            n /= 10;
        }
        return output;
    }



//    public boolean isHappy(int n) {
//        int slow = n, fast = sumOfSquares(n);
//
//        while (slow != fast) {
//            fast = sumOfSquares(fast);
//            fast = sumOfSquares(fast);
//            slow = sumOfSquares(slow);
//        }
//
//        return fast == 1;
//    }
//
//    private int sumOfSquares(int n) {
//        int output = 0;
//        while (n != 0) {
//            output += (n % 10) * (n % 10);
//            n /= 10;
//        }
//        return output;
//    }
}
