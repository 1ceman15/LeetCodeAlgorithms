
//https://leetcode.com/problems/reorder-list/description/

public class ReorderList {
    public void reorderList(ListNode head) {



    }




    public ListNode reverseList(ListNode head) {
        ListNode curr = head;
        ListNode prev = null;
        while (curr != null){
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }

        return prev;
    }
}
