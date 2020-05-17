package day35;/* IMPORTANT: Multiple classes and nested static classes are supported */


import java.io.BufferedReader;
import java.io.InputStreamReader;

class GoodString {
    public static void main(String args[]) throws Exception {
    int name = 0;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        try{
             name = Integer.parseInt(br.readLine());                // Reading input from STDIN
        }catch (Exception e){
            System.out.println("Invalid Test");
            return;
        }
        if (name < 1 || name> 10) {
            System.out.println("Invalid Test");
            return;
        }
        for (int i = 0; i < name; i++) {
            int small = 0;
            int cap = 0;
            String ip = br.readLine();
            if (ip.length() < 1 || ip.length() > 100) {
                System.out.println("Invalid Input");
                continue;
            }
            for (int j = 0; j < ip.length(); j++) {
                char chars = ip.charAt(j);
                if (chars >= 97 && chars <= 122) {
                    small++;
                }
                if (chars >= 65 && chars <= 90) {
                    cap++;
                }
            }
            if (cap == 0 && small == 0) {
                System.out.println("Invalid Input");
            } else
                System.out.println(min(cap, small));


        }

    }

    private static int min(int cap, int small) {
        return cap > small ? small : cap;
    }
}
