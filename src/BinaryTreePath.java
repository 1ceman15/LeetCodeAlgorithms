
//https://leetcode.com/problems/binary-tree-paths/description/

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BinaryTreePath {

    ArrayList<String> array = new ArrayList<>();
    public  List<String> binaryTreePaths(TreeNode root) {


        DFS(root, new StringBuilder());

        return array;

    }

    public void DFS(TreeNode root, StringBuilder str){
        if(root == null)
            return;

        int len = str.length();

        str.append(root.val);

        if(root.left == null && root.right == null) {
            array.add(str.toString());
        }else {
            str.append("->");
            DFS(root.left, str);
            DFS(root.right, str);
        }
        str.setLength(len);

    }





}
