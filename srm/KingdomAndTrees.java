
public class KingdomAndTrees {

	public static void main(String[] args) {
		int arr[] = {1,334,3,2,1};
		System.out.println(new KingdomAndTrees().minLevel(arr));
	}
	
	public boolean checkArr(int[] heights, int level) {
		int newHeights[] = new int[heights.length];
		int before = 0;
		for (int i = 0; i < heights.length; i++) {
			int cur = Math.max(before + 1, heights[i] - level);
			newHeights[i] = cur;
			before = cur;
		}
		for (int i = 0; i < heights.length; i++) {
			if (Math.abs(heights[i] - newHeights[i]) > level) {
				return false;
			}
		}
		//for (int num : newHeights) System.out.print(num + " "); System.out.println();
		return true;
	}
	
	public int minLevel(int[] heights) {
		int left = 0;
		int right = 1000010000;
		while (left <= right) {
			int mid = (left + right) / 2;
			//System.out.println(mid);
			if (checkArr(heights, mid)) {
				right = mid - 1;
			} else {
				left = mid + 1;
			}
		}
		return left;
	}
}
