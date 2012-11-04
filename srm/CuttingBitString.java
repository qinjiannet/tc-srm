import java.util.Date;

public class CuttingBitString {

	public static void main (String args[]) {
		int a = 3,b = 4;
		b^=a^=b^=a;
		System.out.printf("%d %d\n",a,b);
	}
	public static long power5[] = {1L, 5L, 25L, 125L, 625L, 3125L, 15625L, 78125L,
			390625L, 1953125L, 9765625L, 48828125L, 244140625L, 1220703125L,
			6103515625L, 30517578125L, 152587890625L, 762939453125L,
			3814697265625L, 19073486328125L, 95367431640625L, 476837158203125L,
			2384185791015625L, 11920928955078125L, 59604644775390625L,
			298023223876953125L, 1490116119384765625L, 7450580596923828125L };

	public int getmin(String S) {
		if (S.startsWith("0"))
			return -1;
		int max = countOnes(S);
		for (int i = 1; i <= max; i++) {
			//System.out.println("level " + i);
			if (solve(S, i)) {
				return i;
			}
		}
		return -1;
	}

	public boolean solve(String S, int ttl) {
		if (check5Power(S)) {
			return true;
		}
		if (ttl == 1) {
			return false;
		}
		int len = S.length();
		for (int i = 1; i < len; i++) {
			if (S.charAt(i) == '1') {
				String left = S.substring(0, i);
				if (!check5Power(left))
					continue;
				String right = S.substring(i);
				//System.out.println(left + "\t" + right);
				if (solve(right, ttl - 1))
					return true;
			}
		}
		return false;
	}

	public boolean check5Power(String s) {
		long num = getNumber(s);
		//System.out.println(num);
		for (int i = 0; i < power5.length && power5[i] <= num; i++) {
			if (power5[i] == num)
				return true;
		}
		return false; 
	}

	public long getNumber(String s) {
		long sum = 0;
		int len = s.length();
		for (int i = 0; i < len; i++) {
			sum *= 2L;
			sum += (long) (s.charAt(i) - '0');
		}
		return sum;
	}

	public int countOnes(String S) {
		int len = S.length();
		int cnt = 0;
		for (int i = 0; i < len; i++) {
			if (S.charAt(i) == '1') {
				cnt++;
			}
		}
		return cnt;
	}

}
