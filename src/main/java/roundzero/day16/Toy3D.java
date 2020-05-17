package roundzero.day16;

import java.io.IOException;
import java.io.InputStream;
import java.util.InputMismatchException;

/**
 * Created by Gaurav on 18/11/17.
 */
public class Toy3D {


    public static void main(String[] args) {

        InputReader inputReader
                = new InputReader(System.in);
        int row = inputReader.nextInt();
        int col = inputReader.nextInt();

        int[][] mat = new int[row][col];
        for (int i = 0; i < row; i++) {

            for (int j = 0; j < col; j++) {

                mat[i][j] = inputReader.nextInt();
            }

        }


        System.out.println(solution(mat, row, col));


    }

    private static int solution(int[][] mat, int row, int col) {
        int cost = 0;
        if (row == 1 && col == 1) {
            return 6;
        } else if (row == 1 || col == 1) {

            if (row == 1) {


                for (int i = 0; i < col; i++) {

                    if (i == 0) {
                        cost += 3 * mat[0][i];
                        cost += 2;
                        int c = mat[0][i] - mat[0][i + 1];
                        cost += c > 0 ? c : 0;
                    } else if (i == col - 1) {
                        cost += 3 * mat[0][i];
                        cost += 2;
                        int c = mat[0][i] - mat[0][i - 1];
                        cost += c > 0 ? c : 0;
                    } else {

                        int c1 = mat[0][i] - mat[0][i + 1];
                        int c2 = mat[0][i] - mat[0][i - 1];
                        cost += c1 > 0 ? c1 : 0;
                        cost += c2 > 0 ? c2 : 0;
                        cost+=2+ 2*mat[0][i];

                    }
                }
                return cost;
            } else {
                for (int i = 0; i < row; i++) {
                    if (i == 0) {
                        cost += 3 * mat[i][0];
                        cost += 2;
                        int c = mat[i][0] - mat[i+1][0];
                        cost += c > 0 ? c : 0;
                    } else if (i == row - 1) {
                        cost += 3 * mat[i][0];
                        cost += 2;
                        int c = mat[i][0] - mat[i-1][0];
                        cost += c > 0 ? c : 0;
                    } else {

                        int c1 = mat[i][0] - mat[i + 1][0];
                        int c2 = mat[i][0] - mat[i - 1][0];
                        cost += c1 > 0 ? c1 : 0;
                        cost += c2 > 0 ? c2 : 0;
                        cost+=2+ 2*mat[i][0];

                    }
                }
                return cost;

            }
        }


        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                cost += 1 + 1;
                if (i == 0 || j == 0 || i == row - 1 || j == col - 1) {
                    //1 for upper surface
                    //1 for bottom  surface


                    if (i == 0 && j == 0) {
                        cost += 2 * mat[i][j];
                        cost += getRightCost(mat, i, j);
                        cost += getBottomCost(mat, i, j);
                        //see right and bottom
                    } else if (i == 0 && j == col - 1) {
                        cost += 2 * mat[i][j];
                        cost += getBottomCost(mat, i, j);
                        cost += getLeftCost(mat, i, j);
                        //see left and bottom
                    } else if (i == row - 1 && j == 0) {
                        cost += 2 * mat[i][j];
                        cost += getRightCost(mat, i, j);
                        cost += getTopCost(mat, i, j);
                        //see top and right
                    } else if (i == row - 1 && j == col - 1) {
                        cost += 2 * mat[i][j];
                        cost += getLeftCost(mat, i, j);
                        cost += getTopCost(mat, i, j);

                        //see top and right
                    } else {
                        // when 1 side is visible

                        cost += mat[i][j];
                        if (i == 0 && j != 0 && j != col - 1) {
                            //check for left right bottom
                            cost += getLeftCost(mat, i, j);
                            cost += getRightCost(mat, i, j);
                            cost += getBottomCost(mat, i, j);
                        } else if (i != 0 && j == 0 && i != row - 1) {
                            //check for top right bottom
                            cost += getTopCost(mat, i, j);
                            cost += getRightCost(mat, i, j);
                            cost += getBottomCost(mat, i, j);
                        } else if (j != 0 && i == row - 1 && j != col - 1) {
                            //check for left right top
                            cost += getLeftCost(mat, i, j);
                            cost += getRightCost(mat, i, j);
                            cost += getTopCost(mat, i, j);
                        } else if (i != 0 && j == col - 1 && i != row - 1) {
                            //check for top left bottom
                            cost += getTopCost(mat, i, j);
                            cost += getLeftCost(mat, i, j);
                            cost += getBottomCost(mat, i, j);
                        }


                    }

                } else {


                    //1 for upper surface
                    //1 for bottom  surface

                    int right = getRightCost(mat, i, j);
                    int bottom = getBottomCost(mat, i, j);
                    int left = getLeftCost(mat, i, j);
                    int top = getTopCost(mat, i, j);


                    cost += left;
                    cost += right;
                    cost += bottom;
                    cost += top;

                }

            }

        }

        return cost;
    }

    private static int getRightCost(int[][] mat, int i, int j) {
        int cost = mat[i][j] - mat[i][j + 1];
        return cost > 0 ? cost : 0;
    }

    private static int getTopCost(int[][] mat, int i, int j) {
        int cost = mat[i][j] - mat[i - 1][j];
        return cost > 0 ? cost : 0;
    }

    private static int getBottomCost(int[][] mat, int i, int j) {
        int cost = mat[i][j] - mat[i + 1][j];
        return cost > 0 ? cost : 0;
    }

    private static int getLeftCost(int[][] mat, int i, int j) {
        int cost = mat[i][j] - mat[i][j - 1];
        return cost > 0 ? cost : 0;
    }


    static class InputReader {

        private InputStream stream;
        private byte[] buf = new byte[8192];
        private int curChar, snumChars;
        private SpaceCharFilter filter;

        public InputReader(InputStream stream) {
            this.stream = stream;
        }

        public int snext() {
            if (snumChars == -1)
                throw new InputMismatchException();
            if (curChar >= snumChars) {
                curChar = 0;
                try {
                    snumChars = stream.read(buf);
                } catch (IOException e) {
                    throw new InputMismatchException();
                }
                if (snumChars <= 0)
                    return -1;
            }
            return buf[curChar++];
        }

        public int nextInt() {
            int c = snext();
            while (isSpaceChar(c))
                c = snext();
            int sgn = 1;
            if (c == '-') {
                sgn = -1;
                c = snext();
            }
            int res = 0;
            do {
                if (c < '0' || c > '9')
                    throw new InputMismatchException();
                res *= 10;
                res += c - '0';
                c = snext();
            } while (!isSpaceChar(c));
            return res * sgn;
        }

        public long nextLong() {
            int c = snext();
            while (isSpaceChar(c))
                c = snext();
            int sgn = 1;
            if (c == '-') {
                sgn = -1;
                c = snext();
            }
            long res = 0;
            do {
                if (c < '0' || c > '9')
                    throw new InputMismatchException();
                res *= 10;
                res += c - '0';
                c = snext();
            } while (!isSpaceChar(c));
            return res * sgn;
        }

        public int[] nextIntArray(int n) {
            int a[] = new int[n];
            for (int i = 0; i < n; i++)
                a[i] = nextInt();
            return a;
        }

        public String readString() {
            int c = snext();
            while (isSpaceChar(c))
                c = snext();
            StringBuilder res = new StringBuilder();
            do {
                res.appendCodePoint(c);
                c = snext();
            } while (!isSpaceChar(c));
            return res.toString();
        }

        public boolean isSpaceChar(int c) {
            if (filter != null)
                return filter.isSpaceChar(c);
            return c == ' ' || c == '\n' || c == '\r' || c == '\t' || c == -1;
        }

        public interface SpaceCharFilter {
            public boolean isSpaceChar(int ch);
        }
    }

}
