import java.util.ArrayList;

public class Game extends TTT {
	
	public ArrayList<int[]> actions(TTT s) {
		ArrayList<int[]> moves = new ArrayList<int[]>();
		for (int i=0; i<3; i++) {
			for (int j=0; j<3; j++) {
				if (s.getBoard()[i][j] != 'x' && s.getBoard()[i][j] != 'o') {
					int[] move = new int[2];
					move[0] = j;
					move[1] = i;
					moves.add(move);
					
				}
			}
		}
		return moves;
	}
	
	public TTT result(TTT s, int[] a) {
		TTT copy = s.copy_Board();
		int x = a[0];
		int y = a[1];
		copy.setBoard(x, y);
		
		return copy;
	}
	
	public String to_move(TTT s) {
		String temp = s.toString();
		if ((!(temp.contains("x"))) && (!(temp.contains("o"))))
			return "max";
		int count_x=0;
		int count_o=0;
		for (int i=0; i<temp.length(); i++) {
			if (temp.charAt(i) == 'x')
				count_x++;
			else if(temp.charAt(i) == 'o')
				count_o++;		
		}
		if (count_x == count_o)
			return "max";
		else
			return "min";
	}
	
	public Double utility(TTT s, Player p) {
		String temp = s.toString();
		double utility = 0;
		int count_p=0;
		
		for (int i=0; i<3; i++) {
			for (int j=0; j<3; j++) {
				if (s.getBoard()[i][j] == p.get_who()) {
					count_p++;
				}
					
			}
		}
		
		if (temp.charAt(0) == temp.charAt(1) && temp.charAt(0) == temp.charAt(2) && temp.charAt(0) == p.get_who()) {
			utility++;
		}
		else if (temp.charAt(3) == temp.charAt(4) && temp.charAt(5) == temp.charAt(3) && temp.charAt(3) == p.get_who()) {
			utility++;
		}
		else if (temp.charAt(6) == temp.charAt(7) && temp.charAt(8) == temp.charAt(6) && temp.charAt(6) == p.get_who()) { 
			utility++;
		}
		else if (temp.charAt(0) == temp.charAt(4) && temp.charAt(8) == temp.charAt(4) && temp.charAt(0) == p.get_who()) {
			utility++;
		}
		else if (temp.charAt(2) == temp.charAt(4) && temp.charAt(6) == temp.charAt(2) && temp.charAt(2) == p.get_who()) {
			utility++;
		}
		else if (temp.charAt(0) == temp.charAt(3) && temp.charAt(6) == temp.charAt(0) && temp.charAt(0) == p.get_who()) {
			utility++;
		}
		else if (temp.charAt(1) == temp.charAt(4) && temp.charAt(7) == temp.charAt(1) && temp.charAt(1) == p.get_who()) {
			utility++;
		}
		else if (temp.charAt(2) == temp.charAt(5) && temp.charAt(8) == temp.charAt(2) && temp.charAt(2) == p.get_who()) {
			utility++;
		}
		else if (count_p == 5 && p.get_who() == 'x') {
			utility=0;
		} else if (count_p == 4 && p.get_who() == 'o') {
			utility = 0;
		} else {
			utility--;
		}
		return utility;
	}
	
	
	public boolean terminate_state(TTT s) {
		String temp = s.toString();
		
		if (temp.charAt(0) == temp.charAt(1) && temp.charAt(0) == temp.charAt(2) && temp.charAt(0) != '-') {
			//System.out.println("Player " + temp.toUpperCase().charAt(0) + " wins!");
			return true;
		}
		else if (temp.charAt(3) == temp.charAt(4) && temp.charAt(5) == temp.charAt(3) && temp.charAt(3) != '-') {
			//System.out.println("Player " + temp.toUpperCase().charAt(3) + " wins!");
			return true;
		}
		else if (temp.charAt(6) == temp.charAt(7) && temp.charAt(8) == temp.charAt(6) && temp.charAt(7) != '-') { 
			//System.out.println("Player " + temp.toUpperCase().charAt(6) + " wins!");
			return true;
		}
		else if (temp.charAt(0) == temp.charAt(4) && temp.charAt(8) == temp.charAt(4) && temp.charAt(4) != '-') {
			//System.out.println("Player " + temp.toUpperCase().charAt(0) + " wins!");
			return true;
		}
		else if (temp.charAt(2) == temp.charAt(4) && temp.charAt(6) == temp.charAt(2) && temp.charAt(4) != '-') {
			//System.out.println("Player " + temp.toUpperCase().charAt(2) + " wins!");
			return true;
		}
		else if (temp.charAt(0) == temp.charAt(3) && temp.charAt(6) == temp.charAt(0) && temp.charAt(3) != '-') {
			//System.out.println("Player " + temp.toUpperCase().charAt(0) + " wins!");
			return true;
		}
		else if (temp.charAt(1) == temp.charAt(4) && temp.charAt(7) == temp.charAt(1) && temp.charAt(4) != '-') {
			//System.out.println("Player " + temp.toUpperCase().charAt(1) + " wins!");
			return true;
		}
		else if (temp.charAt(2) == temp.charAt(5) && temp.charAt(8) == temp.charAt(2) && temp.charAt(5) != '-') {
			//System.out.println("Player " + temp.toUpperCase().charAt(2) + " wins!");
			return true;
		}
		else if (!(temp.contains("-"))) {
			//System.out.println("Its a draw!");
			return true;
		} else {
			//System.out.println("Game not over!");
			return false;
		}
	}
	
