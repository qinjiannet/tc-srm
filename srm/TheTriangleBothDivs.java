import java.util.ArrayList;
import java.util.TreeSet;


public class TheTriangleBothDivs {
	public String fix(String time) {
		//xx:xx GMTsx
		//0123456789
		char result[] = {'0','0',':','0','0'};
		for (int i = 3; i <= 4; i++) {
			if (time.charAt(i) != '?') {
				result[i] = time.charAt(i);
			}
		}
		TreeSet<String> hourSet = new TreeSet<String>();
		ArrayList<Integer> possibleHours = getPossibleHours(time.charAt(0),time.charAt(1));
		ArrayList<Integer> possibleOffset = getPossibleOffset(time.charAt(9), time.charAt(10));
		System.out.println(possibleHours);
		System.out.println(possibleOffset);
		for (int hour : possibleHours) {
			for (int offset : possibleOffset) {
				hourSet.add(getHour(hour, offset));
			}
		}
		if (hourSet.size() > 0) {
			String minHour = hourSet.first();
			if (minHour != null) {
				result[0] = minHour.charAt(0);
				result[1] = minHour.charAt(1);
			}
		}
		return new String(result);
	}
	
	public String getHour(int hour, int offset) {
		int newHour = (hour - offset + 24) % 24;
		String targetStr = newHour + "";
		if (newHour < 10) {
			targetStr = "0" + targetStr;
		}
		return targetStr;
	}
	public ArrayList<Integer> getPossibleHours(char tens, char ones) {
		ArrayList<Integer> al = new ArrayList<Integer>();
		if (tens == '?') {
			if (ones == '?') {
//				for (int i = 0; i < 24; i++) {
//					al.add(i);
//				}
			} else {
				for (int i = 0; i <= 2; i++) {
					int num = i * 10 + ones - '0';
					if (num < 24)
						al.add(num);
				}
			}
		} else {
			if (ones == '?') {
				for (int i = 0; i <= 9; i++) {
					int num = (tens - '0') * 10 + i;
					if (num < 24)
						al.add(num);
				}
			} else {
				al.add((tens - '0') * 10 + ones - '0');
			}
		}
		return al;
	}
	
	public ArrayList<Integer> getPossibleOffset(char signal, char num){
		ArrayList<Integer> al = new ArrayList<Integer>();
		if (signal == '?') {
			if (num != '?') {
				int offset = num - '0';
				al.add(offset);
				al.add(-offset);
			} else{
				for (int i = -9; i <= 9; i++) {
					al.add(i);
				}
			}
		} else {
			if (num != '?') {
				int offset = num - '0';
				if (signal == '-') {
					offset *= -1;
				}
				al.add(offset);
			} else {
				int min = -9, max = -1;
				if (signal == '+') {
					min = 0; max = 9;
				}
				for (int i = min; i <= max; i++) {
					al.add(i);
				}
			}
		}
		return al;
	}
	public static void main (String args[]) {
		System.out.println(new TheTriangleBothDivs().fix("17:45 GMT-4"));
	}
}
