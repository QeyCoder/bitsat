package roundzero.day49;

import roundzero.template.FastInputReader;

/**
 * Created by Gaurav on 14/02/18.
 */
public class CircleTouch {
    static int circle(int x1, int y1, int x2, int y2,
                      int r1, int r2) {
        int distSq = (x1 - x2) * (x1 - x2) +
                (y1 - y2) * (y1 - y2);
        int radSumSq = (r1 + r2) * (r1 + r2);
        if (distSq == radSumSq)
            return 1;
        else if (distSq > radSumSq)
            return -1;
        else
            return 0;
    }


    public static void main(String[] args) {
        FastInputReader fastInputReader = new FastInputReader();
        int n = fastInputReader.readInt();
        int[] x = new int[n];
        int[] y = new int[n];
        int[] r = new int[n];
        for (int i = 0; i < n; i++) {
            x[i] = fastInputReader.readInt();
            y[i] = fastInputReader.readInt();
            r[i] = fastInputReader.readInt();
        }
        int region = 1;

        for (int i = 0; i < n; i++) {

            for (int j = 0; j < n; j++) {
                if (i != j) {
                    int result = circle(x[i], y[i], x[j], y[j], r[i], r[j]);
                    if(result==0){
                        //no new region
                        region+=2;
                    }else if(result==-1){

                    }
                }
            }
        }


    }

}
