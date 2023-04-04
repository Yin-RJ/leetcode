package com.yinrj.acwing.problem282;

import java.util.Arrays;

/**
 * @author yinrongjie
 * @date 2023/4/4
 * @name Solution282
 */
public class Solution282 {
    public int getResult(int[] stones) {
        final int inf = 0x3f3f3f3f;
        int n = stones.length;

        if (n == 0 || n == 1) {
            return 0;
        }

        int[][] dp = new int[n][n];

        // 前缀和
        int[] sum = new int[n + 1];
        for (int i = 1; i <= n; ++i) {
            sum[i] = sum[i - 1] + stones[i - 1];
        }

        for (int i = 0; i < n; ++i) {
            Arrays.fill(dp[i], inf);
        }

        for (int i = 0; i < n; ++i) {
            dp[i][i] = 0;
        }

        for (int len = 2; len <= n; ++len) {
            // 枚举起点
            for (int i = 0; i + len - 1 < n; ++i) {
                int j = i + len - 1;
                for (int k = j - 1; k >= i; --k) {
                    dp[i][j] = Math.min(dp[i][j], dp[i][k] + dp[k + 1][j] + sum[j + 1] - sum[i]);
                }
            }
        }

        return dp[0][n - 1];
    }

}
