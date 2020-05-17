package roundzero.day50;

import roundzero.template.FastInputReader;

/**
 * Created by Gaurav on 15/02/18.
 */
public class BaseConversion {

    public static void main(String[] args) {
        FastInputReader fastInputReader
                = new FastInputReader();
        String no = fastInputReader.readString();
        no = no.toUpperCase();
        long n = 0l;
        for (int i = no.length() - 1; i >= 0; i--) {
            n += (no.charAt(i) - 'A' + 10) * Math.pow(16, i);
        }
        System.out.println(n);
    }
}
