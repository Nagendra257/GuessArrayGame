package guessme;

/**
 * An Array-based implementation of the Guess-A-Number game
 */
public class ArrayGame {

	// stores the next number to guess
	private int guess;
	private boolean[] flag;
	private int numOfGuesses;
	private boolean gameOver;
	private int[] priorGuesses;

	// TODO: declare additional data members, such as arrays that store
	// prior guesses, eliminated candidates etc.

	// NOTE: only primitive type arrays are allowed, such as int[], boolean[] etc.
	// You MAY NOT use any Collection type (such as ArrayList) provided by Java.

	/********************************************************
	 * NOTE: you are allowed to add new methods if necessary, but DO NOT remove any
	 * provided method, otherwise your code will fail the JUnit tests! Also DO NOT
	 * create any new Java files, as they will be ignored by the autograder!
	 *******************************************************/

	// ArrayGame constructor method
	public ArrayGame() {
		// TODO
		guess = 1000;
		flag = new boolean[9999 - 1000 + 1];
		for (int i = 0; i < flag.length; i++) {
			flag[i] = true;
		}
		numOfGuesses = 0;
		gameOver = false;
		priorGuesses = new int[18];

	}

	// Resets data members and game state so we can play again
	public void reset() {
		guess = 1000;
		flag = new boolean[9999 - 1000 + 1];
		for (int i = 0; i < flag.length; i++) {
			flag[i] = true;
		}
		numOfGuesses = 0;
		priorGuesses = new int[18];

		// TODO
	}

	// Returns true if n is a prior guess; false otherwise.
	public boolean isPriorGuess(int n) {
		// TODO
		for (int k = 0; k < numOfGuesses; k++) {
			if (n == priorGuesses[k])
				return true;
		}
		return false;
	}

	// Returns the number of guesses so far.
	public int numGuesses() {
		// TODO
		return numOfGuesses;
	}

	/**
	 * Returns the number of matches between integers a and b. You can assume that
	 * both are 4-digits long (i.e. between 1000 and 9999). The return value must be
	 * between 0 and 4.
	 * 
	 * A match is the same digit at the same location. For example: 1234 and 4321
	 * have 0 match; 1234 and 1114 have 2 matches (1 and 4); 1000 and 9000 have 3
	 * matches (three 0's).
	 */
	public static int numMatches(int a, int b) { // DO NOT remove the static qualifier
		// TODO
		int match = 0;
		int i = 0;
		int first, second;

		while (i < 4) {
			first = a % 10;
			a = a / 10;
			second = b % 10;
			b = b / 10;
			if (first == second) {
				match++;
			}
			i++;
		}
		return match;
	}

	/**
	 * Returns true if the game is over; false otherwise. The game is over if the
	 * number has been correctly guessed or if all candidates have been eliminated.
	 */
	public boolean isOver() {
	
		return gameOver;
	}

	// Returns the guess number and adds it to the list of prior guesses.
	public int getGuess() {
		// TODO: add guess to the list of prior guesses.
		priorGuesses[numOfGuesses++] = guess;


		return guess;
	}

	/**
	 * Updates guess based on the number of matches of the previous guess. If
	 * nmatches is 4, the previous guess is correct and the game is over. Check
	 * project description for implementation details.
	 * 
	 * Returns true if the update has no error; false if all candidates have been
	 * eliminated (indicating a state of error);
	 */
	public boolean updateGuess(int nmatches) {


		if (nmatches == 4) {
			gameOver = true;
			return true;
		}
		else {
			
			for (int i = 0; i < flag.length; i++) {
				if (numMatches(guess, i + 1000) != nmatches) {
					flag[i] = false;
				}
			}
			for (int p = 0; p < flag.length; p++) {
				if (flag[p]) {
					guess = p + 1000;

					return true;
				}
			}
		}

		return false;
	}

	// Returns the list of guesses so far as an integer array.
	// The size of the array must be the number of prior guesses.
	// Returns null if there has been no prior guess
	public int[] priorGuesses() {
		// TODO
		if (numOfGuesses > 0) {
			int[] finalArray = new int[numOfGuesses];
			for (int i = 0; i < numOfGuesses; i++) {
				finalArray[i] = priorGuesses[i];
			}
			return finalArray;
		}
		return null;
	}
}
