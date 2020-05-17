package roundzero.day36;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.TreeMap;

//https://skillenza.com/challenge/newyearchallenge2018/checkpoint/submit/502
class GraphOutlLine {

    public static void main(String[] args) throws IOException {


        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(bufferedReader.readLine());
        for (int i = 0; i < t; i++) {
            int n = Integer.parseInt(bufferedReader.readLine());
            int[] x = new int[n];
            int[] y = new int[n];
            int[] z = new int[n];
            String[] input = bufferedReader.readLine().split(" ");

            for (int j = 0; j < n; j++) {
                String[] inputData = input[j].split(",");
                x[j] = Integer.parseInt(inputData[0].replace("(", ""));
                y[j] = Integer.parseInt(inputData[1]);
                z[j] = Integer.parseInt(inputData[2].replace(")", ""));
            }
            solution(x, y, z);
        }
    }

    private static void solution(int[] x, int[] y, int[] z) {
        Building[] buildings = new Building[x.length * 2];

        int index = 0;
        for (int i = 0; i < x.length; i++) {
            Building buildingA = new Building();
            buildingA.x = x[i];
            buildingA.height = y[i];
            buildingA.isStart = true;

            Building buildingB = new Building();
            buildingB.x = z[i];
            buildingB.height = y[i];
            buildingB.isStart = false;
            buildings[index] = buildingA;
            buildings[index + 1] = buildingB;
            index += 2;

        }
        Arrays.sort(buildings);
        int prevMaxHeight = 0;
        List<int[]> data = new ArrayList<>();
        TreeMap<Integer, Integer> queue = new TreeMap<>();
        queue.put(0, 1);
        for (Building building : buildings) {

            if (building.isStart) {
                queue.compute(building.height, (key, value) -> {

                    if (value != null) {
                        value += 1;

                    }
                    return 1;
                });

            } else {
                queue.compute(building.height, (key, value) -> {

                    if (value == 1) {
                        return null;
                    }
                    value -= 1;
                    return value;
                });
            }

            Integer height = queue.lastKey();
            if (height!=prevMaxHeight) {
                prevMaxHeight = height;
                data.add(new int[]{building.x, height});
            }

        }
        for (int[] ints : data) {
            System.out.println(ints[0] + "," + ints[1]);
        }
    }


    static class Building implements Comparable<Building> {
        int x;
        int height;
        boolean isStart;


        @Override
        public int compareTo(Building building) {


            if (this.x != building.x) {
                return this.x - building.x;
            } else {
                return (this.isStart ? -this.height : this.height) - (building.isStart ? -building.height : building.height);
            }
        }
    }

}