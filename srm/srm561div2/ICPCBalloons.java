/*
*SRM561_DIV2_500pts
*/
import java.util.ArrayList;
import java.util.Collections;

public class ICPCBalloons {
	public static void main (String args[]) {
		int[] balloonCount = {1,3,5,2,4,7,9,8};
		String balloonSize = "MLMLMLML";
		int[] maxAccepted = {3,5,7,9,10};
		ICPCBalloons obj = new ICPCBalloons();
		int ans = obj.minRepaintings(balloonCount, balloonSize, maxAccepted);
		System.out.println(ans);
	}
	public int calc(ArrayList<Integer> need, ArrayList<Integer> actual) {
		if (need == null || actual == null)
			return -1;
		int nSize = need.size();
		int aSize = actual.size();
		int mSize = Math.max(nSize, aSize);
		int sum = 0;
		for (int i = 0; i < mSize; i++) {
			int needEle = i < nSize ? need.get(i) : 0;
			int actualEle = i < aSize ? actual.get(i) : 0;
			sum += needEle > actualEle ? (needEle - actualEle) : 0;
		}
		return sum;
	}
	public int minRepaintings(int[] balloonCount, String balloonSize, int[] maxAccepted) {
		ArrayList<Integer> mbList = new ArrayList<Integer>();
		ArrayList<Integer> lbList = new ArrayList<Integer>();
		int total = maxAccepted.length;
		int ans = Integer.MAX_VALUE;
		int totalM = 0, totalL = 0;
		
		int colors = balloonCount.length;
		for (int i = 0; i < colors; i++) {
			if (balloonSize.charAt(i) == 'M') {
				mbList.add(balloonCount[i]);
				totalM += balloonCount[i];
			} else {
				lbList.add(balloonCount[i]);
				totalL += balloonCount[i];
			}
		}
		Collections.sort(mbList,Collections.reverseOrder());
		Collections.sort(lbList,Collections.reverseOrder());
		
		for (int i = 1; i <= 1 << total; i++) {
			int needM = 0;
			int needL = 0;
			ArrayList<Integer> umList = new ArrayList<Integer>();
			ArrayList<Integer> ulList = new ArrayList<Integer>();
			for (int j = 0; j < total; j++) {
				if (((i >> j) & 1) == 1) {
					umList.add(maxAccepted[j]);
					needM += maxAccepted[j];
				} else {
					ulList.add(maxAccepted[j]);
					needL += maxAccepted[j];
				}
			}
			if (needL > totalL || needM > totalM)
				continue;
			Collections.sort(umList,Collections.reverseOrder());
			Collections.sort(ulList,Collections.reverseOrder());
			int resM = calc(umList,mbList) + calc(ulList,lbList);
			if (resM < ans)
				ans = resM;
		}
		if (ans != Integer.MAX_VALUE)
			return ans;
		return -1;
	}
}
