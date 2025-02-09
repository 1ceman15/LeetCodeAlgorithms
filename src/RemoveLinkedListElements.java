
//https://leetcode.com/problems/remove-linked-list-elements/description/

public class RemoveLinkedListElements{
    public ListNode removeElements(ListNode head, int val) {
        ListNode dummy = new ListNode();
        dummy.next = head;

        ListNode prev = dummy;
        ListNode cur = head;

        while (cur != null){
            ListNode next = cur.next;
            if(cur.val == val){
                prev.next = next;
            }else
                prev = cur;

            cur = next;
        }

        return dummy.next;
    }
}
