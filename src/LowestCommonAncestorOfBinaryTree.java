
//https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-tree/description/


import java.util.LinkedList;
import java.util.Queue;

public class LowestCommonAncestorOfBinaryTree {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {


        return DFS(root, p, q);

    }

    public TreeNode DFS(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null)
            return null;

        if(root == p || root == q) {
            return root;
        }

        TreeNode left = DFS(root.left, p, q);
        TreeNode right = DFS(root.right, p, q);

        if(left != null && right != null) {
            return root;
        }else if(left != null) {
            return left;
        }else return right;


    }
}
