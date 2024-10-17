
//https://leetcode.com/problems/reverse-linked-list/description/
public class ReverseLinkedList {
    public  ListNode reverseListRecursively(ListNode head) {
            if(head == null)
                return null;


            ListNode newHead = head;
            if(head.next != null){
                newHead = reverseListRecursively(head.next);
                head.next.next = head;
            }
            head.next = null;

            return  newHead;
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
