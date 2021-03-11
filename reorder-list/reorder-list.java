/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public void reorderList(ListNode head) {
        if(head == null || head.next == null) return;
        
        ListNode l1 = head;
        ListNode l2 = head;
        
        
        //fast and slow pointer
        while(l2 != null && l2.next != null){
            l1 = l1.next;
            l2 = l2.next;
            l2 = l2.next;
        }
        
        //l1 is the halfway point;
        ListNode prev = null;
        ListNode curr = l1;
        
        while(curr != null){
            ListNode next = curr.next;
            
            curr.next = prev;
            prev =  curr;
            curr = next;
        }
        
        //prev is the beginning of the reversed list;
        ListNode first = head, second = prev, nextNode;
        while(second.next != null){
            nextNode = first.next;
            first.next = second;
            first = nextNode;
            
            nextNode = second.next;
            second.next = first;
            second = nextNode;
        }
        
        
        
    }
}

/*
Idea 

1. Split List into 2 bisecting in the middle -> ListA and ListB  
ListA is first half
ListB is second half 

2. Reverse ListB

3. Merge ListA and ListB

*/