
//https://leetcode.com/problems/same-tree/

public class SameTree {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if(p == null || q == null)
            return p == q;

        if(p.val == q.val)
            return isSameTree(p.right, q.right) && isSameTree(p.left, q.left);
        else return false;


    }


}
