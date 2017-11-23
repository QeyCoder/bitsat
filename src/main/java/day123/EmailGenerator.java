package day123;

import java.util.HashSet;
import java.util.LinkedHashSet;

/**
 * Created by Gaurav on 02/09/17.
 */
public class EmailGenerator {


    public String solution(String S, String C) {
        String atTheRate = "@";
        String underScore = "_";
        String specialRegex = "[^A-Za-z]";
        String[] splittedTExt = S.split("; ");
        String dotCom = ".com";
        String SEMI_COLON = ";";
        StringBuilder finalOutPut = new StringBuilder();
        HashSet<String> emailList = new LinkedHashSet<>();

        for (String s : splittedTExt) {
            String[] splittedData = s.split(" ");
            String fName = "", lName = "";
            if (splittedData.length == 3) {
                fName = splittedData[0];
                lName = splittedData[2];
            }
            if (splittedData.length == 2) {
                fName = splittedData[0];
                lName = splittedData[1];
            }
            fName = fName.toLowerCase().replaceAll(specialRegex, "");
            lName = lName.toLowerCase().replaceAll(specialRegex, "");
            C = C.toLowerCase();
            String email = fName + underScore + lName + atTheRate + C + dotCom;
            int count = 2;
            while (emailList.contains(email)) {
                email = fName + underScore + lName + count++ + atTheRate + C + dotCom;
            }
            emailList.add(email);
        }
        int count = emailList.size();
        for (String s : emailList) {
            finalOutPut.append(s);

            if (count > 1) {
                finalOutPut.append(SEMI_COLON+" ");
            }
            count--;
        }

        return finalOutPut.toString();
    }


    public static void main(String[] args) {
        EmailGenerator emailGenerator = new EmailGenerator();
        System.out.println(emailGenerator.solution("John Doe; Peter Benjamin Parker; Mary Jane Watson-Parker; John Elvis Doe; John Evan Doe; Jane Doe; Peter Brian Parker", "Example"));
    }
}
