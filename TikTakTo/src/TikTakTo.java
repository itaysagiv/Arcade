import java.util.Random;

public class TikTakTo {
	
	//enums
	private enum TurnStatus { SUCCESS, ILLIGAL }
	
	//constants
	private static final int BOARD_DIM = 3;
	private static final int NUM_OF_PLAYERS = 2;
	
	//member variables
	private char[][] board = new char[BOARD_DIM][BOARD_DIM];	//contains the board status
	private int currTurn;
	
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
	public void run() {
		printBoard();
		for (int i = 0; i < NUM_OF_PLAYERS ; i++) {
			
		}
	}
	
	//Turn management
	private TurnStatus performTurn(int playerNum) {
		TurnStatus status = TurnStatus.SUCCESS;
		
		System.out.println("Enter a move:");
		return status;
	}
	
	//Printing methods
	private void printBoard() {
		for(int i = -1 ; i < BOARD_DIM ; i++) {
			for(int j = -1 ; j < BOARD_DIM ; j++) {
				if(i == -1) {
					System.out.printf(" %c |", 'A'+j);
				}
				else {
					System.out.printf(" %c ",board[i][j]);
					if(j != BOARD_DIM - 1)
						System.out.printf("|");
				}
			}
			if(i != BOARD_DIM - 1) {
				System.out.printf("\n");
				for (int j = 0; j < BOARD_DIM; j++) {
					
				}
				System.out.printf("\n");
			}
		}
	}
}

