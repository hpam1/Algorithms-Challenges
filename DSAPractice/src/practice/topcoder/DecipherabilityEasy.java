package practice.topcoder;

/**
 * https://community.topcoder.com/stat?c=problem_statement&pm=13658&rd=16313
 * 
 */
public class DecipherabilityEasy {
	public static final String POSSIBLE = "Possible";
	public static final String IMPOSSIBLE = "Impossible";
	
	public String check(String s, String t) {
		int lengthOfS = s.length();
		int lengthOfT = t.length();
		if((lengthOfS - lengthOfT) != 1)
			return IMPOSSIBLE;
		int sIndex = 0;
		int tIndex = 0;
		while(sIndex < lengthOfS) {
			if(s.charAt(sIndex) == t.charAt(tIndex)) {
				sIndex++;
				continue;
			} else {
				sIndex++;
				if(s.charAt(sIndex) == t.charAt(tIndex)) {
					sIndex++;
					tIndex++;
					continue;
				} else {
					return IMPOSSIBLE;
				}
			}
		}
		return POSSIBLE;	
	}
}