package roundone;

import java.util.Arrays;

public class Solution881 {
        public int numRescueBoats(int[] people, int limit) {


            Arrays.sort(people);
            int i=0;
            int j= people.length-1;
            int boat=0;

            while(i<=j){
                int diff= limit-people[j];
                j--;
                int max=0;
                while(i<people.length-1&&diff>=people[i]){
                    if(max==1){
                        break;
                    }
                    diff=diff-people[i];
                    max++;
                    i++;
                }
                boat++;
            }
            return boat;
        }
}
