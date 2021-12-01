# leetcode题解
## [1446. 连续字符](https://leetcode-cn.com/problems/consecutive-characters/)
![](https://yin-typora.oss-cn-beijing.aliyuncs.com/uPic/ZJ3pQh.png)
### 一次遍历
```java
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
```
```java
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
```
