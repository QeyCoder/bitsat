package roundone;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.TreeMap;

public class Solution1146 {
    static class SnapshotArray {

        int snapId=0;
        TreeMap<Integer,Integer>[] storage;
        public SnapshotArray(int length) {
            storage = new TreeMap[length];
            for(int i=0;i<length;i++){
                storage[i]= new TreeMap<>();
                storage[i].put(0,0);
            }

        }

        public void set(int index, int val) {
            storage[index].put(snapId,val);

        }

        public int snap() {
            return snapId++;
        }

        public int get(int index, int snap_id) {
            return  storage[index].floorEntry(snap_id).getValue();
        }
    }

    /**
     * Your SnapshotArray object will be instantiated and called as such:
     * SnapshotArray obj = new SnapshotArray(length);
     * obj.set(index,val);
     * int param_2 = obj.snap();
     * int param_3 = obj.get(index,snap_id);
     */
    public static void main(String[] args) {
        SnapshotArray solution1146 = new SnapshotArray(12);
        solution1146.set(2, 2);
        solution1146.snap();
        solution1146.get(2,0);
        solution1146.set(3, 7);
        solution1146.get(1,2);
        solution1146.get(2,3);
    }
}

