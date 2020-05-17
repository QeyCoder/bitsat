package roundzero.day9;

/**
 * Created by Gaurav on 07/10/17.
 */
public class LastWorldLength {

    public static void main(String[] args) {
        System.out.println(getLength("hello world  "));
        System.out.println(getLength("hello "));
        System.out.println(getLength(" "));
        System.out.println(getLength("d"));
    }

    private static int getLength(String s) {
        s.trim();
        if (s.length() == 0) {
            return 0;
        }

        int count = 0;
        boolean charFace = false;
        for (int i = s.length() - 1; i >= 0; i--) {
            if (count == s.length()) {
                return count;
            }
            if (!charFace) {
                if (s.charAt(i) != ' ') {
                    charFace = true;
                    count++;
                }
            } else if (s.charAt(i) == ' ') {
                break;
            } else {
                count++;
            }

        }
        return count;
    }
}
