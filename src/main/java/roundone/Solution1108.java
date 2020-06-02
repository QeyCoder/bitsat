package roundone;

public class Solution1108 {
    static class Solution {
        public String defangIPaddr(String address) {
            return address.replaceAll("\\.","[.]");
        }
    }

    public static void main(String args[]) {
        Solution solution = new Solution();
    }
}
