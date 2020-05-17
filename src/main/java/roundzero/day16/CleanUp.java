package roundzero.day16;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by Gaurav on 02/11/17.
 */
public class CleanUp {
//https://www.codechef.com/problems/CLEANUP
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        Integer totalCase = Integer.valueOf(bufferedReader.readLine());
        for (int i = 0; i < totalCase; i++) {

            String[] values = bufferedReader.readLine().split(" ");

            int n = Integer.parseInt(values[0]);
            int m = Integer.parseInt(values[1]);

            boolean[] task = new boolean[n];


            String[] mValues = bufferedReader.readLine().split(" ");

            for (String mValue : mValues) {
                task[Integer.parseInt(mValue) - 1] = true;
            }


            boolean pick = true;
            for (int j = 0; j < task.length; j++) {
                if (task[j] == false) {
                    if (pick) {
                        System.out.print(j + 1 + " ");
                    }
                    pick = !pick;
                }
            }
            System.out.print("\n");
            pick = true;
            for (int j = 0; j < task.length; j++) {
                if (task[j] == false) {
                    if (!pick) {
                        System.out.print(j + 1 + " ");
                    }
                    pick = !pick;
                }
            }


            System.out.print("\n");
        }
        bufferedReader.close();


    }
}
