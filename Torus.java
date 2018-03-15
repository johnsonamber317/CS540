import java.util.*;
import java.io.*;


class State {
	int[] board;
	State parentPt;
	int depth;

	public State(int[] arr) {
		this.board = Arrays.copyOf(arr, arr.length);
		this.parentPt = null;
		this.depth = 0;
	}

	public State[] getSuccessors(int option, int cutoff) {
		State[] successors = new State[4];
		int[] newBoard = Arrays.copyOf(board, board.length);
		State parent = new State(board);
		parentPt = parent;

		State before = new State(newBoard);
		if(board[0] == 0){
			//Add 1
			newBoard[0] = board[6];
			newBoard[3] = board[3];
			newBoard[6] = board[0];
			successors[3] = new State(newBoard);
			//Add 2
			newBoard[0] = board[3];
			newBoard[3] = board[0];
			newBoard[6] = board[6];
			State before3 = new State(newBoard);
			successors[2] = before3;
			//Add 3
			newBoard[1] = board[1];
			newBoard[0] = board[2];
			newBoard[2] = board[0];
			newBoard[3] = board[3];
			newBoard[6] = board[6];
			State before4 = new State(newBoard);
			successors[1] = before4;
			//Add 4
			newBoard[0] = board[1];
			newBoard[1] = board[0];
			newBoard[2] = board[2];
			newBoard[3] = board[3];
			newBoard[6] = board[6];
			State before5 = new State(newBoard);
			successors[0] = before5;
		}
		if(board[1] == 0){
			//Add 1
			newBoard[1] = board[7];
			newBoard[4] = board[4];
			newBoard[7] = board[1];
			State before2 = new State(newBoard);
			successors[3] = before2;
			//Add 2
			newBoard[1] = board[4];
			newBoard[7] = board[7];
			newBoard[4] = board[1];
			newBoard[0] = board[0];
			newBoard[2] = board[2];
			State before3 = new State(newBoard);
			successors[2] = before3;
			//Add 3
			newBoard[1] = board[2];
			newBoard[2] = board[1];
			newBoard[4] = board[4];
			State before4 = new State(newBoard);
			successors[1] = before4;
			//Add 4
			newBoard[1] = board[0];
			newBoard[0] = board[1];
			newBoard[2] = board[2];
			State before5 = new State(newBoard);
			successors[0] = before5;
		}
		if(board[2] == 0){
			//Add 1
			newBoard[2] = board[8];
			newBoard[5] = board[5];
			newBoard[8] = board[2];
			State before2 = new State(newBoard);
			successors[3] = before2;
			//Add 2
			newBoard[2] = board[5];
			newBoard[5] = board[2];
			newBoard[8] = board[8];
			State before3 = new State(newBoard);
			successors[2] = before3;
			//Add 3
			newBoard[1] = board[2];
			newBoard[2] = board[1];
			newBoard[5] = board[5];
			State before4 = new State(newBoard);
			successors[1] = before4;
			//Add 4
			newBoard[1] = board[1];
			newBoard[0] = board[2];
			newBoard[2] = board[0];
			State before5 = new State(newBoard);
			successors[0] = before5;
		}
		if(board[3] == 0){
			//Add 1
			newBoard[0] = board[6];
			newBoard[6] = board[0];
			newBoard[3] = board[3];
			State before2 = new State(newBoard);
			successors[3] = before2;
			//Add 2
			newBoard[3] = board[5];
			newBoard[4] = board[4];
			newBoard[5] = board[3];
			State before3 = new State(newBoard);
			successors[2] = before3;
			//Add 3
			newBoard[3] = board[4];
			newBoard[5] = board[5];
			newBoard[4] = board[3];
			State before4 = new State(newBoard);
			successors[1] = before4;
			//Add 4
			newBoard[0] = board[3];
			newBoard[6] = board[6];
			newBoard[3] = board[0];
			State before5 = new State(newBoard);
			successors[0] = before5;
		}
		if(board[4] == 0){
			//Add 1
			newBoard[4] = board[7];
			newBoard[7] = board[4];
			newBoard[2] = board[2];
			State before2 = new State(newBoard);
			successors[3] = before2;
			//Add 2
			newBoard[4] = board[5];
			newBoard[5] = board[4];
			newBoard[3] = board[3];

			newBoard[7] = board[7];
			State before3 = new State(newBoard);
			successors[2] = before3;
			//Add 3
			newBoard[3] = board[4];
			newBoard[5] = board[5];
			newBoard[4] = board[3];
			newBoard[7] = board[7];
			State before4 = new State(newBoard);
			successors[1] = before4;
			//Add 4
			newBoard[1] = board[4];
			newBoard[4] = board[1];
			newBoard[7] = board[7];
			newBoard[3] = board[3];
			State before5 = new State(newBoard);
			successors[0] = before5;
		}
		if(board[5] == 0){
			//Add 1
			newBoard[5] = board[8];
			newBoard[8] = board[5];
			successors[3] = new State(newBoard);
			//Add 2
			newBoard[4] = board[5];
			newBoard[5] = board[4];
			newBoard[8] = board[8];
			State before3 = new State(newBoard);
			successors[2] = before3;
			//Add 3
			newBoard[3] = board[5];
			newBoard[5] = board[3];
			newBoard[4] = board[4];
			State before4 = new State(newBoard);
			successors[1] = before4;
			//Add 4
			newBoard[2] = board[5];
			newBoard[5] = board[2];
			newBoard[3] = board[3];
			State before5 = new State(newBoard);
			successors[0] = before5;
		}
		if(board[6] == 0){
			//Add 1
			newBoard[6] = board[8];
			newBoard[8] = board[6];
			State before2 = new State(newBoard);
			successors[3] = before2;
			//Add 2
			newBoard[6] = board[7];
			newBoard[7] = board[6];
			newBoard[8] = board[8];
			State before3 = new State(newBoard);
			successors[2] = before3;
			//Add 3
			newBoard[3] = board[6];
			newBoard[6] = board[3];
			newBoard[7] = board[7];
			State before4 = new State(newBoard);
			successors[1] = before4;
			//Add 4
			newBoard[0] = board[6];
			newBoard[6] = board[0];
			newBoard[3] = board[3];
			State before5 = new State(newBoard);
			successors[0] = before5;
		}
		if(board[7] == 0){
			//Add 1
			newBoard[7] = board[8];
			newBoard[8] = board[7];
			State before2 = new State(newBoard);
			successors[3] = before2;
			//Add 2
			newBoard[6] = board[7];
			newBoard[7] = board[6];
			newBoard[8] = board[8];
			State before3 = new State(newBoard);
			successors[2] = before3;
			//Add 3
			newBoard[4] = board[7];
			newBoard[7] = board[4];
			newBoard[6] = board[6];
			State before4 = new State(newBoard);
			successors[1] = before4;
			//Add 4
			newBoard[1] = board[7];
			newBoard[7] = board[1];
			newBoard[4] = board[4];
			State before5 = new State(newBoard);
			successors[0] = before5;
		}
		if(board[8] == 0){
			//Add 1
			newBoard[7] = board[8];
			newBoard[8] = board[7];
			State before2 = new State(newBoard);
			successors[3] = before2;
			//Add 2
			newBoard[6] = board[8];
			newBoard[8] = board[6];
			newBoard[7] = board[7];
			State before3 = new State(newBoard);
			successors[2] = before3;
			//Add 3
			newBoard[5] = board[8];
			newBoard[8] = board[5];
			newBoard[6] = board[6];
			State before4 = new State(newBoard);
			successors[1] = before4;
			//Add 4
			newBoard[2] = board[8];
			newBoard[8] = board[2];
			newBoard[5] = board[5];
			State before5 = new State(newBoard);
			successors[0] = before5;
		}
		List<State> list = Arrays.asList(successors);
		Stack<State> stack = new Stack<State>();

		for(int i = 0; i < 4; i++){
			stack.push(successors[i]);
		}
		if(option != 1){
			for(int i = 0; i < 4; i++){
				successors[i] = stack.pop();


			}
		}

		return successors;
	}

