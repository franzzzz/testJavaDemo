import java.util.LinkedList;
import java.util.List;

public class Q7_addOperations {
    public List<String> addOperators(String num, int target) {
        List<String> result = new LinkedList<>();
        //List<List<String>> test = new LinkedList<>();
        if (num == null || num.length() == 0) {
            return result;
        }
        insertOperators(result, "", num, target, 0, 0, 0);
        return result;
    }

    private void insertOperators(List<String> result, String sen, String num, int target, int pos,
                                 long curVal, long revert) {
        if (pos == num.length()) {
            if (curVal == target) {
                result.add(sen);
            }
            return;
        }
        for (int i = pos; i < num.length(); i++) {
            if (i != pos && num.charAt(pos) == '0') {
                break;
            }
            long cur = Long.parseLong(num.substring(pos, i + 1));
            if (pos == 0) {
                insertOperators(result, sen + cur, num, target, i + 1, curVal + cur, cur);
            } else {
                insertOperators(result, sen + "+" + cur, num, target, i + 1, curVal + cur, cur);
                insertOperators(result, sen + "-" + cur, num, target, i + 1, curVal - cur, -cur);
                insertOperators(result, sen + "*" + cur, num, target, i + 1, curVal - revert + cur * revert, cur * revert);
            }

        }
        return;
    }

}
