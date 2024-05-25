
//https://leetcode.com/problems/invert-binary-tree/description/

public class InvertBinaryTree {
    public TreeNode invertTree(TreeNode root) {
            if(root == null)
                return root;

            TreeNode helper = root.left;

            root.left = root.right;
            root.right = helper;

            invertTree(root.right);
            invertTree(root.left);

            return root;
    }

}
