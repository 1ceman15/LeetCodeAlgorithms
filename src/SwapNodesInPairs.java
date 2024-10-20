
//https://leetcode.com/problems/swap-nodes-in-pairs/description/

public class SwapNodesInPairs {
    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null)
            return head;

        ListNode dummy = new ListNode(0, head);

        ListNode prev = dummy;


        while(prev.next != null && prev.next.next != null) {
            ListNode cur = prev.next;
            ListNode nextNode = cur.next;
            cur.next = nextNode.next;
            nextNode.next = cur;
            prev.next = nextNode;
            prev = nextNode.next;
        }


        return dummy.next;

    }


}
