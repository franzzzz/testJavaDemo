import java.util.HashMap;
import java.util.List;

public class T6_hashMapTree {
    public static void main(String[] argv){
        Q6_hashMapTree h = new Q6_hashMapTree();
        HashMap<Integer, List<Integer>> map =  h.initial();
        System.out.println(h.hashMapTree(map));
    }


}
