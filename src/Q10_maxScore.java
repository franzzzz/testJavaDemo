import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

public class Q10_maxScore {
//    public void findMax(int[] array) {
//        if (array == null || array.length == 0) {
//            return;
//        }
//        int max = Integer.MIN_VALUE;
//        HashSet<Integer> set = new HashSet<>();
//        findMaxHelper(array, 0, set, max, 0);
//        System.out.println(max);
//    }
//
//    private void  findMaxHelper(int[] array, int index, HashSet<Integer> set, int max, int cur) {
//        if (index == array.length) {
//            max = Math.max(max, cur);
//            return;
//        }
//        findMaxHelper(array, index + 1, set, max, cur);
//        if (!set.contains(array[index])) {
//            set.add(array[index]-1);
//            set.add(array[index]+1);
//            findMaxHelper(array, index+1, set, max, cur + array[index]);
//            set.remove(array[index+1]);
//            set.remove(array[index-1]);
//        }
//    }

    public void findMax(int[] array) {
        int allSum = 0;
        HashMap<Integer, Integer> feq = new HashMap<>();
        for(int num : array) {
            allSum += num;
            if (!feq.containsKey(num)) {
                feq.put(num, 1);
            } else {
                feq.put(num, feq.get(num)+1);
            }
        }
        int[] dp = new int[allSum];
        dp[0] = 0;
        if (feq.containsKey(1)) {
            dp[1] = feq.get(1);
        } else {
            dp[1] = 0;
        }
        for (int i = 2; i <= allSum; i++) {
            dp[i] = Integer.max(dp[i-2] + feq.get(i) * i, dp[i-1]);
        }
        System.out.println(dp[allSum]);

    }
}
