package day38;

import java.util.Scanner;

 class TimeConversion {

    static String timeConversion(String ip) {
        String[] data = ip.split(":");
        String hh = data[0];
        String mm = data[1];
        String ss = data[2].substring(0, 2);
        String pAm = data[2].substring(2, 4);


        if (pAm.equals("PM")) {
            if (Integer.parseInt(hh) == 12) {

            }else{
                int hhTemp = Integer.parseInt(hh) + 12;
                if (hhTemp >= 24) {
                    hh = String.valueOf("0" + (Integer.parseInt(hh) - 12));
                } else {
                    hh = String.valueOf(hhTemp);
                }
            }
        } else {
            if (Integer.parseInt(hh) == 12) {
                hh = "00";
            }
        }

        return hh + ":" + mm + ":" + ss;


    }
    static void add(int... nos){
        int sum = 0 ;
         for (int i = 0; i < nos.length; i++) {
                sum+= nos[i];
         }
        System.out.println(sum);
     }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        String s = in.next();
        String result = timeConversion(s);
        System.out.println(result);
    }
}
