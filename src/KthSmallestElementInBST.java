
//https://leetcode.com/problems/kth-smallest-element-in-a-bst/description/


public class KthSmallestElementInBST {
    private int index = 0;
    public int kthSmallest(TreeNode root, int k) {
        TreeNode result = search(root, k);
        return result.val;

    }

    private TreeNode search(TreeNode root, int k) {
        if (root == null) {
            return null;
        }
        TreeNode node = search(root.left, k);
        if (node != null) {
            return node;
        }
        index++;
        if(k == index){
            return root;
        }

        return search(root.right, k);
    }

}
