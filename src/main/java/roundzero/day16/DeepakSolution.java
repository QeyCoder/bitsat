package roundzero.day16;

import java.util.Scanner;

/**
 * Created by Gaurav on 08/11/17.
 */
public class DeepakSolution {

    public static void main(String[] args) {


        Scanner scanner
                 =  new Scanner(System.in);
        System.out.println(solution(scanner.nextLine()));
    }

    private static char solution(String s) {

            int temp[] =  new int[26];
        for (int i = 0; i < s.length(); i++) {
            temp[s.charAt(i)-97]++;
        }
        int max=0;
        int index = -1;
        for (int i = temp.length-1; i >=0 ; i--) {
            if(temp[i]>=max){
                index = i;
                max =  temp[i];
            }
        }
        return (char) (index+97);
    }
}
