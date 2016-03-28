package practice.topcoder;

/**
 * https://community.topcoder.com/stat?c=problem_statement&pm=1692
 * 
 */
public class YahtzeeScore {
	private int[] dieValues;
	
	public YahtzeeScore() {
		dieValues = new int[6];
		for(int i=0; i < 6; i++) {
			dieValues[i] = 0;
		}
	}

	public int maxPoints(int[] toss) {
		int maxScore = 0;
		for(int i = 0; i < toss.length; i++) {
			int val = toss[i];
			dieValues[val-1] += val;
			if(dieValues[val-1] > maxScore)
				maxScore = dieValues[val-1];
		}
		return maxScore;
	}
}
