package day123;

/**
 * https://www.interviewbit.com/problems/excel-column-number/
 * Created by Gaurav on 29/09/17.
 */
public class ExcelColumn {


    public String titleToNumber(int no) {
        StringBuilder finalBuilder = new StringBuilder();

        while (no > 0) {
            int remainder = no % 26;
            if (remainder == 0) {
                finalBuilder.append("Z");
                no = no / 26 - 1;
            } else {
                finalBuilder.append(Character.toChars(remainder + 64));
                no = no / 26;
        }

        }
        return finalBuilder.reverse().toString();

    }


    public static void main(String[] args) {
        ExcelColumn excelColumn = new ExcelColumn();
        //System.out.println(excelColumn.titleToNumber("A"));
        System.out.println(excelColumn.titleToNumber(28));
    }

}
