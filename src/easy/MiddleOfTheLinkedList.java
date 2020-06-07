package easy;

/* #876
Given a non-empty, singly linked list with head node head, return a middle node of linked list.
If there are two middle nodes, return the second middle node.

Example 1:
Input: [1,2,3,4,5]
The returned node has value 3.

Example 2:
Input: [1,2,3,4,5,6]
Output: Node 4 from this list (Serialization: [4,5,6])
Since the list has two middle nodes with values 3 and 4, we return the second one.

Note:
The number of nodes in the given list will be between 1 and 100.
 */
public class MiddleOfTheLinkedList {

    public static void main(String[] args) {
        MiddleOfTheLinkedList finder = new MiddleOfTheLinkedList();
        ListNode middle = finder.middleNode(new ListNode(1, new ListNode(2, new ListNode(3))));
        assert middle.val == 2 : "Solution is wrong";
        middle = finder.middleNode(new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4)))));
        assert middle.val == 3 : "Solution is wrong";
    }

    public ListNode middleNode(ListNode head) {
        ListNode fast = head, slow = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }

    static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }
}
