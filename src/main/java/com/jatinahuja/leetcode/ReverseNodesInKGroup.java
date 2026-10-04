package com.jatinahuja.leetcode;

public final class ReverseNodesInKGroup {
    public ListNode reverseKGroup(ListNode head, int k) {
        if (k < 1) {
            throw new IllegalArgumentException("Group size must be positive");
        }
        if (head == null) {
            return null;
        }

        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode current = dummy;

        while (true) {
            ListNode start = current.next;
            ListNode end = start;
            for (int index = 0; index < k - 1 && end != null; index++) {
                end = end.next;
            }
            if (end == null) {
                break;
            }

            ListNode previous = null;
            ListNode node = start;
            for (int index = 0; index < k; index++) {
                ListNode next = node.next;
                node.next = previous;
                previous = node;
                node = next;
            }

            current.next = previous;
            start.next = node;
            current = start;
        }

        return dummy.next;
    }

    public static final class ListNode {
        public int val;
        public ListNode next;

        public ListNode(int val) {
            this.val = val;
        }
    }
}
