
//https://leetcode.com/problems/binary-tree-right-side-view/description/


import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BinaryTreeRightSideView {

    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> res = new ArrayList<>();

        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        q.add(null);
        while (q.peek() != null) {

            while (q.peek() != null) {
                TreeNode node = q.poll();

                if(node.left != null) q.add(node.left);
                if(node.right != null) q.add(node.right);

                if(q.peek() == null) res.add(node.val);

            }


            q.add(q.poll());


        }





        return res;
    }

}
