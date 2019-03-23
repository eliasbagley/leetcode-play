/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode detectCycle(ListNode head) {
        ListNode intersection = cycleIntersection(head);
        if (intersection == null) {
            return null;
        }

        // now we know we have a cycle
        // walk forward from start, forward from intersection until they meet
        ListNode start = head;
        while (start != intersection) {
            start = start.next;
            intersection = intersection.next;
        }


        return start;
    }

    // return the ListNode where the List intersections from a slow and fast pointer, or null if none exists
    public ListNode cycleIntersection(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;

        ListNode intersection = null;
        boolean start = true;

        while (fast != null) {
            if (fast == slow && !start) {
                intersection = slow;
                break;
            }

            slow = slow.next;
            fast = fast.next;
            if (fast != null) {
                fast = fast.next;
            }
            start = false;
        }

        if (fast == null) {
            return null;
        }

        return intersection;
    }
}
