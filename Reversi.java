import java.util.*;

class State {
	char[] board;

	public State(char[] arr) {
		this.board = Arrays.copyOf(arr, arr.length);
	}

	public int getScore() {

		// TO DO: return game theoretic value of the board
		int score = 0;
		String input = board.toString();
		for(int i = 0; i < board.length; i++){
			if(board[i] == 1){
				score++;
			}
		}

		return score;
	}
	/*fix*/
	public boolean isTerminal() {

		// TO DO: determine if the board is a terminal node or not and return boolean
		boolean is_terminal = false;
		//if( this.getSuccessors('1').length == 0 || this.getSuccessors('2').length == 0){
		//	is_terminal = true;
		//}

		return is_terminal;
	}

	public State[] getSuccessors(char player) {

		// TO DO: get all successors and return them in proper order
		State[] successors = new State[16];
		int index = 0;
		char [][] newBoard = copyBoard(this.board);
		for(int i = 0; i < newBoard.length; i++){
			for(int j = 0; j < newBoard[i].length; j++){
				if(newBoard[i][j] != '0'){
					continue;
				}  			
				char [][] newBoard2 = copyBoard(this.board);
				newBoard[i][j] = player;
				boolean add = false;

				//Check all 8 directions
				for(int k = -1; k <= 1; k++){
					for(int l = -1; l <= 1; l++){
						if(k == 0 && l == 0){
							continue;
						}
						int m = i;
						int n = j;
						int flips = 0; 
						boolean end = false;
						while(m + k >= 0 && m + k < newBoard.length && n + j >= 0 && n + j < newBoard.length){
							//m += k;
							//n += l;
							if (newBoard[m][n] == '0'){
								flips = 0;
								break;
							}
							else if(newBoard[m][n] == player){
								end = true;
								break;
							}
							flips++;
						}
						if(!end){
							flips = 0;
						}
						while(flips > 0){
							add = true;
							newBoard[i + k * flips][j + l * flips] = player;
							flips--;
						}
					}
					if(add){
						for(int z = 0; z <= newBoard2.length; z++){
							successors[index] = new State(newBoard2[z]);
							index++;
						}
					}
				}
			}

		}
		if(index == 0 && !isTerminal()){
			for(int z = 0; z <= newBoard.length; z++){
				successors[index] = new State(newBoard[z]);
				index++;
			}
		}
		State[] successors2 = new State[index];
		for(int i = 0; i < index; i++){
			successors[i] = successors[i];
		}
		return successors;
	}
	//Changes a one dimensional array to two dimensions
	public char[][] copyBoard(char[] board){
		char[] oneD = board;
		int w = 4;
		int h = 4;
		char[][] dims = new char[h][w];
		char[] oneBackwards = new char[oneD.length];

		for (int i = 0; i < h; i++) {
			for (int j = 0; j < w; j++) {
				dims[i][j] = oneD[i*w+j];
			}
		}

		for (int i = 0; i < w*h; i++) {
			oneBackwards[i] = dims[(i / w)][(i%w)];
		}
		return dims;
	}
	public void printState(int option, char player) {

		if(option == 1){
			System.out.println(this.getSuccessors(player));
		}
		else if(option == 2){
			if(!this.isTerminal()){
				System.out.println("non-terminal");
			}
			else{
				if(this.getScore() > 0){
					System.out.println("1");
				}
				else if (this.getScore() == 0){
					System.out.println("0");
				}
				else{
					System.out.println("-1");
				}

			}
		}
		else if(option == 3){
			Minimax total;
			State board2;;
			int score = 0;
			int score2 = 0;
			//score = total.max_value(board2);
			//score2 = total.max_value(board2) + total.min_value(board2);
			System.out.println(score);
			System.out.println(score2);
		}
		else if(option == 4){

		}
		else if(option == 5){

		}
		else if(option == 6){

		}

	}

	public String getBoard() {
		StringBuilder builder = new StringBuilder();
		for (int i = 0; i < 16; i++) {
			builder.append(this.board[i]);
		}
		return builder.toString().trim();
	}

	public boolean equals(State src) {
		for (int i = 0; i < 16; i++) {
			if (this.board[i] != src.board[i])
				return false;
		}
		return true;
	}
}

class Minimax {
	private static int max_value(State curr_state) {

		// TO DO: implement Max-Value of the Minimax algorithm
		int max = 0;
		return max;

	}

	private static int min_value(State curr_state) {

		// TO DO: implement Min-Value of the Minimax algorithm
		int min = 0;
		return min;

	}

	private static int max_value_with_pruning(State curr_state, int alpha, int beta) {

		// TO DO: implement Max-Value of the alpha-beta pruning algorithm
		int maxp = 0;
		return maxp;

	}

	private static int min_value_with_pruning(State curr_state, int alpha, int beta) {

		// TO DO: implement Min-Value of the alpha-beta pruning algorithm
		int minp = 0;
		return minp;

	}

	public static int run(State curr_state, char player) {

		// TO DO: run the Minimax algorithm and return the game theoretic value
		int runVal = 0;
		return runVal;

	}

	public static int run_with_pruning(State curr_state, char player) {

		// TO DO: run the alpha-beta pruning algorithm and return the game theoretic value
		int runPrune = 0;
		return runPrune;

	}
}

public class Reversi {
	public static void main(String args[]) {
		if (args.length != 3) {
			System.out.println("Invalid Number of Input Arguments");
			return;
		}
		int flag = Integer.valueOf(args[0]);
		char[] board = new char[16];
		for (int i = 0; i < 16; i++) {
			board[i] = args[2].charAt(i);
		}
		int option = flag / 100;
		char player = args[1].charAt(0);
		if ((player != '1' && player != '2') || args[1].length() != 1) {
			System.out.println("Invalid Player Input");
			return;
		}
		State init = new State(board);
		init.printState(option, player);
	}
}

