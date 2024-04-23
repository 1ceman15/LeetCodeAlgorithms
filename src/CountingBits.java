
//https://leetcode.com/problems/counting-bits/

public class CountingBits {
    public int[] countBits(int n) {
        int[] array = new int[n+1];
        array[0] = 0;
        int offset = 1;
        for (int i = 1; i <= n ; i++) {
            if(i == offset*2)
                offset*=2;
            array[i] = 1 + array[i-offset];
        }
        return array;

    }
}
