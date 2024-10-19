
//https://leetcode.com/problems/rotate-list/description/


public class RotateList {

    public ListNode rotateRight(ListNode head, int k) {
        if (head == null) return head;

        int length = 1;

        ListNode end = head;

        while (end.next != null) {
            length++;
            end = end.next;
        }

        k = k % length;
        if (k == 0) return head;

        ListNode cur = head;
        for (int i = 0; i < length - k - 1; i++) {
            cur = cur.next;
        }

        ListNode newHead = cur.next;
        cur.next = null;

        end.next = head;


        return newHead;

    }


}
