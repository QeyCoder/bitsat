package geekforgeek;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class WordsBoggle {

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t > 0) {
            int x = sc.nextInt();
            String[] dictionary = new String[x];
            for (int i = 0; i < x; i++) {
                dictionary[i] = sc.next();
            }

            int m = Integer.parseInt(sc.next());
            int n = Integer.parseInt(sc.next());

            char board[][] = new char[m][n];
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    board[i][j] = sc.next().charAt(0);
                }
            }

            WordsBoggle T = new WordsBoggle();
            String[] ans = T.wordBoggle(board, dictionary);

            if (ans.length == 0) System.out.println("-1");
            else {
                Arrays.sort(ans);
                for (int i = 0; i < ans.length; i++) {
                    System.out.print(ans[i] + " ");
                }
                System.out.println();
            }

            t--;
        }
    }

    public String[] wordBoggle(char board[][], String[] dictionary) {
        List<String> ans = new ArrayList<>();

        for (String word : dictionary) {
            if (solve(word, board)) {
                ans.add(word);

            }

        }
        String res[]=new String[ans.size()];
        return  ans.toArray(res);

    }

    private boolean solve(String word, char[][] board) {


        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {

                if (word.charAt(0) == board[i][j] && helper(word, board, i, j, 0)) {
                    return true;
                }

            }

        }
        return false;
    }

    private boolean helper(String word, char[][] board, int i, int j, int index) {


        if (index == word.length()) {
            return true;
        }

        if (i < 0 || j < 0 || i >= board.length || j >= board[0].length || board[i][j] != word.charAt(index)) {
            return false;
        }


        char tmp = board[i][j];
        board[i][j] = ' ';

        boolean found =


                helper(word, board, i + 1, j, index + 1)
                        || helper(word, board, i, j + 1, index + 1)
                        || helper(word, board, i - 1, j, index + 1)
                        || helper(word, board, i, j - 1, index + 1)
                        || helper(word, board, i + 1, j - 1, index + 1)
                        || helper(word, board, i - 1, j + 1, index + 1)
                        || helper(word, board, i - 1, j - 1, index + 1)
                        || helper(word, board, i + 1, j + 1, index + 1);
        board[i][j] = tmp;
        return found;


    }
}



