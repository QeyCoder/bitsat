package day43;

import template.InputReader;

import java.text.DecimalFormat;

/**
 * Created by Gaurav on 31/01/18.
 */
public class SuperMarket {
    private static DecimalFormat df2 = new DecimalFormat(".########");
    public static void main(String[] args) {
        InputReader inputReader
                = new InputReader(System.in);
        int n = inputReader.readInt();
        int m = inputReader.readInt();
        double min = Double.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            double a = inputReader.readInt();
            double b = inputReader.readInt();

            double cost = a / b;

            double actualCost = m * cost;
            if (actualCost < min) {
                min = actualCost;
            }
        }
        System.out.println(df2.format(min));
    }
}
