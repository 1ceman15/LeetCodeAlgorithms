
//https://leetcode.com/problems/convert-sorted-array-to-binary-search-tree/description/



public class ConvertSortedArrayToBinarySearchTree {
    public TreeNode sortedArrayToBST(int[] nums) {
        if(nums == null || nums.length == 0)
            return null;

        return buildTree(nums, 0, nums.length - 1);



    }

    private TreeNode buildTree(int[] nums, int left, int right) {
        if(left > right)
            return null;

        int mid = left + (right - left) / 2;
        TreeNode node = new TreeNode(nums[mid]);
        node.left = buildTree(nums, left, mid - 1);
        node.right = buildTree(nums, mid + 1, right);

        return node;

    }
}