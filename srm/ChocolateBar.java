import java.util.Arrays;

public class ChocolateBar {

	public int maxLength(String letters) {
		int ans = 0;
		int len = letters.length();
		for (int i = 0; i < len; i++) {
			for (int j = len; j > i; j--) {
				if (checkString(letters.substring(i,j))) {
					if (j - i > ans) {
						ans = j - i;
						break;
					}
				}
			}
		}
		return ans;
	}
	
	public boolean checkString(String str) {
		int cnt[] = new int[26];
		Arrays.fill(cnt, 0);
		for (int i = 0; i < str.length(); i++) {
			int idx = str.charAt(i) - 'a';
			cnt[idx]++;
			if (cnt[idx] > 1) {
				return false;
			}
		}
		return true;
	}
}
