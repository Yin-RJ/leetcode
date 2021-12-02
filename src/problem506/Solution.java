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
