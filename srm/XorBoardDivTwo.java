public class XorBoardDivTwo {
	public int theMax(String[] board) {
		int rows = board.length;
		int cols = board[0].length();
		int grid[][] = new int[rows][cols];
		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < cols; j++) {
				grid[i][j] = board[i].charAt(j) - '0';
			}
		}
		int max = 0;
		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < cols; j++) {
				// Create a new grid
				int grid2[][] = new int[rows][cols];
				// Naively Copy
				for (int ii = 0; ii < rows; ii++) {
					for (int jj = 0; jj < cols; jj++)
						grid2[ii][jj] = grid[ii][jj];
				}
				// Flip row i
				for (int jj = 0; jj < cols; jj++) {
					grid2[i][jj] = 1 - grid2[i][jj];
				}
				// Flip col j
				for (int ii = 0; ii < rows; ii++) {
					grid2[ii][j] = 1 - grid2[ii][j];
				}
				// Count ones
				int cnt = 0;
				for (int ii = 0; ii < rows; ii++) {
					for (int jj = 0; jj < cols; jj++)
						cnt += grid2[ii][jj];
				}
				if (cnt > max)
					max = cnt;
			}
		}
		return max;
	}

}
