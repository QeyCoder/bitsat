import java.util.ArrayList;

/**
 *
 */
public class IntervalSolution {


    static class Interval {
        int start;
        int end;

        Interval() {
            start = 0;
            end = 0;
        }

        Interval(int s, int e) {
            start = s;
            end = e;
        }

        @Override
        public String toString() {
            return "start: " + start + " end: " + end;
        }
    }


    public static void main(String[] args) {
        IntervalSolution intervalSolution = new IntervalSolution();
        Interval newINterval = new Interval(8, 10);
        ArrayList<Interval> list = new ArrayList<>();
        list.add(new Interval(1, 2));
        list.add(new Interval(3, 6));
        System.err.println(intervalSolution.insert(list, newINterval));
    }

    public ArrayList<Interval> insert(ArrayList<Interval> intervals, Interval newInterval) {
        ArrayList<Interval> intervalLIst = new ArrayList<>();
        boolean overLap = true;
        int start = 0;
        boolean isUpdate;
        for (Interval interval : intervals) {
            if (Math.max(interval.start, newInterval.start) > Math.min(interval.end, newInterval.end)) {
                if (!overLap) {
                    intervalLIst.add(new Interval(start, newInterval.end));
                    start = 0;
                }
                if(interval.start> newInterval.start && interval.end> newInterval.end){
                    intervalLIst.add(interval);
                }
                intervalLIst.add(interval);

            } else{
                if (overLap) {
                    start = interval.start;
                    overLap = false;
                }

            }

        }
        return intervalLIst;

    }

}
