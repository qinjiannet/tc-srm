
public class EasyConversionMachine {
	public String isItPossible(String originalWord, String finalWord, int k) {
		int len = originalWord.length();
		int diff = 0;
		for (int i = 0; i < len; i++) {
			if (originalWord.charAt(i) != finalWord.charAt(i))
				diff++;
		}
		boolean possible = true;
		if (diff > k) {
			possible = false;
		} else if (diff < k) {
			possible = (k - diff) % 2 == 0;
		}
		return possible ? "POSSIBLE" : "IMPOSSIBLE";
	}

}
