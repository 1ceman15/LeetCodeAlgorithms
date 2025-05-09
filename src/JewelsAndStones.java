import java.util.HashSet;
import java.util.Set;

public class JewelsAndStones {
    public int numJewelsInStones(String jewels, String stones) {
        Set<Character> jewelsSet = new HashSet<>();

        for(char c: jewels.toCharArray()){
            jewelsSet.add(c);
        }

        int jewelsCount = 0;

        for(char c: stones.toCharArray()){
            if(jewelsSet.contains(c))
                jewelsCount++;
        }

        return jewelsCount;
    }

}
