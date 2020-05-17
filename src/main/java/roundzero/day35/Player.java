package day35;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Player {
    public static void main(String args[]) throws Exception {

        //BufferedReader
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        List<Integer> integers = new ArrayList<>();

        for (int i = 0; i < t; i++) {
            int sum = 0;
            int n = Integer.parseInt(br.readLine());
            String[] data = br.readLine().split(" ");
            for (int j = 0; j < data.length; j++) {

                int ip = Integer.parseInt(data[j]);
                if(integers.size() == 0){
                    sum +=-1;
                    integers.add(ip);
                }else {
                    int index = findIndex(integers, ip);
                    if(index ==-1){
                        sum +=-1;
                    }else{
                        sum += integers.get(index - 1);
                    }

                    integers.add(index+1, ip);
                }

            }
            System.out.println(sum);
        }

    }

    private static int findIndex(List<Integer> integers, int ip) {

        if(integers.get(0) > ip){
            return -1;
        }else if(integers.get(integers.size()-1)< ip){
            return  integers.size();
        }
        for (int i = 0; i < integers.size(); i++) {
            try{
            if (ip < integers.get(i + 1) && ip > integers.get(i - 1)) {
                return i;
            }
            }catch (Exception e){
                return -1;
            }
        }

        return -1;
    }
}
