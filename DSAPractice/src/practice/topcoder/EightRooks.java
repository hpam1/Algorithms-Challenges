package practice.topcoder;

/**
 * https://community.topcoder.com/stat?c=problem_statement&pm=13773&rd=16417
 * 
 */
public class EightRooks {
	public static final String ROOK = "R";
	public static final String INCORRECT = "Incorrect";
	public static final String CORRECT = "Correct";
	public int[] colArr = new int[8];

	public void initializeColArr() {
		for(int i = 0; i < 8; i++) {
			colArr[i] = 0;
		}
	}

	public String isCorrect(String[] board) {
		initializeColArr();
		int noOfRooks = 0;
		for(String row: board) {
			int firstOccr = row.indexOf(ROOK);
			int lastOccr = row.lastIndexOf(ROOK);
			if(firstOccr < 0 || firstOccr != lastOccr) {
				return INCORRECT;
			} 
			if(colArr[firstOccr] != 0) {
				return INCORRECT;
			}
			colArr[firstOccr] = 1;
			noOfRooks++;
		}
		if(noOfRooks != 8)
			return INCORRECT;
	
		return CORRECT;
	}
}