	public void determine_winner(TTT s) {
		String temp = s.toString();
		
		if (temp.charAt(0) == temp.charAt(1) && temp.charAt(0) == temp.charAt(2) && temp.charAt(0) != '-') {
			System.out.println("Player " + temp.toUpperCase().charAt(0) + " wins!");
			//return true;
		}
		else if (temp.charAt(3) == temp.charAt(4) && temp.charAt(5) == temp.charAt(3) && temp.charAt(3) != '-') {
			System.out.println("Player " + temp.toUpperCase().charAt(3) + " wins!");
			//return true;
		}
		else if (temp.charAt(6) == temp.charAt(7) && temp.charAt(8) == temp.charAt(6) && temp.charAt(7) != '-') { 
			System.out.println("Player " + temp.toUpperCase().charAt(6) + " wins!");
			//return true;
		}
		else if (temp.charAt(0) == temp.charAt(4) && temp.charAt(8) == temp.charAt(4) && temp.charAt(4) != '-') {
			System.out.println("Player " + temp.toUpperCase().charAt(0) + " wins!");
			//return true;
		}
		else if (temp.charAt(2) == temp.charAt(4) && temp.charAt(6) == temp.charAt(2) && temp.charAt(4) != '-') {
			System.out.println("Player " + temp.toUpperCase().charAt(2) + " wins!");
			//return true;
		}
		else if (temp.charAt(0) == temp.charAt(3) && temp.charAt(6) == temp.charAt(0) && temp.charAt(3) != '-') {
			System.out.println("Player " + temp.toUpperCase().charAt(0) + " wins!");
			//return true;
		}
		else if (temp.charAt(1) == temp.charAt(4) && temp.charAt(7) == temp.charAt(1) && temp.charAt(4) != '-') {
			System.out.println("Player " + temp.toUpperCase().charAt(1) + " wins!");
			//return true;
		}
		else if (temp.charAt(2) == temp.charAt(5) && temp.charAt(8) == temp.charAt(2) && temp.charAt(5) != '-') {
			System.out.println("Player " + temp.toUpperCase().charAt(2) + " wins!");
			//return true;
		}
		else if (!(temp.contains("-"))) {
			System.out.println("Its a draw!");
			//return true;
		} else {
			System.out.println("Game not over!");
			//return false;
		}
	}
	

}
