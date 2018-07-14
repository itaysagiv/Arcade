import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Random;

public class TikTakTo {
	
	//enums
	private enum TurnStatus { SUCCESS, OCCUPIED , OUT_OF_BOUND , ILLEGAL}
	
	//constants
	private static final int BOARD_DIM = 3;
	private static final int NUM_OF_PLAYERS = 2;
	//private static final int LENGTH_TO_WIN = 3;
	private static final char PLAYER_CHAR[] = {'X', 'O'};
	
	//member variables
	private char[][] board = new char[BOARD_DIM][BOARD_DIM];	//contains the board status
	private int currTurn;
	
	public static class Move {
		public enum MoveStatus { MOVE_OK, LEN_ERROR, OUT_OF_BOUND}
		
		public int line = 0;
		public int column = 0;
		public MoveStatus status;
		public Move(String str) {
			status = checkString(str);
			if(status == MoveStatus.MOVE_OK) {
				line = (int)(str.charAt(0) - 'A');
				column = (int)(str.charAt(1) - '1');	
			}
		}
		public static MoveStatus checkString(String str) {
			//string must be 2 characters long
			if(str.length() != 2)
				return MoveStatus.LEN_ERROR;
			//isolate 2 chars
			char c1 = str.charAt(0);
			char c2 = str.charAt(1);
			//check both chars are not out of bounds
			if(c1 < 'A' || c2 < '1' || c1 >= 'A'+BOARD_DIM || c2 >= '1'+BOARD_DIM)
				return MoveStatus.OUT_OF_BOUND;
			//otherwise all good
			return MoveStatus.MOVE_OK;
		}
	}
	
	//Ctor
	public TikTakTo() {
		// TODO Auto-generated constructor stub
		
		//create and initialize the board
		for(int i = 0 ; i < BOARD_DIM ; i++)
			for(int j = 0 ; j < BOARD_DIM ; j++)
				board[i][j] = ' ';
		Random rand = new Random();
		currTurn = rand.nextInt(NUM_OF_PLAYERS);
	}
	
	//Game start function
	public void run() throws IOException{
		while(checkWin() == -1) { //while no-one won yet
			clearScreen();
			printBoard();
			System.out.printf("Player %d turn\n", currTurn+1);
			performTurn(currTurn);
			currTurn = (currTurn+1) % NUM_OF_PLAYERS;
		}
	}
	
	//Turn management
	private TurnStatus performTurn(int playerNum) throws IOException{
		TurnStatus status = TurnStatus.SUCCESS;
		
		//get move from user
		System.out.printf("Enter a move: ");
		BufferedReader bufferReader = new BufferedReader(new InputStreamReader(System.in));
		String moveStr = bufferReader.readLine();
		Move move = new Move(moveStr);
		if(move.status == Move.MoveStatus.MOVE_OK) {
			//if move is valid check if the square is vacant
			if(board[move.line][move.column] == ' ') {
				board[move.line][move.column] = PLAYER_CHAR[playerNum];
			}
			else {
				status = TurnStatus.OCCUPIED;
			}
		}
		else {
			status = TurnStatus.ILLEGAL;
		}
		return status;
	}
	
	private int checkWin() {
		
		return -1;
	}
	
	//Printing methods
	private void printBoard() {
		for(int i = -1 ; i < BOARD_DIM ; i++) {
			for(int j = -1 ; j < BOARD_DIM ; j++) { 
				if(j == -1) {
					//print headers line at the top of the chart
					System.out.printf(" %c |", 'A'+i);
				}
				else if (i == -1) {
					System.out.printf(" %c |", '1'+j);
				}
				else {
					System.out.printf(" %c |",board[i][j]);
				}
			}
			System.out.printf("\n");
			for (int j = -1; j < BOARD_DIM; j++) {
				System.out.printf("---+");
			}
			System.out.printf("\n");
		}
	}
	
	//clear screen
	public static void clearScreen() throws IOException{  
		
	} 
}

