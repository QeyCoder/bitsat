package day16;

import java.util.HashMap;
import java.util.Scanner;

class COINS{
 
	static HashMap h = new HashMap();
 
	static long maxCoins(Long n){

		if(n<12){
			return n;
		}
		else{
			if(h.containsKey((long)n)){
				return (long)h.get(n);
			}
			else{
				long result = Math.max(n, maxCoins(n / 2) + maxCoins(n / 3) + maxCoins(n / 4));
				h.put((long)n,(long)result);
				return result;
			}
		}
	}
 
	public static void main(String args[]){
 
		Scanner scan = new Scanner(System.in);
 
		
		for(int i=0;i<10;i++){
 
			long n = scan.nextLong();
			System.out.println(maxCoins(n));
		}
	}
} 