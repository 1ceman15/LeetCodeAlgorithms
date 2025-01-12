//https://leetcode.com/problems/validate-binary-search-tree/
public class ValidateBinarySearchTree {
    public  boolean isValidBST(TreeNode root) {
        return isValid(root, Long.MIN_VALUE, Long.MIN_VALUE);
    }
    private boolean isValid(TreeNode node, long min, long max){
        if(node ==  null)
            return true;

        if(node.val > min && node.val < max) {
            boolean left = isValid(node.left, min, node.val);
            boolean right = isValid(node.right, node.val, max);
            return left && right;
        }else return false;
    }


}
