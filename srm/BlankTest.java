
public class BlankTest {

	public static void main(String[] args) {
		int a = 0x7eeeeeee;
	    int b = 0x7fffffff;
	    System.out.printf("a=%08x b=%08x\n", a, b);
	    //swap a, b
	    //b ^= a ^= b ^= a;
	    a ^= b ^= a ^= b;
	    //b = b ^ (a = a ^ (b = b ^ a));
	    System.out.printf("a=%08x b=%08x\n", a, b);
	}
}
