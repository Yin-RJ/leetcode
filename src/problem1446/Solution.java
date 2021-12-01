package problem1446;

/**
 * @author yinrongjie
 * @version 1.0
 * @date 2021/12/1
 * @description 连续字符
 */
public class Solution {
    public int maxPower(String s) {
        if (s == null || "".equals(s)) {
            return 0;
        }
        char[] chars = s.toCharArray();
        int first = 0;
        int second = 0;
        int len = chars.length;
        int res = 0;

        while (second < len) {
            char ch = chars[first];
            while (second < len && ch == chars[second]) {
                second++;
            }
            // 注意这里获取second指针和first指针之间距离是不需要额外加1的
            res = Math.max(res, second - first);
            first = second;
        }

        return res;
    }
}
