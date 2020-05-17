package roundone;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
//https://leetcode.com/problems/keys-and-rooms/
public class Solution841 {

    public static void main(String[] args) {

        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> integers1  = new ArrayList<>();
        integers1.add(1);
        integers1.add(3);
        List<Integer> integers2  = new ArrayList<>();
        integers2.add(3);
        integers2.add(0);
        integers2.add(1);
        List<Integer> integers3  = new ArrayList<>();
        integers3.add(3);
        ans.add(integers1);
        ans.add(integers2);
        ans.add(integers3);
        ans.add(null);
        new Solution841().canVisitAllRooms(ans);

    }

    public boolean canVisitAllRooms(List<List<Integer>> rooms) {

        boolean[] visited = new boolean[rooms.size()];

        Stack<Integer> stack = new Stack<>();

        stack.add(0);
        visited[0] = true;
        while (!stack.isEmpty()) {
            int val = stack.pop();
            visited[val] = true;
            List<Integer> neighbour = rooms.get(val);
            for (Integer neigh : neighbour) {
                if(!visited[neigh])
                stack.add(neigh);
            }
        }
        for (boolean ans : visited) {
            if (!ans) {
                return false;
            }
        }
        return true;


    }
}
