package interviewBit;

//https://www.interviewbit.com/problems/greatest-common-divisor/
public class GCD {
    public static class Solution {
        public int gcd(int A, int B) {
            if(A==0){
                return B;
            }else if(B==0){
                return A;
            }
            return A>B? gcd(A%B,B): gcd(B%A,A);
        }
    }

    public static void main(String[] args) {
        System.out.println(new Solution().gcd(222,18));
    }

}
