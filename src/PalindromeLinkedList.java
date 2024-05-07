
//https://leetcode.com/problems/palindrome-linked-list/description/
public class PalindromeLinkedList {
    public boolean isPalindrome(ListNode head) {

        ListNode slow = head;
        ListNode fast = head;

        //Finding middle of LinkedList(slow)
        while (fast != null && fast.next != null){
            fast = fast.next.next;
            slow = slow.next;
        }

        ListNode prev = null;

        //Reversing half of LinkedList
        while (slow != null){
            ListNode next = slow.next;
            slow.next = prev;
            prev = slow;
            slow = next;
        }

        ListNode left = head;
        ListNode right = prev;

        while (right!= null) {
            if (right.val != left.val)
                return false;
            right = right.next;
            left = left.next;
        }

        return true;

    }
}
