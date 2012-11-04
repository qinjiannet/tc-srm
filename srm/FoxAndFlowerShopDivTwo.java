
public class FoxAndFlowerShopDivTwo {

	public int theMaxFlowers(String[] flowers, int r, int c) {
		int m = flowers.length;
		int n = flowers[0].length();
		int max = 0;
		for (int si = 0; si < m; si++) {
			for (int ei = si; ei < m; ei++) {
				for (int sj = 0; sj < n; sj++) {
					for (int ej = sj; ej < n; ej++) {
						if (r >= si && r <= ei && c >= sj && c <= ej) {
							continue;
						}
						int cnt = 0;
						for (int i = si; i <= ei; i++) {
							for (int j = sj; j <= ej; j++) {
								if (flowers[i].charAt(j) == 'F') {
									cnt++;
								}
							}
						}
						if (cnt > max)
							max = cnt;
					}
				}
			}
		}
		return max;
	}
}
