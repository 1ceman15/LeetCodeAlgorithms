
//https://leetcode.com/problems/letter-case-permutation/description/

import java.util.ArrayList;
import java.util.List;



/*
StringBuilder передается по ссылке, и при изменении, он изменяется на всех уровнях рекурсии
Поэтому нужно откатывать StringBuilder после каждого рекурсивного вызова функции

При использовании String, в свою очередь, передается копия

*/
public class LetterCasePermutation {
    public static List<String> letterCasePermutation(String s) {

        ArrayList<String> list = new ArrayList<>();

        helpFunction(s, new StringBuilder(), 0, list);


        return list;
    }


    public static void helpFunction(String s, StringBuilder str, int index, ArrayList<String> list) {
        if (str.length() == s.length()) {
            list.add(str.toString());
            return;
        }
        if (Character.isLetter(s.charAt(index))) {
            //str = str + Character.toLowerCase(s.charAt(index));
            str.append(Character.toLowerCase(s.charAt(index)));
            helpFunction(s, str, index + 1, list);
            str.setLength(str.length()-1);
            str.append(Character.toUpperCase(s.charAt(index)));
            //str = str.substring(0, str.length() - 1);
            //str = str + Character.toUpperCase(s.charAt(index));
            helpFunction(s, str, index + 1, list);
            str.setLength(str.length()-1);
        } else {
            str.append(s.charAt(index));
            //str = str + s.charAt(index);
            helpFunction(s, str, index + 1, list);
            str.setLength(str.length()-1);
        }

    }

}


