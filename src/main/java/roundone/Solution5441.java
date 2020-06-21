package roundone;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Solution5441 {

    public static void main(String[] args) {
        new Solution().getFolderNames(new String[]{"kaido", "kaido(1)", "kaido", "kaido(1)"});

    }

    static class Solution {
        public String[] getFolderNames(String[] names) {

            String[] ans = new String[names.length];
            Map<String, Integer> storage = new HashMap<>();
            for (int i = 0; i < names.length; i++) {
                String item = names[i];

                if (storage.containsKey(item)) {
                    Integer index = storage.get(item);
                    StringBuilder stringBuilder = new StringBuilder();

                    stringBuilder.append(item);
                    stringBuilder.append("(");
                    stringBuilder.append(index);
                    stringBuilder.append(")");

                    while (storage.containsKey(stringBuilder.toString())) {
                        index++;
                        stringBuilder= new StringBuilder(item);
                        stringBuilder.append("(");
                        stringBuilder.append(index);
                        stringBuilder.append(")");
                    }

                    ans[i] = stringBuilder.toString();
                    storage.put(stringBuilder.toString(), 1);
                    storage.put(names[i], index + 1);
                } else {
                    ans[i] = names[i];
                    storage.put(names[i], 1);
                }


            }
            return ans;

        }
    }
}
