
//https://leetcode.com/problems/backspace-string-compare/

public class BackspaceStringCompare {

    //Time complexity O(n+m)
    //Space complexity 0(n+m)
    public boolean backspaceCompare(String s, String t) {
        StringBuilder str1 = new StringBuilder();
        StringBuilder str2 = new StringBuilder();

        for (int i = 0; i < s.length() ; i++) {
            if(s.charAt(i) == '#') {
                if (str1.length() > 0)
                    str1.deleteCharAt(str1.length() - 1);
            }
            else str1 = str1.append(s.charAt(i));
        }

        for (int i = 0; i < t.length() ; i++) {
            if(t.charAt(i) == '#') {
                if (str2.length() > 0)
                    str2.deleteCharAt(str2.length() - 1);
            }
            else str2 = str2.append(t.charAt(i));
        }


        return str1.toString().equals(str2.toString());

    }

    //Time complexity O(n+m)
    //Space complexity 0(1)
    public boolean backspaceCompare2(String s, String t) {
        int index1 = s.length()-1;
        int index2 = t.length()-1;
        while (index1 >=0 || index2 >=0){

            index1 = nextValidChar(s, index1);
            index2 = nextValidChar(t, index2);
            char ch1 = index1 >=0 ? s.charAt(index1): '~';
            char ch2 = index2 >=0 ? t.charAt(index2): '~';
            if(ch2 != ch1)
                return false;
            index1--;
            index2--;
        }
        return true;
    }

    public int nextValidChar(String str, int index){
        int bs = 0;
        while (index>=0){
            if(str.charAt(index) != '#' && bs == 0)
                return index;
            else if (str.charAt(index) != '#') {
                bs--;
            }
            else bs++;
            index--;
        }
        return index;
    }



}
