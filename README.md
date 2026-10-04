# Java Algorithm Practice

[![Java CI](https://github.com/2403051050553/LeetCode-Solutions/actions/workflows/ci.yml/badge.svg)](https://github.com/2403051050553/LeetCode-Solutions/actions/workflows/ci.yml)
[![Java 17](https://img.shields.io/badge/Java-17-orange?logo=openjdk)](https://openjdk.org/projects/jdk/17/)

A tested collection of Java implementations for data-structure and algorithm patterns. The practice-set size below describes reference examples in this repository; it does not imply how many problems the account owner has solved or submitted on LeetCode.

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

## Practice and reference solutions

This curated set contains 53 readable, AI-assisted examples for studying common
interview patterns. They are **practice references, not claims about the account
owner's past LeetCode submissions or accepted solutions**. Problem links point
to LeetCode; this repository does not copy problem statements.

| Pattern | Problems and Java entry points |
| --- | --- |
| [Arrays and hashing](src/main/java/com/jatinahuja/practice/ArrayPractice.java) | [1 Two Sum](https://leetcode.com/problems/two-sum/) — `ArrayPractice.twoSum`; [217 Contains Duplicate](https://leetcode.com/problems/contains-duplicate/) — `containsDuplicate`; [53 Maximum Subarray](https://leetcode.com/problems/maximum-subarray/) — `maxSubArray`; [121 Best Time to Buy and Sell Stock](https://leetcode.com/problems/best-time-to-buy-and-sell-stock/) — `maxProfit`; [238 Product of Array Except Self](https://leetcode.com/problems/product-of-array-except-self/) — `productExceptSelf`; [56 Merge Intervals](https://leetcode.com/problems/merge-intervals/) — `mergeIntervals`; [283 Move Zeroes](https://leetcode.com/problems/move-zeroes/) — `moveZeroes`; [169 Majority Element](https://leetcode.com/problems/majority-element/) — `majorityElement`; [189 Rotate Array](https://leetcode.com/problems/rotate-array/) — `rotateRight`; [11 Container With Most Water](https://leetcode.com/problems/container-with-most-water/) — `maxArea` |
| [Strings](src/main/java/com/jatinahuja/practice/StringPractice.java) | [242 Valid Anagram](https://leetcode.com/problems/valid-anagram/) — `StringPractice.isAnagram`; [49 Group Anagrams](https://leetcode.com/problems/group-anagrams/) — `groupAnagrams`; [3 Longest Substring Without Repeating Characters](https://leetcode.com/problems/longest-substring-without-repeating-characters/) — `longestSubstringLength`; [14 Longest Common Prefix](https://leetcode.com/problems/longest-common-prefix/) — `longestCommonPrefix`; [20 Valid Parentheses](https://leetcode.com/problems/valid-parentheses/) — `isValidParentheses`; [151 Reverse Words in a String](https://leetcode.com/problems/reverse-words-in-a-string/) — `reverseWords`; [387 First Unique Character in a String](https://leetcode.com/problems/first-unique-character-in-a-string/) — `firstUniqueCharacterIndex`; [76 Minimum Window Substring](https://leetcode.com/problems/minimum-window-substring/) — `minWindow` |
| [Binary search](src/main/java/com/jatinahuja/practice/BinarySearchPractice.java) | [704 Binary Search](https://leetcode.com/problems/binary-search/) — `BinarySearchPractice.search`; [35 Search Insert Position](https://leetcode.com/problems/search-insert-position/) — `searchInsert`; [33 Search in Rotated Sorted Array](https://leetcode.com/problems/search-in-rotated-sorted-array/) — `searchRotated`; [153 Find Minimum in Rotated Sorted Array](https://leetcode.com/problems/find-minimum-in-rotated-sorted-array/) — `findMinRotated`; [162 Find Peak Element](https://leetcode.com/problems/find-peak-element/) — `findPeakElement` |
| [Sliding window](src/main/java/com/jatinahuja/practice/SlidingWindowPractice.java) | [239 Sliding Window Maximum](https://leetcode.com/problems/sliding-window-maximum/) — `SlidingWindowPractice.maxSlidingWindow`; [209 Minimum Size Subarray Sum](https://leetcode.com/problems/minimum-size-subarray-sum/) — `minSubArrayLen`; [424 Longest Repeating Character Replacement](https://leetcode.com/problems/longest-repeating-character-replacement/) — `characterReplacement`; [567 Permutation in String](https://leetcode.com/problems/permutation-in-string/) — `checkInclusion`; [1004 Max Consecutive Ones III](https://leetcode.com/problems/max-consecutive-ones-iii/) — `longestOnes` |
| [Stack](src/main/java/com/jatinahuja/practice/StackPractice.java) | [739 Daily Temperatures](https://leetcode.com/problems/daily-temperatures/) — `StackPractice.dailyTemperatures`; [150 Evaluate Reverse Polish Notation](https://leetcode.com/problems/evaluate-reverse-polish-notation/) — `evalRPN`; [71 Simplify Path](https://leetcode.com/problems/simplify-path/) — `simplifyPath`; [402 Remove K Digits](https://leetcode.com/problems/remove-k-digits/) — `removeKdigits` |
| [Dynamic programming](src/main/java/com/jatinahuja/practice/DynamicProgrammingPractice.java) | [70 Climbing Stairs](https://leetcode.com/problems/climbing-stairs/) — `DynamicProgrammingPractice.climbStairs`; [198 House Robber](https://leetcode.com/problems/house-robber/) — `rob`; [322 Coin Change](https://leetcode.com/problems/coin-change/) — `coinChange`; [139 Word Break](https://leetcode.com/problems/word-break/) — `wordBreak`; [300 Longest Increasing Subsequence](https://leetcode.com/problems/longest-increasing-subsequence/) — `lengthOfLIS`; [62 Unique Paths](https://leetcode.com/problems/unique-paths/) — `uniquePaths`; [91 Decode Ways](https://leetcode.com/problems/decode-ways/) — `numDecodings`; [416 Partition Equal Subset Sum](https://leetcode.com/problems/partition-equal-subset-sum/) — `canPartition` |
| [Backtracking](src/main/java/com/jatinahuja/practice/BacktrackingPractice.java) | [78 Subsets](https://leetcode.com/problems/subsets/) — `BacktrackingPractice.subsets`; [46 Permutations](https://leetcode.com/problems/permutations/) — `permutations`; [39 Combination Sum](https://leetcode.com/problems/combination-sum/) — `combinationSum`; [22 Generate Parentheses](https://leetcode.com/problems/generate-parentheses/) — `generateParenthesis` |
| [Linked lists](src/main/java/com/jatinahuja/practice/LinkedListPractice.java) | [206 Reverse Linked List](https://leetcode.com/problems/reverse-linked-list/) — `LinkedListPractice.reverseList`; [21 Merge Two Sorted Lists](https://leetcode.com/problems/merge-two-sorted-lists/) — `mergeTwoLists`; [141 Linked List Cycle](https://leetcode.com/problems/linked-list-cycle/) — `hasCycle` |
| [Binary trees](src/main/java/com/jatinahuja/practice/TreePractice.java) | [104 Maximum Depth of Binary Tree](https://leetcode.com/problems/maximum-depth-of-binary-tree/) — `TreePractice.maxDepth`; [98 Validate Binary Search Tree](https://leetcode.com/problems/validate-binary-search-tree/) — `isValidBST`; [94 Binary Tree Inorder Traversal](https://leetcode.com/problems/binary-tree-inorder-traversal/) — `inorderTraversal` |
| [Graphs](src/main/java/com/jatinahuja/practice/GraphPractice.java) | [200 Number of Islands](https://leetcode.com/problems/number-of-islands/) — `GraphPractice.numIslands`; [207 Course Schedule](https://leetcode.com/problems/course-schedule/) — `canFinish`; [733 Flood Fill](https://leetcode.com/problems/flood-fill/) — `floodFill` |

These reference implementations are covered by
[`PracticeSolutionsTest`](src/test/java/com/jatinahuja/practice/PracticeSolutionsTest.java).

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
├── main/java/com/jatinahuja/leetcode/    # Publicly sourced LeetCode solution
├── main/java/com/jatinahuja/practice/    # Practice/reference implementations
└── test/java/                            # JUnit 5 tests
```

## LeetCode profile

[View profile](https://leetcode.com/u/2403051050553/)
