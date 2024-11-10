
//https://leetcode.com/problems/binary-tree-zigzag-level-order-traversal/description/


import java.util.*;

public class BinaryTreeZigzagLevelOrderTraversal {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();

        Queue<TreeNode> q = new LinkedList<>();


        q.add(root);
        q.add(null);

        boolean flag = true;


        while (q.peek() != null) {
            List<Integer> list = new ArrayList<>();

            while (q.peek() != null) {
                TreeNode node = q.poll();
                list.add(node.val);

                if (node.left != null) q.add(node.left);
                if (node.right != null) q.add(node.right);

            }

            q.add(q.poll());
            if(flag){
                result.add(list);
            }else result.add(reverseList(list));

            flag = !flag;


        }


        return result;

    }


    public List<Integer> reverseList(List<Integer> list) {
        List<Integer> res = new ArrayList<>();

        for (int i = list.size()-1 ; i >= 0; i--) {
            res.add(list.get(i));
        }

        return res;

    }


}
