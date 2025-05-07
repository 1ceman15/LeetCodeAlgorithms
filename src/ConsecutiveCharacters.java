public class ConsecutiveCharacters {

    public int maxPower(String s) {
        int maxPower = 1;
        int power = 1;

        for (int i = 1; i < s.length(); i++) {
            if(s.charAt(i) == s.charAt(i-1))
                power++;
            else {
                power = 1;
            }
            maxPower = Math.max(maxPower, power);
        }

        return maxPower;
    }
}
