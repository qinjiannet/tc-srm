
public class EllysXors {

	public static void main(String[] args) {
		int val = 0;
		for (int i = val + 1; i < 100; i++) {
			val ^= i;
			System.out.printf("%d\t%d\n",i,val);
		}
		EllysXors obj = new EllysXors();
		System.out.println(obj.getXor(1234567, 89101112));
	}
	
	public long getXor(long L, long R) {
		return getXorAccum(L - 1) ^ getXorAccum(R);
	}
	
	public long getXorAccum(long num) {
		long val = num % 4;
		if (val == 0)
			return num;
		if (val == 1)
			return 1L;
		if (val == 2)
			return num + 1L;
		if (val == 3)
			return 0L;
		return 0L;
	}

}
