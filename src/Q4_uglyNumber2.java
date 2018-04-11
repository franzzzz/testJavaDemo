public class Q4_uglyNumber2 {
    //https://leetcode.com/problems/ugly-number-ii/description/
    //leetcode 264
    public int Q4_uglyNumber2(int n) {
        int[] num = new int[n];
        num[0] = 1;
        int index2 = 0;
        int index3 = 0;
        int index5 = 0;
        for (int i = 1; i < n; i++) {
            num[i] = Math.min(Math.min(num[index2] * 2, num[index3] * 3), num[index5] * 5);
            if (num[i] == num[index2] * 2) {
                index2++;
            }
            if (num[i] == num[index3] * 3) {
                index3++;
            }
            if (num[i] == num[index5] * 5) {
                index5++;
            }
        }
        return num[n-1];
    }
}
