package leetCode;

/**
 * Created by Gaurav on 27/04/18.
 */


public class _434 {


    public int countSegments(String s) {
        if (s.isEmpty())
            return 0;
        String[] data = s.split(" ");
        int count = 0;
        for (String s1 : data) {
            if(!s1.isEmpty()){
                count++;
            }
        }
        return count;
    }

}
