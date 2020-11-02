package application;

public class Conditions extends Board {

	/*Validates move for: 
	 * if there is a winner
	 * if the move is on the correct side
	 * if the board tile has more than 1 piece
	 */
	
	public boolean validMove(int input) {		
		if (winner()) {
			return false;
		}
		if (checkSide(input)) {
			System.out.println("Not correct turn");
			return false;
		}
		if (getBoardAt(input) == 0) {
			System.out.println("Cannot grab from 0");
			return false;
		}

		return true;

	}
	//playerOne's side is from 0 to 5 home is at 6
	//playerTwo's side is from 7 to 12 home is at 13
	
	public boolean checkSide(int input) {
		boolean player = getPlayer();
		if (!player && (input > 5) || player && (input <= 5)) {
			return false;
		}
		return true;
	}

	// Determined which player wins
	public boolean winner() {
		int p_1 = getP1End();
		int p_2 = getP2End();
		int[] empty = { 0, 0, 0, 0, 0, 0, p_1, 0, 0, 0, 0, 0, 0, p_2 };
		int[] check = getBoard();
		for (int i = 0; i <= check.length; i++) {
			if (check[i] != empty[i]) {
				return false;
			}
		}
		return true;
	}

	// if last drop is in an empty slot you take the opposite side
	public boolean checkSteal() {
		return false;

		// check if its the correct player's mancala before dropping

	}

}
