package roundzero.day36;




import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.math.BigDecimal;

class CandyCount {
    private static BigDecimal TWO  = new BigDecimal("2");
    private static BigDecimal FOUR = new BigDecimal("4");

    public static void main(String args[]) throws Exception {

        //BufferedReader
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int Q = Integer.parseInt(br.readLine());

        for (int i = 0; i < Q; i++) {
            String[] data = br.readLine().split(" ");
            BigDecimal N = new BigDecimal(data[0]);
            long T = Long.parseLong(data[1]);
            for (int j = 0; j < T; j++) {
                //9AM
                if (N.remainder(TWO) == BigDecimal.ZERO) {
                    N = N.subtract(N.divide(TWO));
                } else {
                    N = N.subtract(N.add(BigDecimal.ONE).divide(TWO));
                }
                BigDecimal temp = N.divide(FOUR);
                BigDecimal x = temp.subtract(new BigDecimal(String.valueOf(temp.intValue())));
                if(x==BigDecimal.ZERO){
                    N =  N.subtract(temp);
                }
            }
            System.out.println(N);
        }
    }
}
