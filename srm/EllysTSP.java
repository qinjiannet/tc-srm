
public class EllysTSP {

	public int getMax(String places) {
		int C = 0,V = 0;
		for (int i = 0; i < places.length(); i++) {
			if (places.charAt(i) == 'C') {
				C++;
			} else {
				V++;
			}
		}
		int min, max;
		if (C > V) {
			max = C;
			min = V; 
		} else {
			max = V;
			min = C;
		}
		if (max > min + 1)
			max = min + 1;
		return max + min;
	}
}
