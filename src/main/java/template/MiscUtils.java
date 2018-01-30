package template;

class MiscUtils {
    public static final int[] DX4 = {1, 0, -1, 0};
    public static final int[] DY4 = {0, -1, 0, 1};

    public static boolean isValidCell(int row, int column, int rowCount,
                                      int columnCount) {
        return row >= 0 && row < rowCount && column >= 0
                && column < columnCount;
    }

}