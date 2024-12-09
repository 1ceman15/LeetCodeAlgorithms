
//https://leetcode.com/problems/reverse-nodes-in-k-group/description/

public class ReverseNodesInKGroup {
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode dummy = new ListNode(0,head);
        ListNode cur = dummy;

        int count = 0;

        while (cur!=null){
            count++;
            cur = cur.next;
        }

        ListNode prev = dummy;

        while (count >= k){
            cur = prev.next;
            ListNode next = cur.next;

            for (int i = 1; i < k ; i++) {
                cur.next = next.next;
                next.next = prev.next;
                prev.next = next;
                next = cur.next;
            }

            prev = cur;
            count-=k;

        }

        return dummy.next;
    }
}
