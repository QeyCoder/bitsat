package roundone;

import java.util.ArrayList;
import java.util.List;

public class Solution1472 {
    List<String> history;
    int size = 0;
    int currentIndex = 0;

    public Solution1472(String homepage) {
        history = new ArrayList<>();
        history.add(homepage);
        size=1;
        currentIndex=1;
    }

    public void visit(String url) {
        while (history.size() != currentIndex) {
            history.remove(history.size() - 1);
            size--;
        }
        history.add(url);
        currentIndex= history.size();
        size++;
    }

    public String back(int steps) {
        int index = currentIndex - steps-1;
        if (index < 0) {
            index = 0;
        }

        currentIndex = index+1;
        return history.get(index);
    }

    public String forward(int steps) {
        int index = currentIndex + steps-1;
        if (index > history.size() - 1) {
            index = history.size() - 1;
        }
        currentIndex = index+1;
        return history.get(index);
    }

    public static void main(String[] args) {
        Solution1472 browserHistory = new Solution1472("leetcode.com");
        browserHistory.visit("google.com");       // You are in "leetcode.com". Visit "google.com"
        browserHistory.visit("facebook.com");     // You are in "google.com". Visit "facebook.com"
        browserHistory.visit("youtube.com");      // You are in "facebook.com". Visit "youtube.com"
        String ans = browserHistory.back(1);                   // You are in "youtube.com", move back to "facebook.com" return "facebook.com"
        ans= browserHistory.back(1);                   // You are in "facebook.com", move back to "google.com" return "google.com"
        ans= browserHistory.forward(1);                // You are in "google.com", move forward to "facebook.com" return "facebook.com"
        browserHistory.visit("linkedin.com");     // You are in "facebook.com". Visit "linkedin.com"
        ans= browserHistory.forward(2);                // You are in "linkedin.com", you cannot move forward any steps.
        ans= browserHistory.back(2);                   // You are in "linkedin.com", move back two steps to "facebook.com" then to "google.com". return "google.com"
        ans= browserHistory.back(7);
    }
}