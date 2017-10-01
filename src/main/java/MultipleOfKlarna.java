/**
 * Created by Gaurav on 01/10/17.
 */
public class MultipleOfKlarna {

    /**
     * Naive approach run in O(n)
     * public int solution(int number) {
     * int sum = 0;
     * <p>
     * for (int i = 1; i < number; i++) {
     * if (i % 3 == 0 || i % 5 == 0) {
     * sum += i;
     * }
     * }
     * return sum;
     * }
     * <p>
     * <p>
     * <p>
     * /* As multiple of 3 & 5 make a seprate AP(Airthmetic Progression) we can use sum of AP to solve the problem in O(1) but as some no are both mutiple of 5 and 3 so we can remove multiple of 15
     * as multiple of 3 are 3,6,9
     * and multiple of 5 are 5,10,15
     * Sum of Ap =  n/2[2a+(n-1)d]
     *
     * @param number
     * @return
     */
    public int solution(int number) {
        //multiple of 3 below passed no
        int sum = 0;
        int threeMultiplier = (number - 1) / 3;
        int lastMultiplierThree = 3 + (threeMultiplier - 1) * 3;

        //multiple of 5 below passed no

        int fiveMultiplier = (number - 1) / 5;
        int lastMultiplierFive = 5 + (fiveMultiplier - 1) * 5;


        //multiple of 15 below passed no
        int fifteenMultiplier = (number - 1) / 15;
        int lastFifteenMultiplier = 15 + (fifteenMultiplier - 1) * 15;


        sum += (threeMultiplier) * (3 + lastMultiplierThree) / 2;
        sum += (fiveMultiplier) * (5 + lastMultiplierFive) / 2;
        sum -= (fifteenMultiplier) * (15 + lastFifteenMultiplier) / 2;

        return sum;
    }


}
