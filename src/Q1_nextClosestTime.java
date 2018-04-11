import java.util.HashMap;
import java.util.Map;

class Q1_nextClosestTime {
    int minDis = Integer.MAX_VALUE;
    Map<Integer, Integer> freqMap = new HashMap<>();
    String result = "false";
    int[] digital = new int[4];
    public String nextClosestTime(String S) {
         initMap(S);

        //if they all the same?
        digital[0] = Integer.parseInt(S.substring(0, 1));
        digital[1] = Integer.parseInt(S.substring(1, 2));
        digital[2] = Integer.parseInt(S.substring(3, 4));
        digital[3] = Integer.parseInt(S.substring(4, 5));

        //dfs2(new int[4], 0, digital);
        dfs1(new int[4], 0);

        return result;
    }

    private void dfs1(int[] sample, int index) {
        if (index == 4) {
            int curDis = compareDis(sample, digital);
            if (minDis > curDis) {
                minDis = curDis;
                result = formatTime(sample, 0, 1) + ":" + formatTime(sample, 2, 3);
            }
        } else {
            for (Map.Entry<Integer, Integer> entry : freqMap.entrySet()) {
                if (entry.getValue() == 0) {
                    continue;
                } else {
                    int curKey = entry.getKey();
                    if (index == 0) {
                        if (curKey > 2) {
                            continue;
                        }
                    }
                    if (index == 1) {
                        if (sample[0] * 10 + curKey > 23) {
                            continue;
                        }
                    }
                    if (index == 2) {
                        if (curKey > 5) {
                            continue;
                        }
                    }
                    sample[index] = curKey;
                    freqMap.put(curKey, entry.getValue()-1);
                    dfs1(sample, index+1);
                    freqMap.put(curKey, entry.getValue()+1);
                }

            }
        }
    }

    private void dfs2(int[] sample, int index, int[] digital) {
        if (index == 4) {
            int curDis = compareDis(sample, digital);
            if (minDis > curDis) {
                minDis = curDis;
                result = formatTime(sample, 0, 1) + ":" + formatTime(sample, 2, 3);
            }
        } else {
            for (int i = 0; i < digital.length; i++) {
                if (index == 0) {
                    if (digital[i] > 2) {
                        continue;
                    }
                }
                if (index == 1) {
                    if (sample[0] * 10 + digital[i] > 23) {
                        continue;
                    }
                }
                if (index == 2) {
                    if (digital[i] > 5) {
                        continue;
                    }
                }
                sample[index] = digital[i];
                dfs2(sample, index+1, digital);
            }
        }
    }

    private String formatTime(int[] sample, int a, int b) {
        if (sample[a] == 0) {
            return "0" + sample[b];
        }
        else {
            return Integer.toString(sample[a] * 10 + sample[b]);
        }
    }

    private int compareDis(int[] sample, int[] digital) {
        int sampleMinu = (sample[0] * 10 + sample[1]) * 60 + sample[2] * 10 + sample[3];
        int digitalMinu = (digital[0] * 10 + digital[1]) * 60 + digital[2] * 10 + digital[3];
        if (sampleMinu > digitalMinu) {
            return sampleMinu - digitalMinu;
        } else {
            return sampleMinu + 1440 - digitalMinu;
        }

    }

     private void initMap(String time) {
        for (int index = 0; index < time.length(); index++) {
            if (index == 2) {
                continue;
            }
            int curNum = Integer.parseInt(time.substring(index, index+1));
            if (freqMap.containsKey(curNum)) {
                freqMap.put(curNum, freqMap.get(curNum)+1);
            } else {
                freqMap.put(curNum, 1);
            }
        }
     }

}
