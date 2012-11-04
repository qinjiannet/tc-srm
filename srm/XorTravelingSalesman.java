import java.util.LinkedList;


public class XorTravelingSalesman {

	class Pair {
		public int position;
		public int profit;
		public Pair(){}
		public Pair(int position, int profit) {
			this.position = position;
			this.profit = profit;
		}
	}
	
	public boolean posPro[][] = new boolean[50][2048];
	public int maxProfit(int[] cityValues, String[] roads) {
		int ans = cityValues[0];
		int cityNum = cityValues.length;
		LinkedList<Pair> queue = new LinkedList<Pair>();
		//Initialize
		queue.add(new Pair(0,cityValues[0]));
		posPro[0][cityValues[0]] = true;
		while (!queue.isEmpty()) {
			Pair head = queue.removeFirst();
			int curPos = head.position;
			int curProfit = head.profit;
			if (curProfit > ans)
				ans = curProfit;
			for (int nextCity = 0; nextCity < cityNum; nextCity++) {
				if (roads[curPos].charAt(nextCity) == 'Y') {
					int newProfit = curProfit ^ cityValues[nextCity];
					if (!posPro[nextCity][newProfit]) {
						posPro[nextCity][newProfit] = true;
						queue.add(new Pair(nextCity, newProfit));
					}
				}
			}
		}
		return ans;
	}
}
