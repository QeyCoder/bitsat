package day71;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Gaurav on 27/04/18.
 */


public class KeyBoardRow {


    public static void main(String[] args) {


        KeyBoardRow keyBoardRow =  new KeyBoardRow();
        keyBoardRow.findWords(new String[]{"Hello","Alaska","Dad","Peace"});
    }

    public String[] findWords(String[] words) {
        List<String> op = new ArrayList<>();
        int map[] = new int[]{2, 3, 3, 2, 1, 2, 2, 2, 1, 2, 2, 2, 3, 3, 1, 1, 1, 1, 2, 1, 1, 3, 1, 3, 1, 3};
        for (String word : words) {
            char[] ip = word.toLowerCase().toCharArray();
            boolean posible = true;
            int row = map[ip[0] - 'a'];
            for (int i = 1; i < ip.length; i++) {
                if (map[ip[i] - 'a'] != row) {
                    posible = false;
                    break;
                }
            }
            if (posible) {
                op.add(word);
            }
        }
        return  op.toArray(new String[op.size()]);
    }


}
