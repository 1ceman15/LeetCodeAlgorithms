import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

//https://leetcode.com/problems/binary-tree-level-order-traversal/description/
public class BinaryTreeLevelOrderTraversal {
    List<List<Integer>> result = new ArrayList<>();
    public List<List<Integer>> levelOrder(TreeNode root) {

        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        q.add(null);
        while (q.peek() != null){
            List<Integer> list = new ArrayList<>();
            while (q.peek() != null){
                TreeNode node = q.poll();
                list.add(node.val);
                if(node.left!=null)
                    q.add(node.left);
                if(node.right!=null)
                    q.add(node.right);

            }
            result.add(list);
            q.add(q.poll());
        }

        return result;
    }
}
