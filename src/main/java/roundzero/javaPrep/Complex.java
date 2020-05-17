package roundzero.javaPrep;

import java.util.HashMap;

public class Complex {

    private int  i;

    public Complex(int i) {
        this.i = i;
    }

    // Overriding equals() to compare two Complex objects
    @Override
    public boolean equals(Object o) {

        // If the object is compared with itself then return true  
        if (i % 2 == 0) {
            return true;
        }
        return false;
    }

    @Override
    public int hashCode(){
        return i%10;

    }

// Driver class to test the Complex class

    public static void main(String[] args) {
        HashMap<Complex, String> map = new HashMap<>();
        Complex c1 = new Complex(1);
        map.put(c1, "value");
        Complex c2 = new Complex(1);
        map.put(c2, "value");

        Complex c3 = new Complex(2);
        map.put(c3, "value");
        Complex c4 = new Complex(2);
        map.put(c4, "value");
        System.out.println(map.size());

    }
}