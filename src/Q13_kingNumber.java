import java.util.*;

public class Q13_kingNumber {
    /*
    //K window size of K
    //M the max value of array A(min is 1)
    //A array of positive int
    //ask for all King number with ascending order
    //for window K, add 1 for each number in it.
    //so if K == 3, 1 3 5 6 7 -> 1 (4 6 7) 7, only use K one time.
    //King number is those number which follow the rule of occur more than half length of array.
    //if there is no king number, return original A.
    */
    public int[] major(int K, int M, int[] A) {
        if(A == null || A.length == 0) {
            return new int[0];
        }
        HashSet<Integer> sumResult = new HashSet<>();
        Map<Integer, Integer> freqMap = new HashMap<>();
        //init
        //if it could be larger than half, set its freq to -1
        for(int i = 0; i < K; i++) {
            if(!freqMap.containsKey(A[i]+1)) {
                freqMap.put(A[i]+1, 1);
            } else if (freqMap.get(A[i]+1) > 0) {
                if (freqMap.get(A[i]+1) + 1 > A.length/2) {
                    freqMap.put(A[i]+1, -1);
                    sumResult.add(A[i]+1);
                } else {
                    freqMap.put(A[i]+1, freqMap.get(A[i]+1) + 1);
                }
            }

        }
        for(int i = K; i < A.length; i++) {
            if(!freqMap.containsKey(A[i])) {
                freqMap.put(A[i], 1);
            } else if (freqMap.get(A[i]) > 0) {
                if (freqMap.get(A[i]) + 1 > A.length/2) {
                    freqMap.put(A[i], -1);
                    sumResult.add(A[i]);
                } else {
                    freqMap.put(A[i], freqMap.get(A[i]) + 1);
                }
            }

        }

        for(Map.Entry<Integer, Integer> cur : freqMap.entrySet()) {
            System.out.println(cur.getKey() + " - " + cur.getValue());
        }
        System.out.println("-------------");

        for(int i = 0; i < A.length - K; i++) {
            //A[i]++, A[i]+1--
            if(!freqMap.containsKey(A[i])) {
                freqMap.put(A[i], 1);
            } else if (freqMap.get(A[i]) > 0) {
                if (freqMap.get(A[i]) + 1 > A.length/2) {
                    freqMap.put(A[i], -1);
                    sumResult.add(A[i]);
                } else {
                    freqMap.put(A[i], freqMap.get(A[i]) + 1);
                }
            }
            freqMap.put(A[i]+1, freqMap.get(A[i]+1)-1);

            //A[i+K]+1++, A[i+K]--
            if(!freqMap.containsKey(A[i + K]+1)) {
                freqMap.put(A[i + K]+1, 1);
            } else if (freqMap.get(A[i + K]+1) > 0) {
                if (freqMap.get(A[i + K]+1) + 1 > A.length/2) {
                    freqMap.put(A[i + K]+1, -1);
                    sumResult.add(A[i + K]+1);
                } else {
                    freqMap.put(A[i + K]+1, freqMap.get(A[i + K]+1) + 1);
                }
            }
            freqMap.put(A[i + K], freqMap.get(A[i + K]) - 1);

            for(Map.Entry<Integer, Integer> cur : freqMap.entrySet()) {
                System.out.println(cur.getKey() + " - " + cur.getValue());
            }
            System.out.println("-------------");
        }


        if (sumResult == null || sumResult.size() == 0) {
            return null;
        }

        System.out.println(sumResult);

        int[] result = new int[sumResult.size()];
        int counterResult = 0;

        for(Integer cur : sumResult) {
            result[counterResult] = cur;
            counterResult++;
        }

        return result;
    }
}
