package roundone;

public class Solution5416 {
    class Solution {
        public int isPrefixOfWord(String sentence, String searchWord) {
            String[] spltdSentence = sentence.split(" ");
            for (int i = 0; i < spltdSentence.length; i++) {

                if (spltdSentence[i].contains(searchWord)) {
                    boolean found = true;
                    for (int j = 0; j < searchWord.length(); j++) {
                        if (searchWord.charAt(j) != spltdSentence[i].charAt(j)) {
                            found = false;
                            break;
                        }
                    }
                    if (found) {
                        return i + 1;
                    }

                }
            }
            return -1;
        }
    }
}
