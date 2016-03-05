package com.zyb.solutions;

import java.util.HashMap;

public class Solution {
	/**
	 * 10. Regular Expression Matching
	 */
	public boolean isMatch(String s, String p) {
		return false;
	}

	/**
	 * 7. Reverse Integer
	 */
	public int reverse(int x) {
		if (x == 0) {
			return x;
		}
		int i = 0;
		int j = x;
		int result = 0;
		while (i == 0) {
			i = j % 10;
			j /= 10;
			result += i;
		}
		while (j != 0) {
			if ((result == 214748364 && j > 7) || (result > 214748364)
					|| (result == -214748364 && j < -8)
					|| (result < -214748364)) {
				return 0;
			}
			result = result * 10 + j % 10;
			j /= 10;
		}
		return result;
	}

	/**
	 * 6. ZigZag Conversion
	 */
	public String convert(String s, int numRows) {
		if (numRows >= s.length() || numRows == 1) {
			return s;
		}
		int index = 0;
		StringBuffer sb = new StringBuffer();
		for (int i = 1; i <= numRows; i++) {
			index = i - 1;
			while (index < s.length()) {
				if (i == 1 || i == numRows) {
					sb.append(s.charAt(index));
					index += (2 * (numRows - 1));
					continue;
				}
				sb.append(s.charAt(index));
				index += (2 * (numRows - i));
				if (index < s.length()) {
					sb.append(s.charAt(index));
					index += (2 * (i - 1));
				}

			}
		}
		return sb.toString();
	}

	/**
	 * 5. Longest Palindromic Substring
	 */

	public String longestPalindrome(String s) {
		if (s.length() == 0 || s.length() == 1) {
			return s;
		}
		int start = 0;
		int maxLength = 0;
		for (int i = 0; i < s.length();) {
			int left = i;
			int right = i;
			while (left >= 0 && s.charAt(i) == s.charAt(left)) {
				left--;
			}
			while (right < s.length() && s.charAt(i) == s.charAt(right)) {
				right++;
			}
			if (right > i) {
				i = right;
			} else {
				i++;
			}
			while (left >= 0 && right < s.length()) {
				if (s.charAt(left) == s.charAt(right)) {
					left--;
					right++;
				} else {
					break;
				}
			}
			if (right - left - 1 > maxLength) {
				start = left + 1;
				maxLength = right - left - 1;
			}
		}
		return s.substring(start, start + maxLength);
	}

	/**
	 * 4. Median of Two Sorted Arrays
	 */
	public double findMedianSortedArrays(int[] nums1, int[] nums2) {
		if (nums1.length == 0) {
			if (nums2.length % 2 == 0) {
				return (nums2[nums2.length / 2 - 1] + nums2[nums2.length / 2]) * 1.0 / 2;
			} else {
				return nums2[nums2.length / 2];
			}
		}
		if (nums2.length == 0) {
			if (nums1.length % 2 == 0) {
				return (nums1[nums1.length / 2 - 1] + nums1[nums1.length / 2]) * 1.0 / 2;
			} else {
				return nums1[nums1.length / 2];
			}
		}
		int i = 0;
		int j = 0;
		int current = 0;
		int last = current;
		int count = 0;
		while (count < (nums1.length + nums2.length) / 2 + 1) {
			last = current;
			int index1 = nums1[nums1.length - 1] >= nums1[0] ? i : nums1.length
					- 1 - i;
			int index2 = nums2[nums2.length - 1] >= nums2[0] ? j : nums2.length
					- 1 - j;
			if (i < nums1.length) {
				if (j < nums2.length) {
					if (nums1[index1] <= nums2[index2]) {
						current = nums1[index1];
						i++;
					} else {
						current = nums2[index2];
						j++;
					}
				} else {
					current = nums1[index1];
					i++;
				}
			} else {
				current = nums2[index2];
				j++;
			}
			count++;
		}
		return (nums1.length + nums2.length) % 2 == 0 ? (current + last) * 1.0 / 2
				: current;

	}

	/**
	 * 3. Longest Substring Without Repeating Characters
	 */
	public int lengthOfLongestSubstring(String s) {
		if (s.length() == 0 || s.length() == 1) {
			return s.length();
		}
		int max = 1;
		int tmp = 1;
		int index;
		for (int right = 1; right < s.length(); right++) {
			index = s.substring(right - tmp, right).indexOf(s.charAt(right));
			if (index == -1) {
				tmp++;
			} else {
				max = max > tmp ? max : tmp;
				tmp = tmp - index;
			}
		}
		return max > tmp ? max : tmp;
	}

	public static class ListNode {
		int val;
		ListNode next;

		ListNode(int x) {
			val = x;
		}
	}

	/**
	 * 2. Add Two Numbers
	 */
	public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		if (l1 == null) {
			return l2;
		}
		if (l2 == null) {
			return l1;
		}
		int current;
		ListNode result = null;
		ListNode now = null;
		ListNode next = null;
		boolean isNeedCarry = false;
		while (l1 != null || l2 != null) {
			if (l1 != null && l2 != null) {
				current = l1.val + l2.val + (isNeedCarry ? 1 : 0);
			} else {
				current = (l1 == null ? l2.val : l1.val)
						+ (isNeedCarry ? 1 : 0);
			}
			isNeedCarry = current > 9;
			next = new ListNode(current % 10);
			if (result == null) {
				result = now = next;
			} else {
				now.next = next;
				now = next;
			}
			l1 = l1 == null ? null : l1.next;
			l2 = l2 == null ? null : l2.next;
		}
		if (isNeedCarry) {
			now.next = new ListNode(1);
		}
		return result;
	}

	/**
	 * 1. Two Sum
	 */
	public int[] twoSum(int[] nums, int target) {
		int[] result = new int[2];
		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
		for (int i = 0; i < nums.length; i++) {
			if (map.containsKey(target - nums[i])) {
				result[0] = map.get(target - nums[i]) + 1;
				result[1] = i + 1;
				return result;
			} else {
				map.put(nums[i], i);
			}
		}
		return null;
	}
}
