import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class T13_kingNumber {
    public static void main(String[] argv) {
        Q13_kingNumber k = new Q13_kingNumber();
        int[] A = {2, 1, 1, 1, 3, 4, 1, 3, 1};
        int[] result = k.major(3, 5, A);
        for(int cur : result) {
            System.out.println(cur);
        }
    }
}
