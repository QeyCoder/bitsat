package day10;

/**
 * Created by Gaurav on 08/10/17.
 */
public class RomanGenerate {

    private String getChar(int no) {


        switch (no) {
            case 1:
                return "I";
            case 2:
                return "II";
            case 3:
                return "III";
            case 4:
                return "IV";
            case 5:
                return "V";
            case 6:
                return "VI";
            case 7:
                return "VII";
            case 8:
                return "VIII";
            case 9:
                return "IX";
            case 10:
                return "X";
            default:
                return null;
        }

    }

    public static void main(String[] args) {


        RomanGenerate romanGenerate = new RomanGenerate();

    }
}
