
//https://leetcode.com/problems/diameter-of-binary-tree/description/

public class DiameterOfBinaryTree {
    int diameter = 0;
    public int diameterOfBinaryTree(TreeNode root) {

        DFS(root);

        return diameter;
    }

    public int DFS(TreeNode root){
        if(root == null)
            return -1;

        int left = DFS(root.left);
        int right = DFS(root.right);

        diameter = Math.max(diameter, left+ right +2);

        return 1 + Math.max(left, right);

        }


}

