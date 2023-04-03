package com.yinrj.leetcode.editor.cn;//给你一个正整数数组 arr（可能存在重复的元素），请你返回可在 一次交换（交换两数字 arr[i] 和 arr[j] 的位置）后得到的、按字典序排列小于
//arr 的最大排列。 
//
// 如果无法这么操作，就请返回原数组。 
//
// 
//
// 示例 1： 
//
// 
//输入：arr = [3,2,1]
//输出：[3,1,2]
//解释：交换 2 和 1
// 
//
// 示例 2： 
//
// 
//输入：arr = [1,1,5]
//输出：[1,1,5]
//解释：已经是最小排列
// 
//
// 示例 3： 
//
// 
//输入：arr = [1,9,4,6,7]
//输出：[1,7,4,6,9]
//解释：交换 9 和 7
// 
//
// 
//
// 提示： 
//
// 
// 1 <= arr.length <= 10⁴ 
// 1 <= arr[i] <= 10⁴ 
// 
//
// Related Topics 贪心 数组 👍 123 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution1053 {
    public int[] prevPermOpt1(int[] arr) {
        if (arr == null || arr.length <= 1) {
            return arr;
        }

        int end = arr.length - 1;

        // 从后往前找到第一个能交换的位置，这个位置后面的序列是一个字典序最小的（从后往前是个降序的序列）
        for (int i = end - 1; i >= 0; --i) {
            if (arr[i] > arr[i + 1]) {
                // 要找到比这个数小的最大值
                int j = i + 1;
                // j是i+1的时候一定符合条件，从j+1开始遍历
                while (j + 1 <= end && arr[j + 1] < arr[i]) {
                    ++j;
                }
                // 如果有相等的符合条件的，交换第一个
                while (arr[j] == arr[j - 1]) {
                    --j;
                }
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
                return arr;
            }
        }

        return arr;
    }


}
//leetcode submit region end(Prohibit modification and deletion)
