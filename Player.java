import java.util.ArrayList;
import java.util.Scanner;

public class Player {
	private int x;
	private int y;
	private char who;
	
	public Player(char who) {
		// TODO Auto-generated constructor stub
		this.who = who;
		//this.x = x;
		//this.y = y;
		
	}
	
	public int get_x() {
		return x;
	}
	
	public int get_y() {
		return y;
	}
	
		
	public char get_who() {
		return who;
	}
	
	public TTT ply_manual(TTT state) {
		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);
		System.out.println("Player " + who + " enter x pos: ");
		x = sc.nextInt(); //Reads User input
		System.out.println("Player " + who + " enter y pos: ");
		y = sc.nextInt(); //Reads User input
		state.setBoard(x, y);
		state.print_Board();
		return state;
	}
	
	public TTT ply(TTT state, int given_x, int given_y) {
	//	for (ArrayList<Integer> l : )
		state.setBoard(given_x, given_y);
		//state.print_Board();
		return state;
	}
	
	public ArrayList<int[]> max(TTT tictactoe) {
		//int[] move = new int[2];
		ArrayList<int[]> moves = new ArrayList<int[]>();
		for (int i=0; i<3; i++) {
			for (int j=0; j<3; j++) {
				if (tictactoe.getBoard()[i][j] != 'x' && tictactoe.getBoard()[i][j] != 'x') {
					int[] move = new int[2];
					move[0] = i;
					move[1] = j;
					moves.add(move);
					
				}
			}
		}
		return moves;
	}
	
	public ArrayList<int[]> min(TTT tictactoe) {
		ArrayList<int[]> moves = new ArrayList<int[]>();
		for (int i=0; i<3; i++) {
			for (int j=0; j<3; j++) {
				if (tictactoe.getBoard()[i][j] != 'x' && tictactoe.getBoard()[i][j] != 'x') {
					int[] move = new int[2];
					move[0] = i;
					move[1] = j;
					moves.add(move);
				}
			}
		}
		return moves;
	}
	

}
