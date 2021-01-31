package easy;

/* Reverse a singly linked list.
Example:
Input: 1->2->3->4->5->NULL
Output: 5->4->3->2->1->NULL

Follow up:
A linked list can be reversed either iteratively or recursively. Could you implement both?
 */
public class ReverseLinkedList {

    public static void main(String[] args) {
        System.out.println("iterative reversion:");
        ListNode list = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5)))));
        ListNode reversedIteratively = new ReverseLinkedList().reverseList(list, "i");
        print(reversedIteratively);
        System.out.println("\nrecursive reversion:");
        ListNode reversedRecursively = new ReverseLinkedList().reverseList(reversedIteratively, "r");
        print(reversedRecursively);
    }

    public ListNode reverseList(ListNode head, String mode) {
        if (mode.equals("i")) {
            return iterativeReverse(head);
        }
        if (mode.equals("r")) {
            return recursiveReverse(head);
        }
        throw new IllegalArgumentException("Incorrect mode");
    }

    private ListNode iterativeReverse(ListNode head) {
        ListNode previous = null;
        ListNode current = head;
        while (current != null) {
            ListNode nextTemp = current.next;
            current.next = previous;
            previous = current;
            current = nextTemp;
        }
        return previous;
    }

    private ListNode recursiveReverse(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode previous = recursiveReverse(head.next);
        head.next.next = head;
        head.next = null;
        return previous;
    }

    private static void print(ListNode head) {
        while (head != null) {
            System.out.print(head.value + " ");
            head = head.next;
        }
    }

    static class ListNode {
        int value;
        ListNode next;

        ListNode(int value) {
            this.value = value;
        }

        ListNode(int value, ListNode next) {
            this.value = value;
            this.next = next;
        }
    }
}
