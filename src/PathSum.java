
//https://leetcode.com/problems/path-sum/
public class PathSum {
    public boolean hasPathSum(TreeNode root, int targetSum) {

        return pathSum(root, 0, targetSum);
    }

    public boolean pathSum(TreeNode node, int sum, int targetSum){
        if(node == null)
            return false;

        sum = sum + node.val;

        if(node.left == null && node.right == null)
            return sum == targetSum;

        return pathSum(node.right, sum, targetSum) || pathSum(node.left, sum, targetSum);
    }
}
