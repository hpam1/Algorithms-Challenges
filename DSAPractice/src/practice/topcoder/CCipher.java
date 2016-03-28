package practice.topcoder;

/**
 * https://community.topcoder.com/stat?c=problem_statement&pm=1667
 */
public class CCipher {
	
	public String decode(String cipherText, int shift) {
		char[] message = cipherText.toCharArray();
		for(int i = 0; i < message.length; i++) {
			message[i] = (char) ((int) message[i] - 2);
			if(message[i] < 65) {
				int diff = 65 - message[i];
				message[i] = (char) (91 - diff);
			}
		}
		
		return new String(message);
	}

}