public class PlayingField {
	
	public static void main(String[] args) {
		
		//Welcome to my simulation of the classic Tic-Tac-Toe Game! 
		
		//The only controls needed to play are using the number pad to enter which move you would like to choose when prompted. 
		//The moves are numbered using an X, Y two-by-two coordinate system. For example, the middle spot of the board would
		//correlate to |X Position: 1, Y Position: 1| 
		//Below you will find the 3 simulation game styles I have coded.
		//The first being standard manual play between 2 players giving the X | Y input. 
		//The other 2 consist of two AI Algorithms; MiniMax & Alpha-Beta Search. You can choose to either have the algorithms play itself
		//and control both X & Y players or try your luck and compete against the algorithms yourself, playing as player O. Simply 
		//comment out the gamestyle you wish not to play and have fun! The descriptions should assist in determining which is which.
		
		//*Both Algorithms are coded to play the most optimal game for the player it is controlling
		//and will always tie when playing against itself
		
		TTT tictactoe = new TTT();
		
		Manual manual = new Manual(tictactoe);
		manual.play(); //Both player X & O are manual players & must give input
		
		//MiniMax.play(); //MiniMax algorithm is playing against MiniMax algorithm 
		//MiniMax.play2(); //Player X is MiniMax, Player O is manual and must give input.
		
		//AlphaBeta.play();  //AlphaBeta Search is playing against AlphaBeta Search
		//AlphaBeta.play2(); //Player X is AlphaBeta, Player O is manual
		
		
		
	}



}
