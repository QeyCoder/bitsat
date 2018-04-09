package day64;

class Power {
    static int nextPowerOf2(int n) {
        int p = 1;
        if (n > 0 && (n & (n - 1)) == 0)
            return n;

        while (p < n)
            p <<= 1;

        return p;
    }

    /* Driver program to test above function */
    public static void main(String args[]) {
        int n = 9;
        System.out.println(nextPowerOf2(n));
    }
}