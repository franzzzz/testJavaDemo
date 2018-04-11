
public class Q12_StringRemoveSame {

    public String removeSame(String S) {
        if (S == null || S.length() == 0) {
            return "";
        }
        if (S.length() == 1) {
            return S;
        }
        //match those character from beginning
        char[] array = new char[S.length()];
        int index = -1;
        int end = 0;
        while(end != array.length) {
            if (index != -1 && array[index] == S.charAt(end)) {
                index--;
                end++;
                System.out.println("index = " + index + " end = " + end);
            } else {
                index++;
                array[index] = S.charAt(end);
                end++;
                System.out.println("index = " + index + " end = " + end);
                System.out.println(array[index]);
            }
        }
        if (index == -1) {
            return "";
        }
        System.out.println(array);
        return String.valueOf(array).substring(0, index+1);

    }

}
