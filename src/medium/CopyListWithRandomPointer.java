package medium;

/**
 * # 138
 * A linked list is given such that each node contains an additional random pointer which could point to any node in the list or null.
 *
 * Return a deep copy of the list.
 *
 * The Linked List is represented in the input/output as a list of n nodes. Each node is represented as a pair of [val, random_index] where:
 *
 * val: an integer representing Node.val
 * random_index: the index of the node (range from 0 to n-1) where random pointer points to, or null if it does not point to any node.
 */
public class CopyListWithRandomPointer {
    // Definition for a Node.
    static class Node {
        int val;
        Node next;
        Node random;

        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }

    public static void main(String[] args) {
        Node one = new Node(1);
        Node two = new Node(2);
        Node three = new Node(3);
        one.next = two;
        one.random = three;
        two.next = three;
        two.random = one;
        new CopyListWithRandomPointer().copyRandomList(one);
    }

    public Node copyRandomList(Node head) {
        if (head == null){
            return null;
        }
        // 1. Create a clone of a node and put in to the 'next' for a original
        Node pointer = head;
        while (pointer != null) {
            Node originalNext = pointer.next;
            pointer.next = new Node(pointer.val);
            Node cloned = pointer.next;
            cloned.next = originalNext;
            pointer = cloned.next;
        }
        // print(head);
        // 2. Copy random pointer: the 'next' for 'random' pointer of an original node is 'random' for a cloned node
        pointer = head;
        while (pointer != null) {
            Node cloned = pointer.next;
            if (pointer.random != null) {
                cloned.random = pointer.random.next;
            }
            pointer = cloned.next;
        }
        //print(head);
        // 3. Unweave the linked lists
        pointer = head;
        Node result = head.next;
        while (pointer != null) {
            Node cloned = pointer.next;
            pointer.next = cloned.next;
            cloned.next = cloned.next != null ? cloned.next.next : null;
            pointer = pointer.next;
        }
        //print(result);
        return result;
    }

    private void print(Node head) {
        System.out.println();
        while (head != null) {
            String random = head.random != null ? "[r:" + head.random.val + "]" : "[null]";
            System.out.print(head.val + random + "->");
            head = head.next;
        }
    }
}
