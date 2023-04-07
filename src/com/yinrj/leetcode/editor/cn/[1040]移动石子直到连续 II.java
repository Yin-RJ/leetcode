package com.yinrj.leetcode.editor.cn;//在一个长度 无限 的数轴上，第 i 颗石子的位置为 stones[i]。如果一颗石子的位置最小/最大，那么该石子被称作 端点石子 。
//
// 每个回合，你可以将一颗端点石子拿起并移动到一个未占用的位置，使得该石子不再是一颗端点石子。 
//
// 值得注意的是，如果石子像 stones = [1,2,5] 这样，你将 无法 移动位于位置 5 的端点石子，因为无论将它移动到任何位置（例如 0 或 3）
//，该石子都仍然会是端点石子。 
//
// 当你无法进行任何移动时，即，这些石子的位置连续时，游戏结束。 
//
// 要使游戏结束，你可以执行的最小和最大移动次数分别是多少？ 以长度为 2 的数组形式返回答案：answer = [minimum_moves, 
//maximum_moves] 。 
//
// 
//
// 示例 1： 
//
// 
//输入：[7,4,9]
//输出：[1,2]
//解释：
//我们可以移动一次，4 -> 8，游戏结束。
//或者，我们可以移动两次 9 -> 5，4 -> 6，游戏结束。
// 
//
// 示例 2： 
//
// 
//输入：[6,5,4,3,10]
//输出：[2,3]
//解释：
//我们可以移动 3 -> 8，接着是 10 -> 7，游戏结束。
//或者，我们可以移动 3 -> 7, 4 -> 8, 5 -> 9，游戏结束。
//注意，我们无法进行 10 -> 2 这样的移动来结束游戏，因为这是不合要求的移动。
// 
//
// 示例 3： 
//
// 
//输入：[100,101,104,102,103]
//输出：[0,0] 
//
// 
//
// 提示： 
//
// 
// 3 <= stones.length <= 10^4 
// 1 <= stones[i] <= 10^9 
// stones[i] 的值各不相同。 
// 
//
// 
//
// Related Topics 数组 数学 双指针 排序 👍 194 👎 0


import java.util.Arrays;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution1040 {
    public int[] numMovesStonesII(int[] stones) {
        int[] res = new int[2];
        int n = stones.length;

        Arrays.sort(stones);
        // 求最大值，计算出来两个端点之间有多少个空位
        int m = stones[n - 1] - stones[0] - (n - 1);
        // 分两种情况，从左边移动还是从右边移动，端点到下一个点的位置一定不能使用
        res[1] = m - Math.min(stones[1] - stones[0] - 1, stones[n - 1] - stones[n - 2] - 1);

        res[0] = Integer.MAX_VALUE;

        // 求最小值，找出来长度为n的时候最多有多少石子，移动的次数一定大于等于空位的次数
        for (int i = 0, j = 0; i < n; ++i) {
            while (stones[i] - stones[j] + 1 > n) {
                j++;
            }

            // 最多的石子数
            m = i - j + 1;
            int r;
            if (m == n - 1 && stones[i] - stones[j] == i - j) {
                // 恰好有一颗石子落在一个没有空位的有序石子外面
                r = 2;
            } else {
                r = n - m;
            }

            res[0] = Math.min(res[0], r);
        }
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
