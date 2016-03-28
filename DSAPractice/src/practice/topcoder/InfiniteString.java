package practice.topcoder;

/**
 * https://community.topcoder.com/stat?c=problem_statement&pm=13783
 * 
 */
public class InfiniteString {
	public static final String EQUAL = "Equal";
	public static final String UNEQUAL = "Not Equal";
	
	public String equal(String s, String t) {
		if(s.charAt(0) == t.charAt(0)) {
			int lenOfS = s.length();
			int lenOfT = t.length();
			if(lenOfS != lenOfT) {
				int diff = java.lang.Math.abs(lenOfS - lenOfT);
				String subStr = "";
				if(lenOfS < lenOfT) {
					subStr = s.substring(0, diff);
					s = s + subStr;
				} else {
					subStr = t.substring(0, diff);
					t = t + subStr;
				}
				if(s.equals(t))
					return EQUAL;
				else
					return UNEQUAL;
			} else {
				if(s.equals(t))
					return EQUAL;
				else
					return UNEQUAL;
			}
		} else {
			return UNEQUAL;
		}
	}
}
