import java.util.List;

public class T7_addOperations {
    public static void main (String[] argv) {
        String example = "012304";
        int k = 37;
        if (example == null) {
            return;
        }
        Q7_addOperations a = new Q7_addOperations();
        List<String> result = a.addOperators(example, 1);
        System.out.println(result);
    }

}
