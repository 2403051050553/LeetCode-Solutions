# Java Algorithm Practice

[![Java CI](https://github.com/2403051050553/LeetCode-Solutions/actions/workflows/ci.yml/badge.svg)](https://github.com/2403051050553/LeetCode-Solutions/actions/workflows/ci.yml)
[![Java 17](https://img.shields.io/badge/Java-17-orange?logo=openjdk)](https://openjdk.org/projects/jdk/17/)

A small, tested collection of Java implementations for common data-structure and algorithm patterns. Each method documents its assumptions through its API and tests; this repository does not claim a particular LeetCode problem count.

## Implemented patterns

| Class | Methods | Complexity |
| --- | --- | --- |
| `ArrayAlgorithms` | `twoSum`, `maxSubarraySum`, `mergeIntervals` | O(n) for `twoSum`/`maxSubarraySum`; O(n log n) for interval sorting |
| `LruCache` | Generic bounded least-recently-used cache | O(1) average `get`/`put` |
| `SlidingWindowAlgorithms` | `maximums` using a monotonic deque | O(n) time, O(k) space |
| `StringAlgorithms` | `isPalindrome`, `firstUniqueCharacterIndex` | O(n) time |
| `SearchAlgorithms` | `lowerBound` on sorted input | O(log n) time |
| `ReverseNodesInKGroup` | Reverses linked-list nodes in complete groups | O(n) time, O(1) extra space |

## Public LeetCode solution

| Problem | Java implementation | Source |
| --- | --- | --- |
| [25. Reverse Nodes in k-Group](https://leetcode.com/problems/reverse-nodes-in-k-group/) | [`ReverseNodesInKGroup`](src/main/java/com/jatinahuja/leetcode/ReverseNodesInKGroup.java) | [Public solution post](https://leetcode.com/problems/reverse-nodes-in-k-group/solutions/7391010/write-these-program-of-the-java-and-thes-yxp3/) |

This entry mirrors the Java code in the linked public solution post. It is the
publicly verifiable LeetCode solution found for this profile; it is not a complete
export of the profile's accepted submissions.

`LruCache` rejects null keys and values, returns cache misses as `Optional.empty()`,
and is intended for single-threaded use.

## Requirements

- JDK 17 or newer
- Maven 3.8+

## Run tests

```bash
mvn test
```

Compile the project without running tests:

```bash
mvn package
```

GitHub Actions runs the unit tests on pushes and pull requests. The sliding-window
implementation is also checked against a brute-force reference over deterministic
random inputs, so the test is repeatable across runs.

## Layout

```text
src/
├── main/java/com/jatinahuja/algorithms/  # Implementations
└── test/java/com/jatinahuja/algorithms/  # JUnit 5 tests
```

## LeetCode profile

[View profile](https://leetcode.com/u/2403051050553/)
