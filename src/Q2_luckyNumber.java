import java.lang.Math.*;

import static  java.lang.Math.pow;

public class Q2_luckyNumber {
    //首先判断一个数字是不是lucky的(数字里不能带4，因为在中文是死的意思），
    // 然后第一个followup是给出一个整数之前的lucky数字的数量，
    // 第二个是如何显示出一个每个unlucky的数字

    //To solve this problem, we need to check those digits one by one
    public int Q2_luckyNumber(int num) {
//        boolean result = true;
//        while(num >= 1) {
//            int remainder = num%10;
//            if (remainder == 4) {
//                result = false;
//            }
//            num = num/10;
//        }
//        return result;

        int count = 0;
        int firstDigit = 0;
        while(num >= 1) {
            firstDigit = num%10;
            num = num/10;
            count++;
        }
        if (firstDigit >= 4) {
            return (int)((firstDigit-1) * pow(9, count-1));
        }
        return (int)(firstDigit * pow(9, count-1));

        //follow up two: O(n of num)
    }

}
