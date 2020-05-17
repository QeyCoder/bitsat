package roundzero.day123;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CordinateSystem {
    // X and Y co-ordinates of the points in order.
    // Each point is represented by (X.get(i), Y.get(i))
    public int coverPoints(ArrayList<Integer> X, ArrayList<Integer> Y) {


        List<Data> dataList = new ArrayList<>();
        for (int i = 0; i < X.size(); i++) {
            dataList.add(new Data(X.get(i), Y.get(i)));
        }


        Data initial = dataList.get(0);
        int cost = 0;
        for (int i = 1; i < dataList.size(); i++) {
            Data nextPoint = dataList.get(i);

            cost += costRequiredToVisitNextPoint(initial, nextPoint);
            initial = nextPoint;

        }
        return (cost == 0) ? 0 : cost ;
    }

    private int costRequiredToVisitNextPoint(Data initial, Data nextPoint) {
        int x0 = initial.x;
        int y0 = initial.y;
        int x1 = nextPoint.x;
        int y1 = nextPoint.y;
        int cost = 0;
        while (x0 != x1 && y0 != y1) {
            if (x0 < x1) {
                x0++;
            } else {
                x0--;
            }
            if (y0 < y1) {
                y0++;
            } else {
                y0--;
            }
            cost++;
        }


        if (x0 == x1) {
            while (y0 != y1) {
                if (y0 < y1) {
                    y0++;
                } else {
                    y0--;
                }
                cost++;
            }
        }
        if (y0 == y1) {
            while (x0 != x1) {

                if (x0 < x1) {
                    x0++;
                } else {
                    x0--;
                }
                cost++;
            }
        }
        return cost;
    }

    class Data {
        int x;
        int y;

        public Data(Integer x, Integer y) {
            this.x = x;
            this.y = y;
        }
    }

    public static void main(String[] args) {
        CordinateSystem solution
                = new CordinateSystem();
        ArrayList<Integer> y = new ArrayList<>();
        ArrayList<Integer> x = new ArrayList<>();
        x.addAll(Arrays.asList(4, 8, -7, -5, -13, 9, -7, 8));
        y.addAll(Arrays.asList(4, -15, -10, -3, -13, 12, 8, -8));

        System.out.println(solution.coverPoints(x, y));
    }
}
