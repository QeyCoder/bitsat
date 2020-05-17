package roundzero.codeFight;

/**
 * Created by Gaurav on 04/05/18.
 */


public class FirstNonRepeatingCharacter {




    char firstNotRepeatingCharacter(String s) {


        int[] arr =  new int[26];

        for(int i = 0 ; i< s.length(); i++){
            arr[s.charAt(i)-'a']++;
        }
        for(int i = 0 ; i< s.length(); i++){
            if(arr[s.charAt(i)-'a']==1)
                return s.charAt(i);
        }
        return '_';

    }



}
