package roundzero.day123;

import java.util.LinkedList;

/**
 * Created by Gaurav on 30/09/17.
 */
public class SmsSolution {

    public int solution(String data, int maxCap) {
        int solution = -1;
        LinkedList<String> finalMessages = new LinkedList<>();
        //removing internal spaces
        for (String word : data.split(" ")) {
            if (word.length() > maxCap) {
                finalMessages.addFirst(word.substring(0, maxCap));
                finalMessages.addFirst(word.substring(maxCap, word.length() - 1));
            } else {
                // if partial message was inserted
                String lastMessage = finalMessages.peekLast();
                if (lastMessage == null) {
                    finalMessages.addFirst(data);
                } else {
                    //adding 1 space
                    if (lastMessage.length() + 1 + word.length() <= maxCap) {
                        finalMessages.addFirst(lastMessage + " " + word);
                    } else {
                        finalMessages.add(word);
                    }

                }

            }

        }
        int length = finalMessages.size();
        if (length > 0) {
            solution = length;
        }
        return solution;
    }

}