	public State[] sort (State[] previous){

		List<State> list = Arrays.asList(previous);
		Stack<State> stack = new Stack<State>();
		stack.addAll(list);


		for(int i = 0; i < 4; i++){
			previous[i] = stack.pop();
		}
		return previous;

	}

	public void printState(int option) {

		if(option == 1){
			for(int i = 0; i < 9; i++){
				System.out.print(this.board[i] + " ");
			}
			System.out.println(" ");
		}
		if(option == 2){
			for(int i = 0; i < 9; i++){
				System.out.print(this.board[i] + " ");
			}
			System.out.println(" ");
		}
		if(option == 3){

			for(int i = 0; i < 9; i++){
				if(i == 8){
					System.out.print(this.board[i]);
				}
				else{
					System.out.print(this.board[i] + " ");
				}
			}

			System.out.print(" parent ");
		}
		if(option == 4){
			for(int i = 0; i < 9; i++){
				System.out.print(this.board[i] + " ");
			}
			System.out.println(" ");
		}


	}


	public String getBoard() {
		StringBuilder builder = new StringBuilder();
		for (int i = 0; i < 9; i++) {
			builder.append(this.board[i]).append(" ");
		}
		return builder.toString().trim();
	}

	public boolean isGoalState() {
		for (int i = 0; i < 9; i++) {
			if (this.board[i] != (i + 1) % 9)
				return false;
		}
		return true;
	}

