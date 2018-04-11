public class Q3_DPgrid {
    //dp题。给一个grid的宽和长，求得从左下的点到右下的点所有可能的路径之和。
    //起点当然是左下，要求每次只能走三个方向， ➡↗↘
    //follow up: 2d dp -> 1d dp
    public int DPgrid(int a, int b) {

//        //for all node(x, y),  we could get it from three direction
//        //➡ : if(x-1, y) is in the border
//        //↗ : if(x-1, y-1) is in the border
//        //↘ : if(x-1, y+1) is in the border
//        //f(x, y) = f(x-1, y) + f(x-1, y-1) + f(x-1, y+1)
//        int[][] dp = new int[a][b];
//        dp[0][b-1] = 1;
//        for(int i = 0; i < a; i++) {
//            for(int j = 0; j < b; j++) {
//                if(i - 1 >= 0) {
//                    dp[i][j] += dp[i-1][j];
//                    if (j - 1 >= 0) {
//                        dp[i][j] += dp[i-1][j-1];
//                    }
//                    if (j + 1 < b) {
//                        dp[i][j] += dp[i-1][j+1];
//                    }
//                }
//            }
//        }
//        for(int j = 0; j < b; j++) {
//            for(int i = 0; i < a; i++) {
//                System.out.println(dp[i][j]);
//            }
//            System.out.println("\n");
//
//        }
//        return dp[a-1][b-1];

        //follow up: try to use a one-dimension array to convey the only useful column in current time
        //And because current value need contibute from three value ➡↗↘
        //So at lease use two extra value, could also use three or another array[b] to save last result;
        int[] dp = new int[b];
        dp[b-1] = 1;
        int firstVal = dp[0];
        int secondVal = dp[1];
        //need to concern about corner case
        for(int i = 1; i < a; i++) {
            for(int j = 0; j < b; j++) {
                if (j == b-1) {
                    dp[j] = firstVal + secondVal;
                } else {
                    dp[j] = firstVal + secondVal;
                    firstVal = secondVal;
                    secondVal = dp[j + 1];
                    dp[j] += secondVal;
                }
            }
        }
        return dp[b-1];
    }

}
