package roundzero.day123;

/**
 * Created by Gaurav on 29/09/17.
 */
public class Palindrom {

    public int isPalindrome(String string) {
        if (string.length() <= 1) {
            return 1;
        }
        int midIndex = (string.length() / 2) + 1;
        int j = string.length() - 1;

        for (int i = 0; i < midIndex; ) {
            char start = string.charAt(i);
            char end = string.charAt(j);
            boolean iUpdate = false;
            boolean jUpdate = false;
            while (!isInRange(start) && i < midIndex) {
                start = string.charAt(i++);
                iUpdate = true;
            }

            while (!isInRange(end) && j > midIndex) {
                end = string.charAt(j--);
                jUpdate = true;
            }

            if (!String.valueOf(start).equalsIgnoreCase(String.valueOf(end))) {
                return 0;
            }
            if (!iUpdate) {
                i++;
            }
            if (!jUpdate) {
                j--;
            }


        }
        return 1;
    }


    boolean isInRange(char c) {
        if (c >= 48 && c <= 57) {
            return true;
        }
        if (c >= 65 && c <= 90) {
            return true;
        }
        if (c >= 97 && c <= 122) {
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        Palindrom palindrom
                = new Palindrom();
        System.out.println(palindrom.isPalindrome("A man, a plan, a canal: Panama"));
    }
}
