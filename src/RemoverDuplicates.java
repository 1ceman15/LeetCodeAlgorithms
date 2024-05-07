
//https://leetcode.com/problems/remove-duplicates-from-sorted-list/

public class RemoverDuplicates {
    public ListNode deleteDuplicates(ListNode head) {
        ListNode dummy = new ListNode();
        dummy.next = head;

        ListNode cur = head;
        //Also can be used 2 nested while loops
        while (cur != null && cur.next != null){
            if(cur.val == cur.next.val){
                cur.next = cur.next.next;

            }else
                cur = cur.next;

        }

        return dummy.next;
    }
}
