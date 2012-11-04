
public class ANDEquation {
	
	public final int MAX_VAL = 0xfffff;
	public int restoreY(int[] A) {
		int andValue = getAndValue(A);
		if (checkArr(A, andValue)) {
			return andValue;
		}
		return -1;
	}
	
	public boolean checkArr(int [] A, int value) {
		int cc = 20;
		int digit = 1;
		do {
			int count = 0;
			for (int num : A) {
				count += (digit & num) > 0 ? 1 : 0;
			}
			if ((value & digit) > 0 && count < A.length) {
				return false;
			}
			if ((value & digit) == 0 && A.length - count <= 1) {
				return false;
			}
			digit <<= 1;
			cc--;
		} while (cc >= 0);
		return true;
	}
	
	public int getAndValue(int [] A) {
		int val = MAX_VAL;
		for (int num : A) {
			val &= num;
		}
		return val;
	}
	
	public static void main (String args[]) {
		ANDEquation ande = new ANDEquation();
		System.out.println(ande.restoreY(new int[]{1,3,5}));
	}

}
