package roundzero.day123;

/**
 * Created by Gaurav on 29/09/17.
 */
public class PalindormeInteger {
    public boolean isPalindrome(int a) {


        String val = String.valueOf(a);
        boolean isPalid = true;
        for (int i = 0; i < val.length() / 2; i++) {

            int dif = (int) val.charAt(i) - (int) val.charAt(val.length() - i-1);
            if (dif != 0) {
                isPalid = false;
                break;
            }
        }
        return isPalid;
    }


    public static void main(String[] args) {
        PalindormeInteger palindormeInteger = new PalindormeInteger();
        System.out.println(palindormeInteger.isPalindrome(292));
    }
}
