package hackerrank;

import java.io.*;
import java.util.Collections;
import java.util.List;
import java.util.stream.IntStream;

import static java.util.stream.Collectors.toList;


public class RoadRepair {

    /*
     * Complete the 'getMinCost' function below.
     *
     * The function is expected to return a LONG_INTEGER.
     * The function accepts following parameters:
     *  1. INTEGER_ARRAY crew_id
     *  2. INTEGER_ARRAY job_id
     */

    public static long getMinCost(List<Integer> crew_id, List<Integer> job_id) {


        Collections.sort(crew_id);
        Collections.sort(job_id);

        long ans = 0;
        for (int i = 0; i < job_id.size(); i++) {
            ans += Math.abs(job_id.get(i) - crew_id.get(i));

        }
        return ans;


    }

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        int crew_idCount = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> crew_id = IntStream.range(0, crew_idCount).mapToObj(i -> {
            try {
                return bufferedReader.readLine().replaceAll("\\s+$", "");
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        })
                .map(String::trim)
                .map(Integer::parseInt)
                .collect(toList());

        int job_idCount = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> job_id = IntStream.range(0, job_idCount).mapToObj(i -> {
            try {
                return bufferedReader.readLine().replaceAll("\\s+$", "");
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        })
                .map(String::trim)
                .map(Integer::parseInt)
                .collect(toList());

        long result = RoadRepair.getMinCost(crew_id, job_id);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }

}
