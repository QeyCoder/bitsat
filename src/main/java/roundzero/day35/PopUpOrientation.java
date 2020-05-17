package day35;

import java.io.BufferedReader;
import java.io.InputStreamReader;

//https://www.hackerearth.com/challenge/hiring/servicenow-developer-hiring-challenge/problems/4e520159f4d84abe96e1b1d813f1e840/
class PopUpOrientation {


    static int[] cordsX = { 1, -1, 1, -1};
    static int[] cordsY = {-1, -1, 1, 1};

    public static void main(String args[]) throws Exception {


        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int cases = Integer.parseInt(br.readLine());

        for (int i = 0; i < cases; i++) {

            String[] cords = br.readLine().split(" ");
            int x = Integer.parseInt(cords[0]);
            int y = Integer.parseInt(cords[1]);
            //x-y screen
            int l = Integer.parseInt(cords[2]);
            int m = Integer.parseInt(cords[3]);
            // pop up
            int a = Integer.parseInt(cords[4]);
            int b = Integer.parseInt(cords[5]);
            // icon


            String op = "";

            for (int j = 0; j < 4; j++) {
                int fX = l * cordsX[j];
                int fY = m * cordsY[j];


                int x1 = a + fX;
                int y1 = b + fY;

                if (x1 < 0 || x1 > x || y1 < 0 || y1 > y) {
                    continue;
                } else {
                    if (j == 0)
                        op = "bottom-right";
                    else if (j == 1) {
                        op = "bottom-left";
                    } else if (j == 2) {
                        op = "top-right";
                    } else if (j == 3) {
                        op = "top-left";
                    }
                    break;
                }

            }
            System.out.println(op);
        }


    }
}
