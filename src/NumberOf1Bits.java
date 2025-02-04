public class NumberOf1Bits {
    public int hammingWeight(int n) {
        int answer = 0;

        for (int i = 0; i < 32; i++) {
            int bit = (n >> i) & 1;
            if(bit == 1) answer++;
        }

        return answer;
    }
}
