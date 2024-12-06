import java.util.HashMap;

public class CopyListWithRandomPointer {
    class Node {
        int val;
        Node next;
        Node random;

        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }

    }

    public Node copyRandomList(Node head) {
        HashMap<Node, Node> oldToNew = new HashMap<>();
        oldToNew.put(null,null);

        Node cur = head;

        while (cur != null){
            oldToNew.put(cur, new Node(cur.val));
            cur = cur.next;
        }

        cur = head;

        while (cur != null){
            Node copy = oldToNew.get(cur);
            copy.next = oldToNew.get(cur.next);
            copy.random = oldToNew.get(cur.random);
            cur = cur.next;
        }


        return oldToNew.get(head);
    }
}
