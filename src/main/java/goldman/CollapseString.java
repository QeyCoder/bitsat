package goldman;

/**
 * Created by Gaurav on 04/03/18.
 */


public class CollapseString {


    public static void main(String[] args) {
        System.out.println(collapseString("GGGGGrrrrrrrrrrrrrrt"));
    }

    static String collapseString(String input) {
        if (input.length() == 0) {
            return input;
        }
        StringBuilder stringBuilder = new StringBuilder();
        char last = input.charAt(0);
        int len = 1;
        for (int i = 1; i < input.length(); i++) {
            char current = input.charAt(i);
            if (current == last) {
                len++;
            } else {
                stringBuilder.append(len).append(last);
                last = current;
                len = 1;
            }
        }
        stringBuilder.append(len).append(last);
        return stringBuilder.toString();
    }

}
