package day65;


import java.util.*;

/**
 * Created by Gaurav on 09/04/18.
 */


public class AccountMerge {


    public static void main(String[] args) {
        AccountMerge accountMerge = new AccountMerge();
        List<List<String>> ip = new ArrayList<>();

        List<String> a1 = new ArrayList<>(Arrays.asList(new String[]{"John", "johnsmith@mail.com", "john_newyork@mail.com"}));
        List<String> a2 = new ArrayList<>(Arrays.asList(new String[]{"John", "johnsmith@mail.com", "john00@mail.com"}));
        List<String> a3 = new ArrayList<>(Arrays.asList(new String[]{"John", "johnnybravo@mail.com"}));
        List<String> a4 = new ArrayList<>(Arrays.asList(new String[]{"Mary", "mary@mail.com"}));

        ip.add(a1);
        ip.add(a2);
        ip.add(a3);
        ip.add(a4);

        accountMerge.accountsMerge(ip);


    }

    Map<String, List<Integer>> mailVsAccount = new HashMap<>();

    List<List<String>> accountsMerge(List<List<String>> accounts) {
        for (int i = 0; i < accounts.size(); i++) {
            List<String> account = accounts.get(i);
            for (int j = 1; j < account.size(); j++) {
                String mail = account.get(j);
                List<Integer> indexes = mailVsAccount.get(mail);
                if (indexes == null) {
                    indexes = new ArrayList<>();
                }
                indexes.add(i);
                mailVsAccount.put(mail, indexes);
            }
        }


        boolean[] visited = new boolean[accounts.size()];
        List<List<String>> result = new LinkedList<>();
        for (int i = 0; i < accounts.size(); i++) {
            Set<String> set = new TreeSet<String>();
            dfs(i, visited, accounts, set, mailVsAccount);
            if (!set.isEmpty()) {
                List<String> mergedAccount = new LinkedList<>(set);
                mergedAccount.add(0, accounts.get(i).get(0));
                result.add(mergedAccount);
            }

        }
        return result;
    }

    private void dfs(int i, boolean[] visited, List<List<String>> accounts, Set<String> set, Map<String, List<Integer>> mailVsAccount) {
        if (visited[i]) {
            return;
        }
        visited[i] = true;

        List<String> account = accounts.get(i);
        for (int j = 1; j < account.size(); j++) {

            String email = account.get(j);
            set.add(email);

            for (Integer s : mailVsAccount.get(email)) {
                dfs(s, visited, accounts, set, mailVsAccount);
            }


        }

    }
}
