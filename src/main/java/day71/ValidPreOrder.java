package day71;

/**
 * Created by Gaurav on 27/04/18.
 */


public class ValidPreOrder {


    public static void main(String[] args) {


        ValidPreOrder validPreOrder
                = new ValidPreOrder();
        System.out.println(validPreOrder.isValidSerialization("9,3,4,#,#,1,#,#,2,#,6,#,#"));

        System.out.println(validPreOrder.isValidSerialization("9,#,#,1"));

    }

    public boolean isValidSerialization(String preorder) {

        String[] ip = preorder.split(",");
        int diff = 1;

        for (int i = 0; i < ip.length; i++) {
            if (--diff < 0) return false;
            else if (!ip[i].equals("#")) {

                diff += 2;
            }

        }
        return diff == 0;

    }


}
