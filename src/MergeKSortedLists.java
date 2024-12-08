
//https://leetcode.com/problems/merge-k-sorted-lists/description/

import java.util.ArrayList;
import java.util.List;

public class MergeKSortedLists {
    public ListNode mergeKLists(ListNode[] lists) {
        if(lists.length == 0)
            return null;

        for (int i = 0; i < lists.length-1; i++) {
            lists[i+1] = mergeTwoLists(lists[i], lists[i+1]);
        }

        return lists[lists.length-1];
    }

    public ListNode mergeKLists2(ListNode[] lists) {
        if(lists.length == 0)
            return null;

        while (lists.length > 1){
            List<ListNode> merged = new ArrayList<>();
            for (int i = 0; i < lists.length; i+=2) {
                ListNode l1 = lists[i];
                ListNode l2 = i+1 < lists.length? lists[i+1]: null;
                merged.add(mergeTwoLists(l1,l2));
            }
            lists = merged.toArray(new ListNode[0]);
        }


        return lists[0];
    }

    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
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



}
