package roundzero.day12;

/**
 * Created by Gaurav on 10/10/17.
 */
public class ZigZagString {


    public String con2vert(String A, int B) {
        if (B == 1) {
            return A;
        }
        String[] strings = new String[B];
        int index = 0;
        boolean flag = true;
        int startIndex = 0;
        int endIndex = B;
        while (index != A.length() - 1) {
            if (flag) {
                for (int i = startIndex; i <= endIndex - 1; i++) {

                    if (strings[i] != null) {
                        strings[i] = strings[i].concat(String.valueOf(A.charAt(index)));
                    } else {
                        strings[i] = String.valueOf(A.charAt(index));
                    }
                    index++;

                }
                startIndex = B - 1;
                endIndex = 0;
            } else {

                for (int i = startIndex - 1; i >= endIndex; i--) {
                    if (strings[i] != null) {
                        strings[i] = strings[i].concat(String.valueOf(A.charAt(index)));
                    } else {
                        strings[i] = String.valueOf(A.charAt(index));
                    }
                    index++;
                }
                startIndex = 1;
                endIndex = B;
            }
            flag = !flag;

        }


        StringBuilder stringBuilder
                = new StringBuilder();
        for (String string : strings) {
            stringBuilder.append(string);
        }
        return stringBuilder.toString();
    }

    public String convert(String A, int B) {
        if (B == 1) {
            return A;
        }
        String[] strings = new String[B];
        int row = 0;
        int dir = 0;
        for (int i = 0; i < A.length(); i++) {

            if (strings[row] != null) {
                strings[row] = strings[row].concat(String.valueOf(A.charAt(i)));
            } else {
                strings[row] = String.valueOf(A.charAt(i));
            }

            if (row == 0) {
                dir = 0;
            }
            if (row == B - 1) {
                dir = 1;
            }
            if (dir == 0) {
                row++;
            } else {
                row--;
            }


        }
        StringBuilder stringBuilder
                = new StringBuilder();
        for (String string : strings) {
            if(string!=null)
            stringBuilder.append(string);
        }
        return stringBuilder.toString();

    }

    public static void main(String[] args) {
        ZigZagString zigZagString
                = new ZigZagString();
        System.out.println(zigZagString.convert("NX9AROO79WZSd", 24));
    }
}
