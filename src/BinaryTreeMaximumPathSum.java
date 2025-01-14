
//https://leetcode.com/problems/binary-tree-maximum-path-sum/description/

public class BinaryTreeMaximumPathSum {

    private int max = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        dfs(root);
        return max;
    }

    private int dfs(TreeNode node){
        if(node == null)
            return 0;

        int left = Math.max(dfs(node.left), 0);
        int right = Math.max(dfs(node.right),0);

        int sum = node.val + left + right;
        max = Math.max(max, sum);

        return node.val + Math.max(left,right);

    }
}
