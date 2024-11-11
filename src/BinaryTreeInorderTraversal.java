
//https://leetcode.com/problems/binary-tree-inorder-traversal/description/

import java.util.ArrayList;
import java.util.List;

public class BinaryTreeInorderTraversal {
    List<Integer> list = new ArrayList<>();
    public List<Integer> inorderTraversal(TreeNode root) {


        Traversal(root);

        return list;
    }

    public void Traversal(TreeNode root) {
        if (root == null)
            return;
        inorderTraversal(root.left);
        list.add(root.val);
        inorderTraversal(root.right);
    }


}
