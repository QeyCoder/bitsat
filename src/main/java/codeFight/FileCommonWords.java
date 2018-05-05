package codeFight;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;

/**
 * Created by Gaurav on 04/05/18.
 */


public class FileCommonWords {


    public static void main(String[] args) throws IOException {

        int[] start = new int[]{33, 58};
        int[] end = new int[]{47, 64};
        Scanner scanner
                = new Scanner(System.in);
        int n = scanner.nextInt();

        String[] paths = new String[n];


        for (int i = 0; i < n; i++) {
            paths[i] = scanner.nextLine();
        }


        HashMap<String, Integer> stringHashMap = new HashMap<>();

        for (String path : paths) {
            Path file = Paths.get(path);
            List<String> lines = Files.readAllLines(file);
            for (String line : lines) {
                for (String word : line.split(" ")) {
                    String newWord = removeSpecial(word.toCharArray());
                    Integer val = stringHashMap.get(word);
                    if (val == null) {
                        val = 0;
                    }
                    stringHashMap.put(word, ++val);
                }

            }


        }

        Collection<String> commanString = new ArrayList<>();
        for (Map.Entry<String, Integer> entry : stringHashMap.entrySet()) {
            if (entry.getValue() > 1) {
                commanString.add(entry.getKey());
            }
        }

    }

    private static String removeSpecial(char[] word) {





        return null;
    }

    private static int solution() {
        return 0;
    }


}
