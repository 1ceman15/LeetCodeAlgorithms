
//https://leetcode.com/problems/subtree-of-another-tree/description/

public class Subtree {


    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        if(subRoot == null) return true;
        if(root == null) return false;

        if(isSameTree(root, subRoot)) return true;

        return isSubtree(root.left, subRoot) ||
        isSubtree(root.right, subRoot);


    }



    public boolean isSameTree(TreeNode p, TreeNode q) {
        if(p == null || q == null)
            return p == q;

        if(p.val == q.val)
            return isSameTree(p.right, q.right) && isSameTree(p.left, q.left);
        else return false;


    }
    


}
