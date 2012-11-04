import java.util.Arrays;

public class ColorfulBricks {

	public int countLayouts(String bricks) {
		int colors = getColors(bricks);
		if (colors > 2)
			return 0;
		if (colors == 2) {
			return 2;
		}
		return 1;
	}
	
	public int getColors(String bricks) {
		int numArr[] = new int[26];
		Arrays.fill(numArr,0);
		int len = bricks.length();
		for (int i = 0; i < len; i++) {
			numArr[bricks.charAt(i) - 'A']++;
		}
		int num = 0;
		for (int i = 0; i < 26; i++) {
			if (numArr[i] > 0)
				num++;
		}
		return num;
	}
}
