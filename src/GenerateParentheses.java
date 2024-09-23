
//https://leetcode.com/problems/generate-parentheses/description/

import java.util.ArrayList;
import java.util.List;

public class GenerateParentheses{
    List<String> result = new ArrayList<>();

    public List<String> generateParenthesis(int n) {

        backtracking(new StringBuilder(), n,0,0);

        return result;
    }

    public void backtracking(StringBuilder str, int length, int opened, int closed){
        if(str.length()==length*2){
            result.add(str.toString());
            return;
        }

        if(opened<length){
            str.append('(');
            backtracking(str,length,opened+1,closed);
            str.setLength(str.length()-1);
        }
        if(closed<opened){
            str.append(')');
            backtracking(str,length,opened,closed+1);
            str.setLength(str.length()-1);
        }

    }


}

