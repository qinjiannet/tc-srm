
public class SurroundingGameEasy {
	public int score(String[] cost, String[] benefit, String[] stone) {
		int lenx = cost.length;
		int leny = cost[0].length();
		int total = 0;
		char grid[][] = new char[lenx + 2][leny + 2];
		for (int i = 0; i <= lenx + 1; i++) {
			for (int j = 0; j <= leny + 1; j++) {
				grid[i][j] = 'o';
			}
		}
		for (int i = 1; i <= lenx; i++ ) {
			for (int j = 1; j <= leny; j++) {
				grid[i][j] = stone[i - 1].charAt(j - 1);
			}
		}
		for (int i = 1; i <= lenx; i++) {
			for (int j = 1; j <= leny; j++) {
				int gain = benefit[i - 1].charAt(j - 1) - '0';
				int lost = cost[i - 1].charAt(j - 1) - '0';
				if (grid[i][j - 1] == 'o' && grid[i][j + 1] == 'o' && grid[i - 1][j] == 'o' && grid[i + 1][j] == 'o') {
					total += gain;
				} else if (grid[i][j] == 'o') {
					total += gain;
				}
				if (grid[i][j] == 'o') {
					total -= lost;
				}
			}
		}
		return total;
	}
	public static void main (String args[]) {
		System.out.println(new SurroundingGameEasy().score(null,null,null));
	}
}