	public boolean equals(State src) {
		for (int i = 0; i < 9; i++) {
			if (this.board[i] != src.board[i])
				return false;
		}
		return true;
	}
}

public class Torus {

	public static void main(String args[]) {
		if (args.length < 10) {
			System.out.println("Invalid Input");
			return;
		}
		int flag = Integer.valueOf(args[0]);
		int[] board = new int[9];
		for (int i = 0; i < 9; i++) {
			board[i] = Integer.valueOf(args[i + 1]);
		}
		int option = flag / 100;
		int cutoff = flag % 100;
		if (option == 1) {
			State init = new State(board);
			State[] successors = init.getSuccessors(option, 0);
			for (State successor : successors) {
				successor.printState(option);
			}
		} 
		else if (option == 2){
			for (int i = 0; i < 9; i++) {
				System.out.print(Integer.valueOf(args[i + 1]) + " ");
			}
			System.out.println("");
			State init = new State(board);
			State[] successors = init.getSuccessors(option,0);
			for (State successor : successors) {
				successor.printState(option);
			}


		}
		else if (option == 3){
			for (int i = 0; i < 9; i++) {
				System.out.print(Integer.valueOf(args[i + 1]) + " ");
			}
			System.out.println("parent 0 0 0 0 0 0 0 0 0");
			State init = new State(board);
			State[] successors = init.getSuccessors(option,0);
			for (State successor : successors) {
				successor.printState(option);
				for (int i = 0; i < 9; i++) {
					System.out.print(Integer.valueOf(args[i + 1]) + " ");
				}
				System.out.println("");
			}
		}
		else if(option == 4){
			for (int i = 0; i < 9; i++) {
				System.out.print(Integer.valueOf(args[i + 1]) + " ");
			}
			System.out.println("");
			State init = new State(board);
			State[] successors = init.getSuccessors(option, cutoff);
			for (State successor : successors) {
				successor.printState(option);
			}
		}
		else {
			State init = new State(board);
			Stack<State> stack = new Stack<>();
			List<State> prefix = new ArrayList<>();
			int goalChecked = 0;
			int maxStackSize = Integer.MIN_VALUE;

			// needed for Part E
			while (true) {				
				stack.push(init);
				while (!stack.isEmpty()) {
					//TO DO: perform iterative deepening; implement prefix list

				}

				if (option != 5)
					break;

				//TO DO: perform the necessary steps to start a new iteration
				//       for Part E

			}
		}
	}
}

