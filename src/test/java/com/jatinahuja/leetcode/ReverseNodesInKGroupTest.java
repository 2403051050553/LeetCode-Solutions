package com.jatinahuja.leetcode;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

class ReverseNodesInKGroupTest {
    private final ReverseNodesInKGroup solution = new ReverseNodesInKGroup();

    @Test
    void reversesCompleteGroupsAndKeepsIncompleteSuffix() {
        assertArrayEquals(
                new int[] {2, 1, 4, 3, 5},
                values(solution.reverseKGroup(list(1, 2, 3, 4, 5), 2)));
    }

    @Test
    void reversesSingleGroupAndLeavesShortListUnchanged() {
        assertArrayEquals(
                new int[] {3, 2, 1, 4, 5},
                values(solution.reverseKGroup(list(1, 2, 3, 4, 5), 3)));
        assertArrayEquals(
                new int[] {1, 2},
                values(solution.reverseKGroup(list(1, 2), 3)));
    }

    @Test
    void supportsNullInputAndRejectsNonPositiveGroupSize() {
        assertNull(solution.reverseKGroup(null, 2));
        assertThrows(
                IllegalArgumentException.class,
                () -> solution.reverseKGroup(list(1, 2), 0));
    }

    private static ReverseNodesInKGroup.ListNode list(int... values) {
        ReverseNodesInKGroup.ListNode dummy = new ReverseNodesInKGroup.ListNode(0);
        ReverseNodesInKGroup.ListNode current = dummy;
        for (int value : values) {
            current.next = new ReverseNodesInKGroup.ListNode(value);
            current = current.next;
        }
        return dummy.next;
    }

    private static int[] values(ReverseNodesInKGroup.ListNode head) {
        int length = 0;
        for (ReverseNodesInKGroup.ListNode node = head; node != null; node = node.next) {
            length++;
        }

        int[] values = new int[length];
        int index = 0;
        for (ReverseNodesInKGroup.ListNode node = head; node != null; node = node.next) {
            values[index++] = node.val;
        }
        return values;
    }
}
