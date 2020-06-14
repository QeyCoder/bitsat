package roundone.helper.tries;

import java.util.HashMap;
import java.util.Map;

public class TrieNode<T> {
    Map<T, TrieNode> charMap =  new HashMap<>();
    boolean isEnd =  false;

    public boolean isEnd() {
        return isEnd;
    }

    public Map<T, TrieNode> getCharMap() {
        return charMap;
    }

    public void setEnd(boolean end) {
        isEnd = end;
    }
}

