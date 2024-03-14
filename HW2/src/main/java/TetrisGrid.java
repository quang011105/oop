//
// TetrisGrid encapsulates a tetris board and has
// a clearRows() capability.

public class TetrisGrid {
	private boolean[][] grid;

	/**
	 * Constructs a new instance with the given grid.
	 * Does not make a copy.
	 * 
	 * @param grid
	 */
	public TetrisGrid(boolean[][] grid) {
		this.grid = grid;
	}

	/**
	 * Does row-clearing on the grid (see handout).
	 */
	public void clearRows() {
		int rows = grid.length;
		int cols = grid[0].length;
		int[] colsToClear = new int[cols];
		int colsToClearCount = 0;
		for (int i = 0; i < cols; i++) {
			boolean isColFull = true;
			for (int j = 0; j < rows; j++) {
				if (!grid[j][i]) {
					isColFull = false;
					break;
				}
			}
			if (isColFull) {
				colsToClear[colsToClearCount++] = i;
			}
		}
		for (int i = 0; i < colsToClearCount; i++) {
			for (int j = 0; j < rows; j++) {
				for (int k = colsToClear[i]; k < cols - 1; k++) {
					grid[j][k] = grid[j][k + 1];
				}
				grid[j][cols - 1] = false;
			}
		}
	}

	/**
	 * Returns the internal 2d grid array.
	 * 
	 * @return 2d grid array
	 */
	boolean[][] getGrid() {
		return grid;
	}
}
