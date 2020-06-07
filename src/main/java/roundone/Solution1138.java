package roundone;

import java.util.Collections;

public class Solution1138 {
    static class Solution {
        public String alphabetBoardPath(String target) {
            int x = 0;
            int y = 0;
            StringBuilder sb = new StringBuilder();
            for (char c : target.toCharArray()) {
                // U,R,L,D
                int x1 = (c - 'a') % 5;
                int y1 = (c - 'a') / 5;
                sb.append(String.join("",Collections.nCopies(Math.max(x, x - x1), "U")));//UP
                sb.append(String.join("",Collections.nCopies(Math.max(y, y - y1), "R")));//RIGHT
                sb.append(String.join("",Collections.nCopies(Math.max(y, y1 - y), "L")));//LEFT
                sb.append(String.join("",Collections.nCopies(Math.max(x, x - x1), "D")));//DOWN
                sb.append("!");
                x = x1;
                y = y1;
            }
            return sb.toString();

        }
    }

    public static void main(String args[]) {
        Solution solution = new Solution();
    }
}
