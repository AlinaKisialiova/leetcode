package medium;

/* #86
Given a linked list and a value x, partition it such that all nodes less than x come before nodes greater than or equal to x.
You should preserve the original relative order of the nodes in each of the two partitions.

Example:
Input: head = 1->4->3->2->5->2, x = 3
Output:       1->2->2->4->3->5
 */
public class PartitionList {

    public static void main(String[] args) {
        ListNode partition = new PartitionList().partition(new ListNode(1, new ListNode(4, new ListNode(3, new ListNode(2, new ListNode(5, new ListNode(2)))))), 3);
        while (partition != null) {
            System.out.print(partition.val);
            partition = partition.next;
        }
    }

    public ListNode partition(ListNode head, int x) {
        ListNode beforeListHead = new ListNode(0);
        ListNode afterListHead = new ListNode(0);
        ListNode beforeList = beforeListHead, afterList = afterListHead;
        while (head != null) {
            if (head.val < x) {
                beforeList.next = head;
                beforeList = head;
            } else {
                afterList.next = head;
                afterList = head;
            }
            head = head.next;
        }
        //to avoid cycling
        afterList.next = null;
        beforeList.next = afterListHead.next;
        return beforeListHead.next;
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
