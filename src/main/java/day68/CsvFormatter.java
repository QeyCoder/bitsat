package day68;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by Gaurav on 14/04/18.
 */


public class CsvFormatter {


    public static void main(String[] args) throws IOException {

        int argLength = args.length;

        if (argLength == 0) {
            System.out.println("File Name Required");
            return;
        }
        String file = args[0];

        List<String> lines = Files.lines(Paths.get(file)).collect(Collectors.toList());

        if (lines.size() < 2) {
            System.out.println("Empty File");
            return;
        }


        //skip first line

        String[] header = lines.get(0).split(",");

        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < header.length; i++) {
            if (i != 2)
                stringBuilder.append(header[i]).append(",");
        }
        //removing last ,
        String updateHeader = stringBuilder.substring(0, stringBuilder.length() - 1);

        List<String> outPut = new ArrayList<>();
        outPut.add(updateHeader);
        for (int i = 1; i < lines.size(); i++) {
            stringBuilder = new StringBuilder();
            String line = lines.get(i);
            String[] ip = line.split(",");
            for (int j = 0; j < ip.length; j++) {
                if (j != 2) {
                    if (j < 2) {
                        stringBuilder.append(solve(ip[j].toCharArray())).append(",");
                    } else {
                        stringBuilder.append(ip[j]).append(",");
                    }
                }
            }
            if (stringBuilder.length() > 0) {
                outPut.add(stringBuilder.substring(0, stringBuilder.length() - 1));
            }

        }
        String output = "output.csv";
        Files.write(Paths.get(output), (Iterable<String>) outPut::iterator);
        return;

    }

    private static char[] solve(char[] chars) {
        for (int i = 1; i < chars.length - 2; i++) {
            if (chars[i - 1] == 'e' && chars[i + 1] == 'e') {
                chars[i - 1] = 'a';
                chars[i + 1] = 'a';
            }
        }
        return chars;
    }


}
