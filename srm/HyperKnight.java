
public class HyperKnight {

	public long countCells(int a, int b, int numRows, int numColumns, int k) {
		long height = Math.max(a, b);
		long width = Math.min(a, b);
		if (k == 2) {
			return 4L * width * width;
		}
		if (k == 3) {
			return 8 * (height - width) * width;
		}
		if (k == 4) {
			return 2 * width * (numColumns + numRows - 4 * height) + 4 * (height - width) * (height - width);
		}
		if (k == 6) {
			return 2 * (height - width) * (numColumns + numRows - 4 * height);
		}
		if (k == 8) {
			return (numRows - 2 * height) * (numColumns - 2 * height);
		}
		return 0;
	
	}
	
}
