/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode reverseBetween(ListNode head, int m, int n) {
        if(head == null) return head;
        
        ListNode prev = null;
        ListNode curr = head;
        
        while(m > 1 ){
            prev = curr;
            curr = curr.next;
            m--;
            n--;
        }
        
        ListNode connection = prev;
        ListNode tail = curr;
        
        while (n > 0){
            ListNode next = curr.next;
            
            curr.next = prev;
            prev = curr;
            curr = next;
            n--;
        }
        
        if(connection != null){
            connection.next = prev;
        } else {
            head = prev;
        }
        
        tail.next = curr;
        
        return head;
    }
}

/*
idea 1
    find m pointer - also m-1
    find n pointer - also n+1
    
    reverse the between pointers
    
    connect to m-1 and n+1
*/