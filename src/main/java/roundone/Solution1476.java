package roundone;

public class Solution1476 {
    static class SubrectangleQueries {
        int[][] rectangle;
        public SubrectangleQueries(int[][] rectangle) {
            this.rectangle= rectangle;

        }

        public void updateSubrectangle(int row1, int col1, int row2, int col2, int newValue) {
            for(int i= row1;i<=row2;i++){
                for(int j= col1;j<=col2;j++){
                    this.rectangle[i][j]= newValue;
                }
            }
        }

        public int getValue(int row, int col) {

            return this.rectangle[row][col];
        }
    }

    /**
     * Your SubrectangleQueries object will be instantiated and called as such:
     * SubrectangleQueries obj = new SubrectangleQueries(rectangle);
     * obj.updateSubrectangle(row1,col1,row2,col2,newValue);
     * int param_2 = obj.getValue(row,col);
     */

    public static void main(String args[]) {
        SubrectangleQueries subrectangleQueries = new SubrectangleQueries(new int[][]{{1,1,1},{2,2,2},{3,3,3}});
        subrectangleQueries.getValue(0, 0); // return 1
        subrectangleQueries.updateSubrectangle(0, 0, 2, 2, 100);
        subrectangleQueries.getValue(0, 0); // return 100
        subrectangleQueries.getValue(2, 2); // return 100
        subrectangleQueries.updateSubrectangle(1, 1, 2, 2, 20);
        subrectangleQueries.getValue(2, 2); // return 20
    }
}
