package practice.topcoder;

import java.util.HashMap;
import java.util.Map;

/**
 * 
 * https://community.topcoder.com/stat?c=problem_statement&pm=13748&rd=16416
 *
 */
public class CorruptedMessage {
	
	
	public String reconstructMessage(String s, int k) {
		Map<String, Integer> charMap = new HashMap<String, Integer>();
						
		for(int i = 0; i < s.length(); i++) {
			int j = i+1;
			String charVal = s.substring(i, j);
			if(charMap.containsKey(charVal)) {
				charMap.put(charVal, charMap.get(charVal)+1);
			} else {
				charMap.put(charVal, 1);
			}
		}
		int diff = s.length() - k;
		for(String key: charMap.keySet()) {
			if(charMap.get(key) == diff) {
				return constructString(key, s.length());
			}
		}
		return constructString("a", s.length());
	}
	
	private String constructString(String charStr, int k) {
		String outStr = "";
		
		for(int i = 0; i < k; i++) {
			outStr += charStr;
		}
		return outStr;
	}
}
