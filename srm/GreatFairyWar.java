
public class GreatFairyWar {

	public int minHP(int[] dps, int[] hp) {
		int sumDamage = 0;
		int sumTotal = 0;
		for (int i = 0; i < hp.length; i++) {
			sumTotal += dps[i];
		}
		for (int i = 0; i < dps.length; i++) {
			sumDamage += sumTotal * hp[i];
			sumTotal -= dps[i];
		}
		return sumDamage;
	}
}
