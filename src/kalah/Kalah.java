package kalah;

import com.qualitascorpus.testsupport.IO;
import com.qualitascorpus.testsupport.MockIO;


/**
 * This class is the starting point for a Kalah implementation using
 * the test infrastructure.
 */
public class Kalah {
	public static void main(String[] args) {
		new Kalah().play(new MockIO());
	}
	public void play(IO io) {
		boolean winCondition = false;

		Board board = new Board();
		
		while (winCondition == false){
			// main game here

			// TODO add actual thingies here
			io.println("+----+-------+-------+-------+-------+-------+-------+----+");
			io.println("| P2 | 6[ 4] | 5[ 4] | 4[ 4] | 3[ 4] | 2[ 4] | 1[ 4] |  0 |");
			io.println("|    |-------+-------+-------+-------+-------+-------|    |");
			io.println("|  0 | 1[ 4] | 2[ 4] | 3[ 4] | 4[ 4] | 5[ 4] | 6[ 4] | P1 |");
			io.println("+----+-------+-------+-------+-------+-------+-------+----+");
			io.println("Player 1's turn - Specify house number or 'q' to quit: ");			

			String suppliedInput = io.readFromKeyboard("Enter one of 'yes' or 'no' please");
			//int suppliedInput = io.readInteger("Enter a number between 1 and 20", 1, 20, -1, "no");
			if (suppliedInput.toLowerCase() == "q"){
				break;
			}
			int inputNum = Integer.parseInt(suppliedInput);

			// player 1's turn
			board.MoveSeeds(inputNum -1, 1);
			// IO

			// do stuff


			// player 2's turn

			// TODO remove this later
			winCondition = true;
		}

		
	}

	public void defaultPrint(IO io){

		// Replace what's below with your implementation
		io.println("+----+-------+-------+-------+-------+-------+-------+----+");
		io.println("| P2 | 6[ 4] | 5[ 4] | 4[ 4] | 3[ 4] | 2[ 4] | 1[ 4] |  0 |");
		io.println("|    |-------+-------+-------+-------+-------+-------|    |");
		io.println("|  0 | 1[ 4] | 2[ 4] | 3[ 4] | 4[ 4] | 5[ 4] | 6[ 4] | P1 |");
		io.println("+----+-------+-------+-------+-------+-------+-------+----+");
		io.println("Player 1's turn - Specify house number or 'q' to quit: ");
	}
}
