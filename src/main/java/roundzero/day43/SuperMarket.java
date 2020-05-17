package day43;

import roundzero.template.FastInputReader;

import java.text.DecimalFormat;

/**
 * Created by Gaurav on 31/01/18.
 */
public class SuperMarket {
    private static DecimalFormat df2 = new DecimalFormat(".########");
    public static void main(String[] args) {
        FastInputReader fastInputReader
                = new FastInputReader(System.in);
        int n = fastInputReader.readInt();
        int m = fastInputReader.readInt();
        double min = Double.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            double a = fastInputReader.readInt();
            double b = fastInputReader.readInt();

            double cost = a / b;

            double actualCost = m * cost;
            if (actualCost < min) {
                min = actualCost;
            }
        }
        System.out.println(df2.format(min));
    }
}
