package leetCode;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Created by Gaurav on 28/04/18.
 **/


public class _341 {
    public interface NestedInteger {

        // @return true if this NestedInteger holds a single integer, rather than a nested list.
        public boolean isInteger();

        // @return the single integer that this NestedInteger holds, if it holds a single integer
        // Return null if this NestedInteger holds a nested list
        public Integer getInteger();

        // @return the nested list that this NestedInteger holds, if it holds a nested list
        // Return null if this NestedInteger holds a single integer
        public List<NestedInteger> getList();
    }

    public static class NestedIterator implements Iterator<Integer> {

        int index = 0;
        List<Integer> list = new ArrayList<>();

        public NestedIterator(List<NestedInteger> nestedList) {
            fillList(nestedList);
        }

        private void fillList(List<NestedInteger> nestedList) {
            if (nestedList == null) return;
            for (NestedInteger nestedInteger : nestedList) {
                if (!nestedInteger.isInteger()) {
                    fillList(nestedInteger.getList());
                } else {
                    list.add(nestedInteger.getInteger());
                }
            }
        }

        @Override
        public Integer next() {
            return list.get(index++);

        }

        @Override
        public boolean hasNext() {
            Integer value = list.get(index);
            return value != null;
        }
    }


}
