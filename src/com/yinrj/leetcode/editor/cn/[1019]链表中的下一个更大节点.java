package com.yinrj.leetcode.editor.cn;//给定一个长度为 n 的链表 head
//
// 对于列表中的每个节点，查找下一个 更大节点 的值。也就是说，对于每个节点，找到它旁边的第一个节点的值，这个节点的值 严格大于 它的值。 
//
// 返回一个整数数组 answer ，其中 answer[i] 是第 i 个节点( 从1开始 )的下一个更大的节点的值。如果第 i 个节点没有下一个更大的节点
//，设置 answer[i] = 0 。 
//
// 
//
// 示例 1： 
//
// 
//
// 
//输入：head = [2,1,5]
//输出：[5,5,0]
// 
//
// 示例 2： 
//
// 
//
// 
//输入：head = [2,7,4,3,5]
//输出：[7,0,5,5,0]
// 
//
// 
//
// 提示： 
//
// 
// 链表中节点数为 n 
// 1 <= n <= 10⁴ 
// 1 <= Node.val <= 10⁹ 
// 
//
// Related Topics 栈 数组 链表 单调栈 👍 296 👎 0


//leetcode submit region begin(Prohibit modification and deletion)

import java.util.Arrays;
import java.util.LinkedList;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution1019 {
    public int[] nextLargerNodes(ListNode head) {
        LinkedList<Pair> stack = new LinkedList<>();

        int index = 0;
        ListNode point = head;

        int count = 0;
        while (point != null) {
            count++;
            point = point.next;
        }

        point = head;

        int[] res = new int[count];

        Arrays.fill(res, 0);

        while (point != null) {
            int value = point.val;
            while (!stack.isEmpty() && value > stack.getLast().value) {
                Pair top = stack.removeLast();
                res[top.index] = value;
            }
            Pair pair = new Pair();
            pair.index = index;
            pair.value = value;
            stack.add(pair);
            ++index;
            point = point.next;
        }


        return res;
    }

    static class Pair {
        public int value;
        public int index;
    }

}
//leetcode submit region end(Prohibit modification and deletion)
