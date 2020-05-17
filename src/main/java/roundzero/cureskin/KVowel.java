package roundzero.cureskin;

import roundzero.template.FastInputReader;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by Gaurav on 15/04/18.
 */


public class KVowel {


    public static void main(String[] args) {


        FastInputReader fastInputReader = new FastInputReader();
        int T = fastInputReader.readInt();
        StringBuilder stringBuilder = new StringBuilder();
        while (T-- > 0) {

            int N = fastInputReader.readInt();
            int K = fastInputReader.readInt();
            String ip = fastInputReader.readString();
            stringBuilder.append(solution(ip, N, K)).append("\n");
        }
        System.out.println(stringBuilder);
    }

    private static int solution(String ip, int n, int k) {
        char[] charArray = ip.toLowerCase().toCharArray();
        Set<Character> vowel = new HashSet<>();
        vowel.add('a');
        vowel.add('e');
        vowel.add('i');
        vowel.add('o');
        vowel.add('u');

        int x = 0;
        int y = 1;

        int a = 0;
        int e = 0;
        int i = 0;
        int o = 0;
        int u = 0;
        int max = 1;
        while (x < y && y < charArray.length - 1) {
            int len = y - x;
            if(a + e + i + o + u > k){
            while (x < y || a + e + i + o + u <= k) {
                switch (charArray[x - 1]) {
                    case 'a':
                        a = 0;
                        break;
                    case 'e':
                        e = 0;
                        break;
                    case 'i':
                        i = 0;
                        break;
                    case 'o':
                        o = 0;
                        break;
                    case 'u':
                        u = 0;
                        break;
                    default:
                        break;
                }
                x++;
                len--;
            }}
            switch (charArray[y]) {
                case 'a':
                    a = 1;
                    break;
                case 'e':
                    e = 1;
                    break;
                case 'i':
                    i = 1;
                    break;
                case 'o':
                    o = 1;
                    break;
                case 'u':
                    u = 1;
                    break;
                default:
                    break;
            }
            if (len > max) {
                max = len;
            }
        }
        return max;

    }


}
