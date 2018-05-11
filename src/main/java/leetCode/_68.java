package leetCode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by himan on 11-05-2018.
 */
public class _68 {

//greedy approach
    public List<String> fullJustify(String[] words, int maxWidth) {

        List<String> strings = new ArrayList<>();


        int curentLength = 0;

        StringBuilder stringBuilder = new StringBuilder();
        for (String word : words) {

            int len = word.length();

            if (curentLength + len > maxWidth) {
                strings.add(stringBuilder.toString());
                stringBuilder = new StringBuilder();

                curentLength = 0;

            }
            stringBuilder.append(word).append(' ');
            curentLength += len;
        }
        strings.add(stringBuilder.toString());

        return strings;
    }

    public static void main(String[] args) {
        _68
                ref = new _68();
        ref.fullJustify(new String[]{"This", "is", "an", "example", "of", "text", "justification."}, 16);
    }
}
