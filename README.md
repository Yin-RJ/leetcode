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

## [506. 相对名次](https://leetcode-cn.com/problems/relative-ranks/)
![](https://yin-typora.oss-cn-beijing.aliyuncs.com/idea/2021-12-02-4GnTWG.png)
平平无奇，排序就好。
```java
package problem506;

import java.util.*;

/**
 * @author yinrongjie
 * @version 1.0
 * @date 2021/12/2
 * @description 相对名次
 */
public class Solution {
    public String[] findRelativeRanks(int[] score) {
        if (score == null || score.length == 0) {
            return new String[0];
        }

        List<Integer> scoreList = new ArrayList<>();
        Arrays.stream(score).forEach(scoreList::add);

        scoreList.sort((a, b) -> b - a);
        Map<Integer, String> map = new HashMap<>();
        for (int i = 1; i <= score.length; i++) {
            int item = scoreList.get(i - 1);
            if (i == 1) {
                map.put(item, "Gold Medal");
            } else if (i == 2) {
                map.put(item, "Silver Medal");
            } else if (i == 3) {
                map.put(item, "Bronze Medal");
            } else {
                map.put(item, String.valueOf(i));
            }
        }

        String[] result = new String[score.length];
        int i = 0;

        for (int item : score) {
            result[i++] = map.get(item);
        }
        return result;
    }
}
```
