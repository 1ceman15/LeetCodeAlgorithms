
//https://leetcode.com/problems/reorder-list/description/

public class ReorderList {
    public void reorderList(ListNode head) {

        ListNode second = cut(head);

        second = reverseList(second);

        while (head != null) {
            ListNode next = head.next;
            head.next = second;
            head = next;
            second = next;
        }





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



    private ListNode cut(ListNode head) {
        if(head == null || head.next == null)
            return head;
        ListNode prev = head;
        ListNode slow = head;
        ListNode fast = head.next;


        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        prev = slow.next;
        slow.next = null;


        return prev;
    }
}
