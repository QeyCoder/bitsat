package day64;

import java.util.HashSet;

/**
 * Created by Gaurav on 09/04/18.
 */


public class MagicDictionary2 {

    private final HashSet<String> set;

    /**
     * Initialize your data structure here.
     */
    public MagicDictionary2() {
        set = new HashSet<>();
    }

    /**
     * Build a dictionary through a list of words
     */
    public void buildDict(String[] dict) {

        for (String s : dict) {
            set.add(s);
        }

    }

    /**
     * Returns if there is any word in the trie that equals to the given word after modifying exactly one character
     */
    public boolean search(String word) {

        char[] charArray = word.toCharArray();
        for (int i = 0; i < charArray.length; i++) {
            char ch = charArray[i];
            char temp = ch;

            for (char j = 'a'; j <= 'z'; j++) {
                if (temp != j) {
                    charArray[i] = j;
                    if (set.contains(new String(charArray))) return true;
                }
            }


            charArray[i] = temp;


        }
        return false;
    }

}
