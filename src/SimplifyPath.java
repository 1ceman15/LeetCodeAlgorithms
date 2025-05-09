
//https://leetcode.com/problems/simplify-path/description/


import java.util.Stack;

public class SimplifyPath {
    public String simplifyPath(String path) {
        String[] tokens = path.split("/");
        Stack<String> stack = new Stack<>();

        for (String token: tokens) {
            if(token.equals("..")){
                if(!stack.isEmpty())
                    stack.pop();
            }else if(!token.equals(".") && !token.isEmpty()){
                stack.push(token);
            }
        }

        StringBuilder str = new StringBuilder();
        while (!stack.isEmpty()){
            str.insert(0, "/");
            str.insert(0, stack.pop());
        }


        str.insert(0, "/");

        if(str.length() > 1)//Если там только /
            str.setLength(str.length() -1);

        return str.toString();
    }

}
