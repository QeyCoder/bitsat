package day68;

import java.util.LinkedList;
import java.util.Queue;

public class Entry {

    Queue<String> passportList = new LinkedList<>();

    public void enter(String passportNumber) {
        passportList.add(passportNumber);

    }

    public String exit() {
        if (passportList.isEmpty()) {
            return null;
        } else {
            return passportList.remove();
        }
    }

    public static void main(String[] args) {
        Entry entry = new Entry();
        entry.enter("AB54321");
        entry.enter("UK32032");
        System.out.println(entry.exit());
        System.out.println(entry.exit());
    }
}