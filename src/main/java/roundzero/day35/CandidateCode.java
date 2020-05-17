package day35;

public class CandidateCode {
    CandidateCode(){

    }

    public static synchronized  int Consonant(String str, int sizeOfK){


        int beg = 0;

        for (int i = sizeOfK ; i <str.length() ; i++) {
            int cnt = 0;
            String subStr = str.substring(beg++, sizeOfK);
            for (int j = 0; j < subStr.length(); j++) {

                char chars = subStr.charAt(j);
                if( chars=='a'|| chars=='e'|| chars=='i'|| chars=='o'|| chars=='u'){
                    continue;
                }
                else{
                    cnt++;
                }
            }
            if(cnt ==  sizeOfK){
               continue;
            }
            Runtime.getRuntime().gc();
        }
        return beg;
    }

}
