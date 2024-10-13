
//https://leetcode.com/problems/sort-list/description/


public class SortList {
    public ListNode sortList(ListNode head) {
        if(head == null || head.next == null)
            return head;

        ListNode l1 = head;
        ListNode l2 = cut(head);

        l1 = sortList(l1);
        l2 = sortList(l2);

        return merge(l1, l2);

    }

    private ListNode merge(ListNode list1, ListNode list2) {
        ListNode head = new ListNode();
        ListNode tail = head;

        while (list1 != null && list2 != null){
            if(list1.val <= list2.val){
                tail.next = list1;
                list1 = list1.next;
            }else {
                tail.next = list2;
                list2 = list2.next;
            }
            tail = tail.next;
        }


        while (list1 != null){
            tail.next = list1;
            list1 = list1.next;
            tail = tail.next;
        }
        while (list2 != null){
            tail.next = list2;
            list2 = list2.next;
            tail = tail.next;
        }


        return head.next;
    }

    private ListNode cut(ListNode head) {
        if(head == null || head.next == null)
            return head;
        ListNode prev = head;
        ListNode slow = head.next;
        ListNode fast = head.next.next;


        while (fast != null && fast.next != null) {
            prev = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        prev.next = null;


        return slow;
    }

}
