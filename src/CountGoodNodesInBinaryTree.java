
public class CountGoodNodesInBinaryTree {
    int answer = 0;
    public int goodNodes(TreeNode root) {
        DFS(root, Integer.MIN_VALUE);
        return answer;
    }

    private void DFS(TreeNode node, int max){
        if(node == null)
            return;

        if(node.val >= max)
            answer++;
        max = Math.max(max, node.val);
        DFS(node.left, max);
        DFS(node.right,max);
    }
}
