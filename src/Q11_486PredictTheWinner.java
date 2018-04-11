public class Q11_486PredictTheWinner {
    public int predictTheWinner(int[] nums) {
        int[][] dp = new int[nums.length][nums.length];
        for(int i = 0; i < nums.length; i++) {
            dp[i][i] = nums[i];
        }

        for(int i = 2; i < nums.length; i++) {
            for(int j = 0; j < nums.length - i; j++) {
                dp[j][j + i] = Math.max(Math.min(dp[j + 1][j + i - 1], dp[j + 2][j + i]) + nums[j],
                                        Math.min(dp[j][j + i - 2], dp[j + 1][j + i - 1]) + nums[j + i]
                                );
            }
        }

        return dp[0][nums.length-1];
    }
}
