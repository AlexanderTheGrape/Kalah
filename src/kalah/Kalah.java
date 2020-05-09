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
		int inputNum;
		String suppliedInput;
		
		while (winCondition == false){
			// main game here

			// TODO add actual thingies here
			io.println("+----+-------+-------+-------+-------+-------+-------+----+");
			io.println("| P2 | 6[ 4] | 5[ 4] | 4[ 4] | 3[ 4] | 2[ 4] | 1[ 4] |  0 |");
			io.println("|    |-------+-------+-------+-------+-------+-------|    |");
			io.println("|  0 | 1[ 4] | 2[ 4] | 3[ 4] | 4[ 4] | 5[ 4] | 6[ 4] | P1 |");
			io.println("+----+-------+-------+-------+-------+-------+-------+----+");
			io.println("Player 1's turn - Specify house number or 'q' to quit: ");

			// player 1's turn
			suppliedInput = io.readFromKeyboard("Player 1's turn - Specify house number or 'q' to quit: ");
			if (suppliedInput.toLowerCase() == "q"){
				break;
			}
			inputNum = Integer.parseInt(suppliedInput);
			board.MoveSeeds(inputNum -1, 1);


			// player 2's turn
			suppliedInput = io.readFromKeyboard("Player 1's turn - Specify house number or 'q' to quit: ");
			if (suppliedInput.toLowerCase() == "q"){
				break;
			}
			inputNum = Integer.parseInt(suppliedInput);
			board.MoveSeeds(inputNum -1, 2);


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
