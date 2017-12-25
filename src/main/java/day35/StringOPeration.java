package day35;

import java.io.BufferedReader;
import java.io.InputStreamReader;

//https://www.hackerearth.com/challenge/hiring/cognizant-java-developer-hiring-challenge/problems/00f317c5a3794e90a5b3b724c2361abe/
class StringOPeration {
    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String data = br.readLine();                // Reading input from STDIN
        int Q = Integer.parseInt(br.readLine());
        char[] dat = data.toCharArray();
        for (int i = 0; i < Q; i++) {
            String[] ip = br.readLine().split(" ");
            int ind = Integer.parseInt(ip[0]);
            char ch = ip[1].charAt(0);
            dat[ind - 1] = ch;
        }

        System.out.println(dat);

        char[] dat1 = new char[dat.length];
        for (int i = 0; i < dat.length; i++) {
            dat1[i] = dat[i];
        }

        StringBuilder stringBuilder
                = new StringBuilder();
        for (int i = 0; i < dat.length; i++) {
            stringBuilder = stringBuilder.append(dat[i]);

        }
        int M = Integer.parseInt(br.readLine());
        for (int i = 0; i < M; i++) {

            String[] ip = br.readLine().split(" ");

            int start = Integer.parseInt(ip[0]);
            int end = Integer.parseInt(ip[1]);
            String si = stringBuilder.substring(0, start-1);
            String mid = stringBuilder.substring(start-1 , end);
            String en = stringBuilder.substring(end , stringBuilder.length());
            StringBuilder mid1 = new StringBuilder(mid);
            stringBuilder =  new StringBuilder(si.concat(mid1.reverse().toString()).concat(en));
        }

        System.out.println(stringBuilder);
        int count = 0;
        for (int i = 0; i < dat.length; i++) {
            if (dat1[i] == stringBuilder.charAt(i)) {
                count++;
            }
        }
        System.out.println(count);


    }

    private static char[] reverse(char[] dat, int s, int e) {
        int j = 0;
        for (int i = s; i <= e / 2; i++) {
            dat = swap(dat, s + j, e - j);
            j++;
        }
        return dat;
    }


    private static char[] swap(char[] dat, int s, int e) {

        char temp = dat[s];
        dat[s] = dat[e];
        dat[e] = temp;
        return dat;

    }
}
