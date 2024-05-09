import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

//https://leetcode.com/problems/average-of-levels-in-binary-tree/description/


public class AverageLevelsInBinaryTree {
    public List<Double> averageOfLevels(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<>();

        ArrayList<Double> answer = new ArrayList<>();

        q.add(root);
        q.add(null);


        while (q.peek() != null){
            double average = 0;
            int count = 0;

            while (q.peek() != null){
                TreeNode node = q.poll();

                if(node.left != null) q.add(node.left);
                if(node.right != null) q.add(node.right);

                average += node.val;
                count++;

            }

            q.add(q.poll());
            answer.add(average/count);

        }

        return answer;

    }
}
