package roundzero.flipkart;

/**
 * Created by Gaurav on 14/03/18.
 */


public class Test {


    public static void main(String[] args) {
        String s = "I am using hackerrank to improve my programming";
        String t = "am hackerrank to improve";

        String[] op = missingWords(s, t);
        for (int i = 0; i < op.length; i++) {
            System.out.println(op[i]);
        }
    }

    static String[] missingWords(String s, String t) {
        int i = 0;
        int j = 0;
        String[] saa = s.split(" ");
        String[] taa = t.split(" ");
        StringBuilder stringBuilder = new StringBuilder();
        while (i < saa.length && j < taa.length) {
            if (saa[i].equals(taa[j])) {
                i++;
                j++;
            } else {
                stringBuilder.append(saa[i]).append(" ");
                i++;
            }
        }

        if (i < saa.length) {

            for (int k = i; k < saa.length; k++) {
                stringBuilder.append(saa[k]).append(" ");
            }
        }

        return stringBuilder.toString().split(" ");

    }


    public static  boolean foo() {

    return true;}
}
