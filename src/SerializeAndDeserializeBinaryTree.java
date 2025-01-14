//https://leetcode.com/problems/serialize-and-deserialize-binary-tree/description/

import java.util.ArrayList;
import java.util.List;

public class SerializeAndDeserializeBinaryTree {

    private int index;
    public String serialize(TreeNode root) {
        List<String> list = new ArrayList<>();
        dfsSerialize(root, list);
        return String.join("," , list);
    }



    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        int index = 0;
        String[] vals = data.split(",");
        return dfsDeserialize(vals);
    }

    private void dfsSerialize(TreeNode node, List<String> list){
        if(node == null){
            list.add("N");
            return;
        }
        list.add(String.valueOf(node.val));
        dfsSerialize(node.left, list);
        dfsSerialize(node.right, list);
    }
    private TreeNode dfsDeserialize(String[] vals){
        if(vals[index].equals("N")){
            index++;
            return null;
        }

        TreeNode node = new TreeNode(Integer.parseInt(vals[index++]));

        node.left = dfsDeserialize(vals);
        node. right = dfsDeserialize(vals);
        return node;

    }


}
