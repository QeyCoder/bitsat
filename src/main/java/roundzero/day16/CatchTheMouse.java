package roundzero.day16;

import java.util.Scanner;

public class CatchTheMouse {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int q = in.nextInt();
        for(int a0 = 0; a0 < q; a0++){
            int x = in.nextInt();
            int y = in.nextInt();
            int z = in.nextInt();
        solution(x,y,z);
        }
        


    }

    private static String solution(int x, int y, int z) {
        int dif1 = z - x;
        int dif2 = z - y;
        if(dif1<1){
            dif1=-dif1;
        }
        if(dif2<1){
            dif2=-dif2;
        }
        if(dif1==dif2){
            return "Mouse C";
        }
        else if(dif1>dif2){
            return "Cat B";
        }else {
            return "Cat A";
        }

    }
}
