package problem1446;

/**
 * @author yinrongjie
 * @version 1.0
 * @date 2021/12/1
 * @description 连续字符（使用一个变量）
 */
public class Solution1 {
    public int maxPower(String s) {
        if (s == null || "".equals(s)) {
            return 0;
        }
        char[] chars = s.toCharArray();
        int res = 1;
        int count = 1;

        for (int i = 1; i < chars.length; i++) {
            if (chars[i] == chars[i - 1]) {
                count++;
                res = Math.max(res, count);
            } else {
                // 当遍历到第一个不符合条件的时候才需要重新初始化count
                count = 1;
            }
        }

        return res;
    }
}
