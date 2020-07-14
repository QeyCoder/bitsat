package roundone;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution1344 {


    static class Solution {
        public double angleClock(float hour, float minutes) {
            float mintAngle = minutes * 6;
            hour %= 12;
            float hourAngle = hour * 30 + minutes / 2;


            if (mintAngle > 180 && hourAngle < 180) {
                return Math.min(mintAngle - hourAngle, 360 - mintAngle + hourAngle);
            }

            if (hourAngle > 180 && mintAngle < 180) {
                return Math.min(hourAngle - mintAngle , 360 - hourAngle + mintAngle);
            }


            if(mintAngle>180 && hourAngle>180 ||mintAngle<180 && hourAngle<180){
                return Math.abs(hourAngle-mintAngle);
            }
            return Math.abs(hourAngle-mintAngle);
        }
    }

    public static void main(String[] args) {
//        System.out.println(new Solution().angleClock(1, 57));
        System.out.println(new Solution().angleClock(3, 30));
        System.out.println(new Solution().angleClock(3, 15));
        System.out.println(new Solution().angleClock(4, 50));
        System.out.println(new Solution().angleClock(12, 0));
    }
}


//Minute 180/360*6