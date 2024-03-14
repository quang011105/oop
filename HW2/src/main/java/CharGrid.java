// HW1 2-d array Problems
// CharGrid encapsulates a 2-d grid of chars and supports
// a few operations on the grid.

public class CharGrid {
    private char[][] grid;

    /**
     * Constructs a new CharGrid with the given grid.
     * Does not make a copy.
     *
     * @param grid
     */
    public CharGrid(char[][] grid) {
        this.grid = grid;
    }

    /**
     * Returns the area for the given char in the grid. (see handout).
     *
     * @param ch char to look for
     * @return area for given char
     */
    public int charArea(char ch) {
        int minRow = Integer.MAX_VALUE, minCol = Integer.MAX_VALUE;
        int maxRow = Integer.MIN_VALUE, maxCol = Integer.MIN_VALUE;
        boolean f = false;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == ch) {
                    minRow = Math.min(minRow, i);
                    minCol = Math.min(minCol, j);
                    maxRow = Math.max(maxRow, i);
                    maxCol = Math.max(maxCol, j);
                    f = true;
                }
            }
        }

        if (f = false) {
            return 0;
        }
        return (maxRow - minRow + 1) * (maxCol - minCol + 1);
    }

    /**
     * Returns the count of '+' figures in the grid (see handout).
     *
     * @return number of + in grid
     */
    public int countPlus() {
        int cnt = 0;
        for (int i = 1; i < grid.length - 1; i++) {
            for (int j = 1; j < grid[0].length - 1; j++) {
                if (grid[i][j] == grid[i][j + 1] && grid[i][j] == grid[i][j - 1] && grid[i][j] == grid[i + 1][j]
                        && grid[i][j] == grid[i - 1][j]) {
                    int cnt1 = 0, cnt2 = 0, cnt3 = 0, cnt4 = 0;
                    for (int k = j + 2; k < grid[0].length; k++) {
                        if (grid[i][k] == grid[i][j])
                            cnt1++;
                        else
                            break;
                    }
                    for (int k = j - 2; k >= 0; k--) {
                        if (grid[i][k] == grid[i][j])
                            cnt2++;
                        else
                            break;
                    }
                    for (int k = i + 2; k < grid.length; k++) {
                        if (grid[k][j] == grid[i][j])
                            cnt3++;
                        else
                            break;
                    }
                    for (int k = i - 2; k >= 0; k--) {
                        if (grid[k][j] == grid[i][j])
                            cnt4++;
                        else
                            break;
                    }
                    if (cnt1 == cnt2 && cnt2 == cnt3 && cnt3 == cnt4)
                        cnt++;
                }
            }
        }
        return cnt;
    }
}
