import java.util.HashSet;


public class TheBrickTowerEasyDivTwo {

	public static int find(int redCount, int redHeight, int blueCount, int blueHeight) {
		HashSet<Integer> set = new HashSet<Integer>();
		for (int i = 0; i <= redCount; i++) {
			for (int j = 0; j <= blueCount; j++) {
				if (i == 0 && j == 0)
					continue;
				if (Math.abs(i - j) > 1) {
					continue;
				}
				set.add(i * redHeight + j * blueHeight);
			}
		}
		return set.size();
	}
	
	public static void main (String args[]) {
		System.out.println(find(10,3,5,6));
	}
}
