
public class Stamp {
	public static final char COLORS[] = {'R','G','B'}; // R 0; G 1; B 2
	public int getMinimumCost(String desiredColor, int stampCost, int pushCost) {
		int len = desiredColor.length();
		int ans = Integer.MAX_VALUE;
		int dp[][] = new int[len + 1][3];
		for (int L = 1; L <= len; L++) { // Enumerate stamp length
			//Reset the matrix
			for (int i = 1; i <= len; i++) {
				dp[i][0] = dp[i][1] = dp[i][2] = Integer.MAX_VALUE;
			}
			dp[0][0] = dp[0][1] = dp[0][2] = 0;
			for (int i = 1; i <= len; i++) {
				if (i - L < 0) 
					continue;
				for (int j = 0; j < 3; j++) {
					if (check(desiredColor, i - L, i - 1, COLORS[j])) { // Able to paint
						int minSum = Integer.MAX_VALUE;
						for (int k = i - 1; k > i - L; k--) {
							if (minSum > dp[k][j]) {
								minSum = dp[k][j];
							}
						}
						if (i - L >= 0) {
							int minDiff = Math.min(dp[i - L][0], Math.min(dp[i - L][1], dp[i - L][2]));
							if (minSum > minDiff)
								minSum = minDiff;
						}
						if (minSum != Integer.MAX_VALUE) {
							dp[i][j] = Math.min(minSum + 1, dp[i][j]);
						}
					}
				}
			}
			int minTimes = Math.min(dp[len][0], Math.min(dp[len][1], dp[len][2]));
			System.out.println(L + " " + minTimes);
			if (minTimes != Integer.MAX_VALUE && minTimes * pushCost + L *stampCost <= ans)
				ans = minTimes * pushCost + L * stampCost;
		}
		return ans;
	}
	
	public boolean check(String str, int start, int end, char color) {
		for (int i = start; i <= end; i++) {
			if (str.charAt(i) != '*' && str.charAt(i) != color) {
				return false;
			}
		}
		return true;
	}
	
	public static void main (String args[]) {
		System.out.println(new Stamp().getMinimumCost("*B**B**B*BB*G*BBB**B**B*",5,2));
	}
}
