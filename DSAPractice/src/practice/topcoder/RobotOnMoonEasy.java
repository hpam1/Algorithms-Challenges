package practice.topcoder;

/**
 * topcoder.com - SRM 651 Div2
 * 
 *
 */
public class RobotOnMoonEasy {
	public static final String ALIVE = "Alive";
	public static final String DEAD = "Dead";
	public static final String ROBOT_POSITION = "S";
	public static final char FREE_SPACE = '.';
	public static final char OBSTACLE = '#';
	public static final char MOVE_UP = 'U';
	public static final char MOVE_DOWN = 'D';
	public static final char MOVE_LEFT = 'L';
	public static final char MOVE_RIGHT = 'R';
	
	private int robotPositionX = 0;
	private int robotPositionY = 0;
	private int maxRows = 0;
	private int maxCols = 0;
	private char[][] simpleBoard = null;
	
	public String isSafeCommand(String[] board, String instructions) throws Exception{
		simpleBoard = constructBoard(board);
		char[] commands = instructions.toCharArray();
		int newPosition = 0;
		for(char ch: commands) {
			switch(ch) {
				case MOVE_UP:
					newPosition = robotPositionX - 1;
					if(validateRobotPosition(newPosition, robotPositionY)) {
						if(!isObstacle(newPosition, robotPositionY)){
							robotPositionX--;
						}
					} else {
						return DEAD;
					}
					break;
				case MOVE_DOWN:
					newPosition = robotPositionX + 1;
					if(validateRobotPosition(newPosition, robotPositionY)) {
						if(!isObstacle(newPosition, robotPositionY)){
							robotPositionX++;
						}
					} else {
						return DEAD;
					}
					break;
				case MOVE_LEFT:
					newPosition = robotPositionY - 1;
					if(validateRobotPosition(robotPositionX, newPosition)) {
						if(!isObstacle(robotPositionX, newPosition)){
							robotPositionY--;
						}
					} else {
						return DEAD;
					}			
					break;
				case MOVE_RIGHT:
					newPosition = robotPositionY + 1;
					if(validateRobotPosition(robotPositionX, newPosition)) {
						if(!isObstacle(robotPositionX, newPosition)){
							robotPositionY++;
						}
					} else {
						return DEAD;
					}
					break;	
			}
		}
		return ALIVE;
	}
	
	private boolean isObstacle(int positionX, int positionY) {
		if(simpleBoard != null && simpleBoard[positionX][positionY] == OBSTACLE)
			return true;
		return false;
	}
	
	private boolean validateRobotPosition(int positionX, int positionY) {
		if(positionX < 0 || positionX >= maxRows)
			return false;
		if(positionY < 0 || positionY >= maxCols)
			return false;
		return true;
	}
	
	private char[][] constructBoard(String[] board) throws Exception {
		int length = -1;
		int counter = 0;
		boolean robotEncountered = false;
		for(String str: board) {
			if(length == -1) {
				length = str.length();
				simpleBoard = new char[board.length][length];
				maxRows = board.length;
				maxCols = length;
			} else {
				if(length != str.length())
					throw new Exception("Invalid board");
			}
			char[] rowDetails = str.toCharArray();
			if(str.contains(ROBOT_POSITION)) {
				if(robotEncountered)
					throw new Exception("Invalid board");
				else {
					robotPositionX = counter;
					robotPositionY = str.indexOf(ROBOT_POSITION);
					robotEncountered = true;
				}
			}
			simpleBoard[counter++] = rowDetails;
		}
		return simpleBoard;
	}
}