import java.util.HashSet;


public class FindTriangle {
	public double largestArea(String[] points) {
		int num = points.length;
		double ans = 0;
		for (int i = 0; i < num; i++) {
			for (int j = 0; j < num; j++) {
				for (int k = 0; k < num; k++) {
					String ta = points[i];
					String tb = points[j];
					String tc = points[k];
					HashSet<Character> hs = new HashSet<Character>();
					hs.add(ta.charAt(0));
					hs.add(tb.charAt(0));
					hs.add(tc.charAt(0));
					if (hs.size() == 2) {
						continue;
					}
					int pta[] = getPoint(ta);
					int ptb[] = getPoint(tb);
					int ptc[] = getPoint(tc);
					if (conincide(pta,ptb) || conincide(ptb, ptc) || conincide(pta, ptc)) {
						continue;
					}
					if (inline(pta,ptb,ptc)) {
						//System.out.println("true");
						continue;
					}
					int la2 = getDistanceSquare(ptb,ptc);
					int lb2 = getDistanceSquare(pta,ptc);
					int lc2 = getDistanceSquare(pta,ptb);
					double la = Math.sqrt(la2);
					double lb = Math.sqrt(lb2);
					double lc = Math.sqrt(lc2);
					
					double p = (la + lb + lc) / 2;
					double area = Math.sqrt(p * (p - la) * (p - lb) * (p -lc));
					if (area > ans) {
						//System.out.println(ta + "\n" + tb + "\n" + tc + "\n\n");
						//System.out.println(la + "," + lb + "," + lc);
						ans = area;
					}
				}
			}
		}
		return ans;
	}
	
	boolean inline(int[] pta, int[]ptb, int[] ptc) {
		int vecab[] = getVec(pta, ptb);
		//int vecbc[] = getVec(ptb, ptc);
		int vecac[] = getVec(pta, ptc);
//		if (inline(vecab,vecac)) {
//			return true;
//		}
//		return false;
		return inline(vecab, vecac);
	}
	void print(int[] vec) {
		for (int i = 0; i < vec.length; i++) {
			System.out.print(vec[i] +" ");
		}
		System.out.println();
	}
	boolean inline(int[] vec1, int[] vec2) {
		//print(vec1);
		//print(vec2);
		for (int i = 0; i < vec1.length; i++) {
			for (int j = i + 1; j < vec2.length; j++) {
				if (vec1[i] * vec2[j] != vec2[i] * vec1[j]) {
					return false;
				}
			}
		}
		return true;
	}
	int[] getVec(int[] pta, int[] ptb) {
		int ans[] = new int[pta.length];
		for (int i = 0; i < pta.length; i++) {
			ans[i] = pta[i] - ptb[i];
		}
		return ans;
	}
	boolean conincide(int[] pointa, int[] pointb) {
		for (int i = 0; i < pointa.length; i++) {
			if (pointa[i] != pointb[i])
				return false;
		}
		return true;
	}
	int[] getPoint(String pointStr) {
		String token[] = pointStr.substring(2).split(" ");
		int point[] = new int[token.length];
		for (int i = 0; i < point.length; i++) {
			point[i] = new Integer(token[i]);
		}
		return point;
	}
	int getDistanceSquare(int pa[], int pb[]) {
		int sum = 0;
		for (int i = 0; i < pa.length; i++) {
			sum += (pa[i] - pb[i]) * (pa[i] - pb[i]);
		}
		return sum;
	}
	
	public static void main (String args[]) {
		String points[] ={"R 0 0 0",
				 "R 0 4 0",
				 "R 0 0 3",
				 "G 92 14 7",
				 "G 12 16 8"};
		System.out.println(new FindTriangle().largestArea(points));
	}
}
