//https://leetcode.com/problems/string-compression/description/

public class StringCompression {
    public int compress(char[] chars) {
        int index = 0;

        char prev = chars[index];
        int count = 1;

        for (int i = 1; i < chars.length ; i++) {
            if (chars[i] == prev) {
                count++;
            }else{
                chars[index++] = prev;
                if(count > 1){
                    for(char c:  String.valueOf(count).toCharArray()) {
                        chars[index++] = c;
                    }
                }
                prev = chars[i];
                count = 1;

            }
        }

        chars[index++] = prev;
        if(count > 1){
            for(char c:  String.valueOf(count).toCharArray()) {
                chars[index++] = c;
            }
        }

        return index;
    }
}
