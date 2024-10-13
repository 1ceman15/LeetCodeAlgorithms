
//https://leetcode.com/problems/add-two-numbers/



public class AddTwoNumbers {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode head = new ListNode(0);
        ListNode cur = head;
        int carry = 0;
        while (l1 != null || l2 != null) {
            cur.next = new ListNode();
            cur = cur.next;
           int val1 = l1 == null ? 0 : l1.val;
           int val2 = l2 == null ? 0 : l2.val;

           int sum = val1 + val2 + carry;
           if(sum > 9) {
               sum = sum - 10;
               carry = 1;
           }else carry = 0;
           cur.val = sum;

           l1 = l1 == null ? null : l1.next;
           l2 = l2 == null ? null : l2.next;
        }
        if(carry>0){
            cur.next = new ListNode(carry);
        }

        return head;

    }

}
