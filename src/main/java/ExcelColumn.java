/**
 * https://www.interviewbit.com/problems/excel-column-number/
 * Created by Gaurav on 29/09/17.
 */
public class ExcelColumn {


    public int titleToNumber(String a) {
        int sum = 0;

        for (int i = a.length() - 1; i >= 0; i--) {
            sum += Math.pow(26, a.length() - i - 1) * (a.charAt(i) - 64);

        }

        return sum;

    }


    public static void main(String[] args) {
        ExcelColumn excelColumn = new ExcelColumn();
        //System.out.println(excelColumn.titleToNumber("A"));
        System.out.println(excelColumn.titleToNumber("AAA"));
        System.out.println(excelColumn.titleToNumber("AB"));
        System.out.println(excelColumn.titleToNumber("Z"));
    }

}
