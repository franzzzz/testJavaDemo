import java.util.ArrayList;
import java.util.List;

public class Q5_subset1 {
    public List<String> subSets(String set) {
        StringBuilder sb = new StringBuilder();
        if (set == null) {
            return new ArrayList<String>();
        }
        List<String> result = new ArrayList<String>();
        dfs(set, 0, sb, result);
        return result;
    }

    private void dfs(String set, int index, StringBuilder sb, List<String> result) {
        if (index == set.length()) {
            result.add(sb.toString());
            return;
        }
        //not add index
        dfs(set, index+1, sb, result);
        //add index
        sb.append(set.charAt(index));
        dfs(set, index+1, sb, result);
        //sb.deleteCharAt(index);
        //couldnt be index, because them dont get all of it.
        sb.deleteCharAt(sb.length()-1);
    }
}
