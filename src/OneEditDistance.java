
//https://leetcode.ca/2016-05-09-161-One-Edit-Distance/

import java.util.Objects;

public class OneEditDistance {
    public boolean isOneEditDistance(String s, String t) {
        int lengthS = s.length();
        int lengthT = t.length();

        for (int i = 0; i < Math.min(lengthS, lengthT); i++) {
            if(s.charAt(i) != t.charAt(i)){
                if(lengthS == lengthT){
                    //Если длинны равны, то только replace
                    return Objects.equals(s.substring(i+1), t.substring(i+1));
                }
                if(lengthS < lengthT){
                    //если длинна  s меньше, то либо удалить из t либо вставить в s
                    return Objects.equals(s.substring(i), t.substring(i+1));
                }else //если длинна s больше то либо удалить из s либо вставить в t
                    return Objects.equals(s.substring(i+1), t.substring(i));


            }
        }

        //вставка в конец
        return (Math.abs(lengthS - lengthT)) == 1;
    }
}
