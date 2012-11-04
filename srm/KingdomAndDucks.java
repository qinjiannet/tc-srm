import java.util.Arrays;


public class KingdomAndDucks {

	private final int MAX_LEN = 51;

	public int minDucks(int[] duckTypes) {
		int arr[] = new int[MAX_LEN];
		int var = 0, max = 0;
		Arrays.fill(arr, 0);
		for (int i = 0; i < duckTypes.length; i++) {
			arr[duckTypes[i]]++;
		}
		
		for (int i = 1; i < arr.length; i++) {
			if (arr[i] > 0) {
				var++;
				if (arr[i] > max) {
					max = arr[i];
				}
			}
		}
		return max * var;
	}

}
