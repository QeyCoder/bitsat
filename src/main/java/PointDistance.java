import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by Gaurav on 01/09/17.
 */
public class PointDistance {



    public static int main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine();
        String[] input = line.split(" ");
        int N = Integer.parseInt(input[0]);
        int Q = Integer.parseInt(input[1]);
        String[] nos = br.readLine().split(" ");


        for (int i = 0; i < Q; i++) {
            String[] queryInput = br.readLine().split(" ");
            int queryType = Integer.parseInt(queryInput[0]);
            switch (queryType) {
                case 1:

                    int x = Integer.parseInt(queryInput[1]);
                    break;
                case 2:
                    int L = Integer.parseInt(queryInput[1]);
                    int R = Integer.parseInt(queryInput[2]);
                    for (int j = 0; j < nos.length; j++) {
                        int parsedNo = Integer.parseInt(nos[j]);
                        if(parsedNo>L && parsedNo<R){
                            nos[i] = String.valueOf(parsedNo-L);
                        }
                    }
                    break;
                case 3:
                     L = Integer.parseInt(queryInput[1]);
                     R = Integer.parseInt(queryInput[2]);
                    int mindis = Integer.MAX_VALUE;
                    int lastElemt = Integer.parseInt(nos[L]);
                    for (int j = L+1; j <=R; j++) {
                        int currentElen = Integer.parseInt(nos[j]);
                        if(currentElen-lastElemt<mindis){
                            mindis = currentElen-lastElemt;
                        }
                    }
                    return mindis;
                default:
                    return N;
            }
        }

        return 0;
    }


    void getQuery() {

    }
            /*2 4
            2 5
            1 3
            3 2 2
            3 2 3
            3 3 5*/
}
