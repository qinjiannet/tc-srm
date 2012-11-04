import java.util.ArrayList;
import java.util.List;


public class TheBrickTowerMediumDivTwo {
	public int size;
	public int[] heights;
	int ans = Integer.MAX_VALUE;
	int bestSeq[];
	public int[] find(int[] heights) {
		this.size = heights.length;
		this.heights = heights;
		List<Integer> left = new ArrayList<Integer>();
		List<Integer> right = new ArrayList<Integer>();
		bestSeq = new int[size];
		for (int i = 0; i < size; i++) {
			right.add(i);
		}
		solve(left,right);
		return bestSeq;
	}
	
	public void solve(List<Integer> left, List<Integer> right) {
		if (left.size() == size) {
			
			int val = getAns(left);
			
			if (val < ans) {
				for (int i = 0; i < size; i++) {
					bestSeq[i] = left.get(i);
				}
				ans = val;
			}
			return;
		}
		for (int i = 0; i < right.size(); i++) {
			List<Integer> newLeft = new ArrayList<Integer>(left);
			List<Integer> newRight = new ArrayList<Integer>(right);
			newLeft.add(right.get(i));
			newRight.remove(right.get(i));
			solve(newLeft, newRight);
		}
	}
	public int getAns(List<Integer> list) {
		int ans = 0;
		for (int i = 0; i < size - 1; i++) {
			ans += Math.max(heights[list.get(i)], heights[list.get(i + 1)]);
			
		}
		return ans;
	}
}
