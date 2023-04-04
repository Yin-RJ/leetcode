package com.yinrj.leetcode.editor.cn;//有 N 堆石头排成一排，第 i 堆中有 stones[i] 块石头。
//
// 每次移动（move）需要将连续的 K 堆石头合并为一堆，而这个移动的成本为这 K 堆石头的总数。 
//
// 找出把所有石头合并成一堆的最低成本。如果不可能，返回 -1 。 
//
// 
//
// 示例 1： 
//
// 输入：stones = [3,2,4,1], K = 2
//输出：20
//解释：
//从 [3, 2, 4, 1] 开始。
//合并 [3, 2]，成本为 5，剩下 [5, 4, 1]。
//合并 [4, 1]，成本为 5，剩下 [5, 5]。
//合并 [5, 5]，成本为 10，剩下 [10]。
//总成本 20，这是可能的最小值。
// 
//
// 示例 2： 
//
// 输入：stones = [3,2,4,1], K = 3
//输出：-1
//解释：任何合并操作后，都会剩下 2 堆，我们无法再进行合并。所以这项任务是不可能完成的。.
// 
//
// 示例 3： 
//
// 输入：stones = [3,5,1,2,6], K = 3
//输出：25
//解释：
//从 [3, 5, 1, 2, 6] 开始。
//合并 [5, 1, 2]，成本为 8，剩下 [3, 8, 6]。
//合并 [3, 8, 6]，成本为 17，剩下 [17]。
//总成本 25，这是可能的最小值。
// 
//
// 
//
// 提示： 
//
// 
// 1 <= stones.length <= 30 
// 2 <= K <= 30 
// 1 <= stones[i] <= 100 
// 
//
// Related Topics 数组 动态规划 👍 310 👎 0


import java.util.Arrays;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int mergeStones(int[] stones, int m) {
        final int inf = 0x3f3f3f3f;

        int n = stones.length;

        if ((n - 1) % (m - 1) != 0) {
            return -1;
        }

        // 前缀和
        int[] sum = new int[n + 1];
        for (int i = 1; i <= n; ++i) {
            sum[i] = sum[i -1] + stones[i - 1];
        }

        // 状态数组
        int[][][] dp = new int[n][n][m + 1];
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < n; ++j) {
                Arrays.fill(dp[i][j], inf);
            }
        }

        // 如果已经是1堆了，则不需要合并，成本为0
        for (int i = 0; i < n; ++i) {
            dp[i][i][1] = 0;
        }

        // 枚举长度
        for (int len = 2; len <= n; ++len) {
            // 枚举起点
            for (int i = 0; i + len - 1 < n; ++i) {
                // 终点
                int j = i + len - 1;
                // 枚举k，我们在划分的时候是区别了最后一堆出来，所以我们当k=1时需要特殊处理
                for (int k = 2; k <= m; ++k) {
                    // 枚举最后一个堆的起点，基于优化点2，u可以一次减少m-1
                    for (int u = j - 1; u >= i; u -= (m - 1)) {
                        dp[i][j][k] = Math.min(dp[i][j][k], dp[i][u][k - 1] + dp[u + 1][j][1]);
                    }
                }

                // k为1的时候一定是将m堆合并成了1堆
                dp[i][j][1] = dp[i][j][m] + sum[j + 1] - sum[i];
            }
        }


        return dp[0][n - 1][1];
    }
}
//leetcode submit region end(Prohibit modification and deletion)
