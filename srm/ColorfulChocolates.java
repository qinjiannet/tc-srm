
public class ColorfulChocolates {

	int numArr[] = new int[26];
	int strLen = 0;
	char orgArr[] = null;

	public int maximumSpread(String chocolates, int maxSwaps) {
		char chArr[] = chocolates.toCharArray();
		orgArr = chArr;
		int len = chArr.length;
		strLen = len;
		int max = 1;
		for (int i = 0; i < len; i++) {
			numArr[chArr[i] - 'A']++;
		}
		for (int i = 0; i < 26; i++) {
			for (int j = 0; j < len; j++) {
				for (int k = 2; k + j < len && k <= numArr[i]; k++) {
					if (minSwap(i,j,k) <= maxSwaps) {
						if (k > max)
							max = k;
					}
				}
			}
		}
		
		return max;
	}
	
	public int minSwap(int i, int j, int k) {
		char []chArr = orgArr;
		int minSwap = 0;
		int total = 0;
		for (int p = 0; p <= k; p++) {
			if (orgArr[p + j] == 'A' + i)
				total++;
		}
		for (int p = j - 1; p >= 0; p--) {
			if (chArr[p] - 'A' == i) {
				total++;
				for (int q = 0; q < k; q++) {
					if (chArr[q + j] == 'A' + i) {
						minSwap += q + j - p;
					}
				}
			}
		}
		for (int p = j + k; p < strLen; p++) {
			if (chArr[p] - 'A' == i) {
				total++;
				for (int q = k - 1; q >= 0; q++) {
					if (chArr[q + j] == 'A' + i) {
						minSwap += q + j - p;
					}
				}
			}
		}
		return 0;
	}
}
