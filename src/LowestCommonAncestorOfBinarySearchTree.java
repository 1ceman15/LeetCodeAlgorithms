
//https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-search-tree/description/

public class LowestCommonAncestorOfBinarySearchTree {

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {

        TreeNode current = root;
        TreeNode prev = null;
        while(current != null) {
            prev = current;
            if(q.val < current.val && p.val < current.val) {
                current = current.left;
            }else if(q.val > current.val && p.val > current.val) {
                current = current.right;
            }else return current;
        }


        return prev;
    }
}
