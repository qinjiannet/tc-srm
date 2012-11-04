import java.util.Arrays;


public class IncubatorEasy {

	public static String arg[] = {"YNNNNYN",
		"NYNNNYN",
		"NNNNYNY",
		"NYNNNNN",
		"NYYYNNN",
		"NNNNNNN",
		"NNNNNYN"};
	public static void main (String args[]) {
		
		maxMagicalGirls(arg);
	}
	public static int maxMagicalGirls(String[] love) {
		int len = love.length;
		boolean graph[][] = new boolean[len][len];
		for (int i = 0; i < len; i++) {
			for (int j = 0; j < len; j++) {
				graph[i][j] = love[i].charAt(j) == 'Y';
			}
		}
		
		//Floyd
		for (int i = 0; i < len; i++) {
			for (int j = 0; j < len; j++) {
				for (int k = 0; k < len; k++) {
					if (graph[j][i] && graph[i][k]) {
						graph[j][k] = true;
					}
				}
			}
		}
//		for (int i = 0; i < len; i++) {
//			for (int j = 0; j < len; j++) {
//				System.out.print((graph[i][j] ? 1 : 0) + " ");
//			}
//			System.out.println();
//		}
		
		int answer = 0;
		int maximum = 1<<len;
		for (int tt = 0; tt < maximum; tt++) {
			boolean isValid[] = new boolean[len];
			for (int kk = 0; kk < len; kk++) {
				if ((tt & (1 << kk)) > 0) {
					isValid[kk] = true;
				}
			}
//			for (boolean num : isValid)
//				System.out.print(num + ",");
//			System.out.println();
			int inDegree[] = new int[len];
			Arrays.fill(inDegree,0);
			for (int i = 0; i < len; i++) {
				for (int j = 0; j < len; j++) {
					if (isValid[i] && isValid[j]) {
						if (graph[j][i]) {
							inDegree[i]++;
						}
					}
				}
				
			}
			int inAns = 0;
			for (int i = 0; i < len; i++) {
				if (!isValid[i]) {
					continue;
				}
				//if (inDegree[i] == 0) System.out.println(i);
				inAns += (inDegree[i] == 0 ? 1 : 0);
			}
			if (inAns > answer)
				answer = inAns;
			//System.out.println(inAns);
		}
//		for (int num : inDegree)
//			System.out.print(num + ",");
//		System.out.println();
		
		return answer;
	}
}
