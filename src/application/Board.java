package application;

/*
 *Board Constructor
 */
public class Board {

	// Player one will be the first to move
	// Starting number in each pit will be 4
	// The board will have the starting numbers in each pit except for the end zones
	static boolean playerOneTurn = true;
	static int sNum = 4;
	public static int board[] = { sNum, sNum, sNum, sNum, sNum, sNum, 0, sNum, sNum, sNum, sNum, sNum, sNum, 0 };

	public static int getBoardAt(int a) {
		return board[a];
	}

	public static int getP1End() {
		return board[5];
	}

	public static int getP2End() {
		return board[13];
	}

	public static int[] getBoard() {
		return board;
	}

	public static boolean getPlayer() {
		return playerOneTurn;
	}

	// resets the board to the default state
	public static int[] reset() {
		for (int i = 0; i < board.length; i++) {
			board[i] = 4;
		}
		board[6] = 0;
		board[13] = 0;
		playerOneTurn = true;
		return board;
	}

	public boolean winnerP1() {
		int p_1 = getP1End();
		int p_2 = getP2End();
		int[] empty = { 0, 0, 0, 0, 0, 0, p_1, 0, 0, 0, 0, 0, 0, p_2 };
		int[] check = getBoard();
		for (int i = 0; i > check.length; i++) {
			if (check[i] != empty[i]) {
				return false;
			}
		}
		return true;
	}

	// calculates where the last piece was dropped off
	// helper method to caluate if the player ended at their home
	public static int calcEndPos(int start, int numPieces) {
		int sum = start + numPieces;
		if (sum > 13) {
			sum -= 14;
		}
		return sum;
	}

	/*
	 * Process of making a turn ========================= The place where the board
	 * is clicked will be emptied All the following places will be incremented until
	 * there are no more pieces left to distribute If the ending point is not that
	 * player's home the player turn will change
	 */

	public static int[] makeTurn(int buttonStart) {
		int startIndex = buttonStart;
		int counter = 1;
		int numPieces = board[startIndex];

		// empty board at start index
		board[startIndex] = 0;

		// loop until no more pieces
		for (int i = numPieces; i > 0; i--) {
			if (counter + startIndex > 13) {
				counter = 0;
				startIndex = 0;
			}
			board[startIndex + counter]++;
			counter++;
		}

		// calculate where the last piece was placed
		int endPos = calcEndPos(startIndex, numPieces);
		if (!playerOneTurn && endPos != 13 || playerOneTurn && endPos != 6) {
			playerOneTurn = !playerOneTurn;
		}

		return board;

	}

}
