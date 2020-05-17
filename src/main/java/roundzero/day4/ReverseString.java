package roundzero.day4;

public class ReverseString {
    public static void main(String[] args) {
        System.out.println(reverseWords("j"));

    }

    public static String reverseWords(String a) {
        a = a.trim();
        String[] temp = a.split(" ");
        temp = reverseString(temp, 0);
        StringBuilder data = new StringBuilder();
        for (String s : temp) {
            data.append(s).append(" ");
        }

        return data.substring(0, data.length() - 1);
    }

    private static String[] reverseString(String[] temp, int i) {

        while (i < (temp.length -1)/2) {
            swap(temp, i, temp.length - i-1);
            i++;
        }
        return temp;
    }

    private static void swap(String[] temp, int i, int j) {
        String da = temp[i];
        temp[i] = temp[j];
        temp[j] = da;

    }


}