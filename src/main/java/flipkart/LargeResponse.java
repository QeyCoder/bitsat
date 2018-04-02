package flipkart;

import java.io.File;
import java.io.FileOutputStream;
import java.util.Scanner;

/**
 * Created by Gaurav on 26/03/18.
 */


public class LargeResponse   {



    private static final Scanner scan = new Scanner(System.in);
    public static void main(String args[]) throws Exception {

        Test obj = null;
        System.out.println(obj.foo());
        String filename = scan.nextLine();
        String outputFileName = "bytes_" + filename;

        File file = new File(outputFileName);
        FileOutputStream fop = new FileOutputStream(file);
        if (!file.exists()) {
            file.createNewFile();
        }
        Scanner scanner = new Scanner(new File(filename));


        long count = 0;
        long sum = 0;
        while (scanner.hasNext()) {
            String ip = scanner.nextLine();
            String[] split = ip.split(" ");
            long bytes = Long.parseLong(split[split.length - 1]);

            if (bytes > 5000) {
                count++;
                sum += bytes;
            }
        }
        String op = new String(count + "\n" + sum);
        fop.write(op.getBytes());
        fop.close();
        fop.flush();

    }
}
