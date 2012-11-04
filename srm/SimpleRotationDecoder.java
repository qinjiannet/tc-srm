
public class SimpleRotationDecoder {
	public String decode(String cipherText) {
		for (int i = 1; i <= 26; i++) {
			for (int j = 1; j <= 26; j++) {
				for (int k = 1; k <= 26; k++) {
					String password = "" + (char)(i + 'a' - 1) + (char)(j + 'a' - 1) + (char)(k + 'a' - 1);
					StringBuffer sb = new StringBuffer();
					for (int ii = 0; ii < cipherText.length(); ii++) {
						char originalChar = getOriginalChar(cipherText.charAt(ii), password.charAt(ii % 3));
						sb.append(originalChar);
					}
					if (checkStr(sb.toString())) {
						return sb.toString();
					}
				}
			}
		}
		return null;
	}
	
	public char getOriginalChar(char ch, char password) {
		int chValue = (ch == ' ') ? 0 : (ch - 'a' + 1);
		int passValue = password - 'a' + 1;
		int ans = 0;
		for (int i = 0; i <= 26; i++) {
			if ((i + passValue) % 27 == chValue) {
				ans = i;
				break;
			}
		}
		return (ans == 0) ? ' ' : (char)(ans + 'a' - 1);
	}
	public boolean checkStr(String str) {
		if (str == null || str.length() == 0) {
			return false;
		}
		if (str.startsWith(" ") || str.endsWith(" ")) {
			return false;
		}
		if (str.contains("  "))
			return false;
		String words[] = str.split(" ");
		for (String word : words) {
			if (!checkWord(word))
				return false;
		}
		return true;
	}
	public boolean checkWord(String word) {
		if (word == null) {
			return false;
		}
		if (word.length() < 2 || word.length() > 8) {
			return false;
		}
		if (!containsVowel(word)) {
			return false;
		}
		return true;
	}
	public boolean containsVowel(String word) {
		for (int i = 0; i < word.length(); i++) {
			char ch = word.charAt(i);
			if (ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u')
				return true;
		}
		return false;
	}
}
