package application;

import java.io.IOException;
//import java.util.Arrays;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
//import javafx.scene.control.Label;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/*
 * Class meant to update the GUI
 */

public class Controller extends Board {
	@FXML
	private Button buttonToBoard;
	@FXML
	private Button slotOne;
	@FXML
	private Button slotTwo;
	@FXML
	private Button slotThree;
	@FXML
	private Button slotFour;
	@FXML
	private Button slotFive;
	@FXML
	private Button slotSix;
	@FXML
	private Button slotEight;
	@FXML
	private Button slotNine;
	@FXML
	private Button slotTen;
	@FXML
	private Button slotEleven;
	@FXML
	private Button slotTwelve;
	@FXML
	private Button slotThirteen;
	@FXML
	private Text oneText;
	@FXML
	private Text twoText;
	@FXML
	private Text threeText;
	@FXML
	private Text fourText;
	@FXML
	private Text fiveText;
	@FXML
	private Text sixText;
	@FXML
	private Text eightText;
	@FXML
	private Text nineText;
	@FXML
	private Text tenText;
	@FXML
	private Text elevenText;
	@FXML
	private Text twelveText;
	@FXML
	private Text thirteenText;
	
	@FXML
	private Text playerOneTotalNum;
	@FXML
	private Text playerTwoTotalNum;
	
	@FXML
	private Text playerOneCount;
	@FXML
	private Text playerTwoCount;

	@FXML
	private Button buttonNewGame;

	@FXML
	private Button playerTurn;

	/*
	 * @FXML private Text playerNumTurn;
	 */

	Conditions cond = new Conditions();

	//Whenver a button is clicked it will check if the move is valid and modify the board if it is
	
	public void bOneC() {
		if (cond.validMove(0)) {
			int[] getArray = makeTurn(0);
			setText(getArray);
		}
	}

	public void bTwoC() {
		if (cond.validMove(1)) {
			int[] getArray = makeTurn(1);
			setText(getArray);
		}
	}

	public void bThreeC() {
		if (cond.validMove(2)) {
			int[] getArray = makeTurn(2);
			setText(getArray);
		}
	}

	public void bFourC() {
		if (cond.validMove(3)) {
			int[] getArray = makeTurn(3);
			setText(getArray);
		}
	}

	public void bFiveC() {
		if (cond.validMove(4)) {
			int[] getArray = makeTurn(4);
			setText(getArray);
		}
	}

	public void bSixC() {
		if (cond.validMove(5)) {
			int[] getArray = makeTurn(5);
			setText(getArray);
		}
	}

	public void bEightC() {
		if (cond.validMove(7)) {
			int[] getArray = makeTurn(7);
			setText(getArray);
		}
	}

	public void bNineC() {
		if (cond.validMove(8)) {
			int[] getArray = makeTurn(8);
			setText(getArray);
		}
	}

	public void bTenC() {
		if (cond.validMove(9)) {
			int[] getArray = makeTurn(9);
			setText(getArray);
		}
	}

	public void bElevenC() {
		if (cond.validMove(10)) {
			int[] getArray = makeTurn(10);
			setText(getArray);
		}
	}

	public void bTwelveC() {
		if (cond.validMove(11)) {
			int[] getArray = makeTurn(11);
			setText(getArray);
		}
	}

	public void bThirteenC() {
		if (cond.validMove(12)) {
			int[] getArray = makeTurn(12);
			setText(getArray);
		}
	}

	//get the updated board and update text based on the updated board
	public void setText(int[] array) {

		String arrayString[] = new String[array.length];
		for (int i = 0; i < array.length; i++) {
			arrayString[i] = String.valueOf(array[i]);
		}

		oneText.setText(arrayString[0]);
		twoText.setText(arrayString[1]);
		threeText.setText(arrayString[2]);
		fourText.setText(arrayString[3]);
		fiveText.setText(arrayString[4]);
		sixText.setText(arrayString[5]);
		playerOneTotalNum.setText(arrayString[6]);
		eightText.setText(arrayString[7]);
		nineText.setText(arrayString[8]);
		tenText.setText(arrayString[9]);
		elevenText.setText(arrayString[10]);
		twelveText.setText(arrayString[11]);
		thirteenText.setText(arrayString[12]);
		playerTwoTotalNum.setText(arrayString[13]);
		playerOneCount.setText("Player 1's side: " + arrayString[6]);
		playerTwoCount.setText("Player 2's side: " + arrayString[13]);
		setPlayerText();

	}

	//set the text of who's turn it is
	public void setPlayerText() {
		boolean player = getPlayer();
		if (player) {
			playerTurn.setText("Player 1's Turn");
		} else {
			playerTurn.setText("Player 2' Turn");
	
		}
	}

	public void screenToMain(ActionEvent event) throws IOException {
		Parent viewMainBoard = FXMLLoader.load(getClass().getResource("/application/boardFX.fxml"));
		Scene viewBoardScene = new Scene(viewMainBoard, 1000, 580);
		Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
		window.setScene(viewBoardScene);
		window.show();
	}

	public void screenToRules(ActionEvent event) throws IOException {
		Parent viewRules = FXMLLoader.load(Main.class.getResource("/application/MancalaRules.fxml"));
		Scene viewRulesScene = new Scene(viewRules, 700, 550);
		Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
		window.setScene(viewRulesScene);
		window.show();
	}

	public void resetbutton() {
		setText(reset());
	}

}
