
//https://leetcode.com/problems/symmetric-tree/description/

public class SymmetricTree {
    public  boolean isSymmetric(TreeNode root) {
        return dfs(root.left, root.right);
    }

    public  boolean dfs(TreeNode leftNode, TreeNode rightNode){
        if(leftNode == null && rightNode == null)
            return true;

        if(leftNode == null || rightNode == null)
            return false;

        if(leftNode.val == rightNode.val)
            return dfs(leftNode.right, rightNode.left) && dfs(leftNode.left, rightNode.right);

        return false;
    }


}
