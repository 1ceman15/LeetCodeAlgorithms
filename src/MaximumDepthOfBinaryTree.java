import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

//https://leetcode.com/problems/maximum-depth-of-binary-tree/
public class MaximumDepthOfBinaryTree {
    public int DFS_Recursive(TreeNode root) {
        if(root == null)
            return 0;
        else return 1 + Math.max(DFS_Recursive(root.left), DFS_Recursive(root.right));
    }


    public int BFS(TreeNode root){
        if(root == null)
            return 0;

        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);

        int level = 0;

        while (!q.isEmpty()){
            int len = q.toArray().length;
            for (int i = 0; i < len; i++) {
                TreeNode node = q.poll();
                if(node.left != null)
                    q.add(node.left);
                if(node.right != null)
                    q.add(node.right);
            }
            level++;
        }
        return level;

    }

    public int DFS(TreeNode root){

        if(root == null)
            return 0;

        Stack<TreeNode> stack = new Stack<>();
        Stack<Integer> depthStack = new Stack<>();

        stack.add(root);
        depthStack.add(1);
        int answer = Integer.MIN_VALUE;

        int now = 1;



        while (!stack.isEmpty()){
            TreeNode node = stack.pop();
            int depth = depthStack.pop();

            if(node.left == null && node.right == null) {
                answer = Math.max(answer, depth);
            }
            if(node.right != null){
                stack.add(node.right);
                depthStack.add(depth+1);
            }
            if(node.left != null){
                stack.add(node.left);
                depthStack.add(depth+1);
            }

        }

        return answer;

    }
}
