import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

//https://leetcode.com/problems/minimum-depth-of-binary-tree/description/
public class MinimumDepthOfBinaryTree {
    //Speed №3
    int DFS(TreeNode root){
        if(root == null)
            return 0;

        Stack<TreeNode> stack = new Stack<>();
        Stack<Integer> depthStack = new Stack<>();

        stack.add(root);
        depthStack.add(1);
        int answer = Integer.MAX_VALUE;

        int now = 1;



        while (!stack.isEmpty()){
            TreeNode node = stack.pop();
            int depth = depthStack.pop();

            if(node.left == null && node.right == null) {
                answer = answer > depth ? depth : answer;
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

    //Speed №2
    int DFS_Recursive(TreeNode root){
        if (root == null) {
            return 0;
        }
        // Если текущий узел - лист, то его глубина равна 1
        if (root.left == null && root.right == null) {
            return 1;
        }
        // Если левое поддерево отсутствует, рекурсивно ищем глубину в правом поддереве
        if (root.left == null) {
            return DFS_Recursive(root.right) + 1;
        }
        // Если правое поддерево отсутствует, рекурсивно ищем глубину в левом поддереве
        if (root.right == null) {
            return DFS_Recursive(root.left) + 1;
        }
        // Иначе, ищем минимальную глубину среди левого и правого поддеревьев
        return Math.min(DFS_Recursive(root.left), DFS_Recursive(root.right)) + 1;
    }


    //Speed №1
    int BFS(TreeNode root){
        Queue<TreeNode> q = new LinkedList<>();

        q.add(root);
        q.add(null);

        int answer = 0;

        while (q.peek() != null){
            answer++;

            while (q.peek() != null){
                TreeNode node = q.poll();
                if(node.left == null && node.right == null)
                    return answer;
                if(node.right != null)
                    q.add(node.right);
                if(node.left != null)
                    q.add(node.left);

            }
            q.add(q.poll());
        }




        return  answer;
    }


}
