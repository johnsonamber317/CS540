import java.util.*;
import java.io.*;

public class successor {
	public static class JugState {
		int[] Capacity = new int[]{0,0,0};
		int[] Content = new int[]{0,0,0};
		public JugState(JugState copyFrom)
		{
			this.Capacity[0] = copyFrom.Capacity[0];
			this.Capacity[1] = copyFrom.Capacity[1];
			this.Capacity[2] = copyFrom.Capacity[2];
			this.Content[0] = copyFrom.Content[0];
			this.Content[1] = copyFrom.Content[1];
			this.Content[2] = copyFrom.Content[2];
		}
		public JugState()
		{
		}
		public JugState(int A,int B, int C)
		{
			this.Capacity[0] = A;
			this.Capacity[1] = B;
			this.Capacity[2] = C;
		}
		public JugState(int A,int B, int C, int a, int b, int c)
		{
			this.Capacity[0] = A;
			this.Capacity[1] = B;
			this.Capacity[2] = C;
			this.Content[0] = a;
			this.Content[1] = b;
			this.Content[2] = c;
		}

		public void printContent()
		{
			System.out.println(this.Content[0] + " " + this.Content[1] + " " + this.Content[2]);
		}

		public ArrayList<JugState> getNextStates(){
			ArrayList<JugState> successors = new ArrayList<>();

			//If 0 is not empty, empty it
			if(this.Content[0] != 0){
				JugState newState1 = new JugState(this.Capacity[0], this.Capacity[1], this.Capacity[2], 0, this.Content[1], this.Content[2]);
				successors.add(newState1);
			}
			//If 1 is not empty, empty it
			if(this.Content[1] != 0){
				JugState newState1 = new JugState(this.Capacity[0], this.Capacity[1], this.Capacity[2], this.Content[0], 0, this.Content[2]);
				successors.add(newState1);
			}
			//If 2 is not empty, empty it
			if(this.Content[2] != 0){
				JugState newState1 = new JugState(this.Capacity[0], this.Capacity[1], this.Capacity[2], this.Content[0], this.Content[1], 0);
				successors.add(newState1);
			}
			//If 0 is not full, full it
			if(this.Content[0] != this.Capacity[0]){
				JugState newState1 = new JugState(this.Capacity[0], this.Capacity[1], this.Capacity[2], this.Capacity[0], this.Content[1], this.Content[2]);
				successors.add(newState1);
			}
			//If 1 is not full, full it
			if(this.Content[1] != this.Capacity[1]){
				JugState newState1 = new JugState(this.Capacity[0], this.Capacity[1], this.Capacity[2], this.Content[0], this.Capacity[1], this.Content[2]);
				successors.add(newState1);
			}
			//If 2 is not full, full it
			if(this.Content[2] != this.Capacity[2]){
				JugState newState1 = new JugState(this.Capacity[0], this.Capacity[1], this.Capacity[2], this.Content[0], this.Content[1], this.Capacity[2]);
				successors.add(newState1);
			}

			//If 0 is not empty and 1 is not full, pout from 0 to 1
			if(this.Content[0] != 0 && this.Content[1] != this.Capacity[1]){
				if(this.Content[0] + this.Content[1] <= this.Capacity[1]){

					JugState newState1 = new JugState(this.Capacity[0], this.Capacity[1], this.Capacity[2], 0, this.Content[1] + this.Content[0], this.Content[2]);
					successors.add(newState1);

				}
				else{

					JugState newState1 = new JugState(this.Capacity[0], this.Capacity[1], this.Capacity[2], this.Content[0] - this.Capacity[1]+ this.Content[1], this.Capacity[1], this.Content[2]);
					successors.add(newState1);
				}
			}
			if(this.Content[0] != 0 && this.Content[2] != this.Capacity[2]){
				if(this.Content[0] + this.Content[2] <= this.Capacity[2]){

					JugState newState1 = new JugState(this.Capacity[0], this.Capacity[1], this.Capacity[2], 0, this.Content[1], this.Content[0] + this.Content[2]);
					successors.add(newState1);

				}
				else{

					JugState newState1 = new JugState(this.Capacity[0], this.Capacity[1], this.Capacity[2], this.Content[0] - this.Capacity[2] + this.Content[2], this.Content[1], this.Capacity[2]);
					successors.add(newState1);
				}
			}
			if(this.Content[1] != 0 && this.Content[2] != this.Capacity[2]){
				if(this.Content[1] + this.Content[2] <= this.Capacity[2]){

					JugState newState1 = new JugState(this.Capacity[0], this.Capacity[1], this.Capacity[2], this.Content[0], 0, this.Content[1] + this.Content[2]);
					successors.add(newState1);

				}
				else{

					JugState newState1 = new JugState(this.Capacity[0], this.Capacity[1], this.Capacity[2], this.Content[0], this.Content[1] - this.Capacity[2] + this.Content[2], this.Capacity[2]);
					successors.add(newState1);
				}
			}
			if(this.Content[1] != 0 && this.Content[0] != this.Capacity[0]){
				if(this.Content[1] + this.Content[0] <= this.Capacity[0]){

					JugState newState1 = new JugState(this.Capacity[0], this.Capacity[1], this.Capacity[2], this.Content[1] + this.Content[0], 0, this.Content[2]);
					successors.add(newState1);

				}
				else{

					JugState newState1 = new JugState(this.Capacity[0], this.Capacity[1], this.Capacity[2], this.Capacity[0], this.Content[1]- this.Capacity[0] + this.Content[0], this.Content[2]);
					successors.add(newState1);
				}
			}
			if(this.Content[2] != 0 && this.Content[1] != this.Capacity[1]){
				if(this.Content[2] + this.Content[1] <= this.Capacity[1]){

					JugState newState1 = new JugState(this.Capacity[0], this.Capacity[1], this.Capacity[2], this.Content[0], this.Content[2] + this.Content[1] , 0);
					successors.add(newState1);

				}
				else{

					JugState newState1 = new JugState(this.Capacity[0], this.Capacity[1], this.Capacity[2], this.Content[0], this.Capacity[1], this.Content[2] - this.Capacity[1] + this.Content[1]);
					successors.add(newState1);
				}
			}
			if(this.Content[2] != 0 && this.Content[0] != this.Capacity[0]){
				if(this.Content[2] + this.Content[0] <= this.Capacity[0]){

					JugState newState1 = new JugState(this.Capacity[0], this.Capacity[1], this.Capacity[2], this.Content[2] + this.Content[0], this.Content[1] , 0);
					successors.add(newState1);

				}
				else{

					JugState newState1 = new JugState(this.Capacity[0], this.Capacity[1], this.Capacity[2], this.Capacity[0], this.Content[1], this.Content[2] - this.Capacity[0] + this.Content[0]);
					successors.add(newState1);
				}
			}

			 

			return successors;
		}
	}

	public static void main(String[] args) {
		if( args.length != 6 )
		{
			System.out.println("Usage: java successor [A] [B] [C] [a] [b] [c]");
			return;
		}

		// parse command line arguments
		JugState a = new JugState();
		a.Capacity[0] = Integer.parseInt(args[0]);
		a.Capacity[1] = Integer.parseInt(args[1]);
		a.Capacity[2] = Integer.parseInt(args[2]);
		a.Content[0] = Integer.parseInt(args[3]);
		a.Content[1] = Integer.parseInt(args[4]);
		a.Content[2] = Integer.parseInt(args[5]);


		// Implement this function
		ArrayList<JugState> asist = a.getNextStates();

		// Print out generated successors
		for(int i=0;i< asist.size(); i++)
		{
			asist.get(i).printContent();
		}

		return;
	}
}



