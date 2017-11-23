package day13;

/**
 * Created by Gaurav on 15/10/17.
 */
public class StringFind {


    public int strStr(final String haystack, final String needle) {

        if (haystack.length() < 1 || needle.length() < 1 || haystack.length() < needle.length()) {
            return -1;
        }


        int startIndex = -1;


        int hayIndex = 0;
        while (hayIndex < haystack.length()) {
            char hayD = haystack.charAt(hayIndex);
            char needD = needle.charAt(0);
            if (hayD == needD) {
                startIndex = hayIndex;
                boolean status = checkString(hayIndex, 0, haystack, needle);
                if (status) {
                    return startIndex;
                } else {
                    startIndex = -1;
                    hayIndex++;
                }
            } else {
                hayIndex++;
            }

        }
        return startIndex;
    }

    private boolean checkString(int hayIndex, int needleIndex, String haystack, String needle) {

        while ( needleIndex < needle.length() &&hayIndex < haystack.length()) {
            char hayD = haystack.charAt(hayIndex++);
            char needD = needle.charAt(needleIndex++);
            if (hayD != needD) {
                return false;
            }
        }
        if (needleIndex == needle.length()) {
            return true;
        }
        return false;

    }


    public static void main(String[] args) {


        StringFind stringFind = new StringFind();
        System.out.println(stringFind.strStr("dejudeja", "deja"));
        System.out.println(stringFind.strStr("bbaabbbbbaabbaabbbbbbabbbabaabbbabbabbbbababbbabbabaaababbbaabaaaba", "babaaa"));


        //bbaabbbbbaabbaabbbbbbabbbabaabbbabbabbbbababbbabbabaaababbbaabaaaba
        //                                                babaaa
    }

}
