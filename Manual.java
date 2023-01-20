
public class Manual extends TTT {

	private TTT tictactoe = new TTT();
	
	public Manual(TTT game) {
		tictactoe = game;
	}
	
	public void play() {
		Player one = new Player('x');
		Player two = new Player('o');
		while (!(determine_winner())) {
			one.ply_manual(tictactoe);
			if (determine_winner())
				break;
			two.ply_manual(tictactoe);
			if (determine_winner())
				break;
		}
		System.out.println(utility(one));
		System.out.println(utility(two));
	}
	
	public Integer utility(Player p) {
		String temp = tictactoe.toString();
		int count = 0;
		for (int i=0; i<temp.length(); i++) {
			if (temp.charAt(i) == p.get_who()) {
				count++;
			}
		}
		
		if (temp.charAt(0) == temp.charAt(1) && temp.charAt(0) == temp.charAt(2) && temp.charAt(0) == p.get_who()) {
			return 1;
		}
		else if (temp.charAt(3) == temp.charAt(4) && temp.charAt(5) == temp.charAt(3) && temp.charAt(3) == p.get_who()) {
			return 1;
		}
		else if (temp.charAt(6) == temp.charAt(7) && temp.charAt(8) == temp.charAt(6) && temp.charAt(6) == p.get_who()) { 
			return 1;
		}
		else if (temp.charAt(0) == temp.charAt(4) && temp.charAt(8) == temp.charAt(4) && temp.charAt(0) == p.get_who()) {
			return 1;
		}
		else if (temp.charAt(2) == temp.charAt(4) && temp.charAt(6) == temp.charAt(2) && temp.charAt(2) == p.get_who()) {
			return 1;
		}
		else if (temp.charAt(0) == temp.charAt(3) && temp.charAt(6) == temp.charAt(0) && temp.charAt(0) == p.get_who()) {
			return 1;
		}
		else if (temp.charAt(1) == temp.charAt(4) && temp.charAt(7) == temp.charAt(1) && temp.charAt(1) == p.get_who()) {
			return 1;
		}
		else if (temp.charAt(2) == temp.charAt(5) && temp.charAt(8) == temp.charAt(2) && temp.charAt(2) == p.get_who()) {
			return 1;
		}
		else if (count == 5 && p.get_who() == 'x') {
			return 0;
		} else if (count == 4 && p.get_who() == 'o')
			return 0; 
		else {
			return -1;
		}
	}
	
	
	public boolean determine_winner() {
		String temp = tictactoe.toString();
		
		if (temp.charAt(0) == temp.charAt(1) && temp.charAt(0) == temp.charAt(2) && temp.charAt(0) != '-') {
			System.out.println("Player " + temp.toUpperCase().charAt(0) + " wins!");
			return true;
		}
		else if (temp.charAt(3) == temp.charAt(4) && temp.charAt(5) == temp.charAt(3) && temp.charAt(3) != '-') {
			System.out.println("Player " + temp.toUpperCase().charAt(3) + " wins!");
			return true;
		}
		else if (temp.charAt(6) == temp.charAt(7) && temp.charAt(8) == temp.charAt(6) && temp.charAt(7) != '-') { 
			System.out.println("Player " + temp.toUpperCase().charAt(6) + " wins!");
			return true;
		}
		else if (temp.charAt(0) == temp.charAt(4) && temp.charAt(8) == temp.charAt(4) && temp.charAt(4) != '-') {
			System.out.println("Player " + temp.toUpperCase().charAt(0) + " wins!");
			return true;
		}
		else if (temp.charAt(2) == temp.charAt(4) && temp.charAt(6) == temp.charAt(2) && temp.charAt(4) != '-') {
			System.out.println("Player " + temp.toUpperCase().charAt(2) + " wins!");
			return true;
		}
		else if (temp.charAt(0) == temp.charAt(3) && temp.charAt(6) == temp.charAt(0) && temp.charAt(3) != '-') {
			System.out.println("Player " + temp.toUpperCase().charAt(0) + " wins!");
			return true;
		}
		else if (temp.charAt(1) == temp.charAt(4) && temp.charAt(7) == temp.charAt(1) && temp.charAt(4) != '-') {
			System.out.println("Player " + temp.toUpperCase().charAt(1) + " wins!");
			return true;
		}
		else if (temp.charAt(2) == temp.charAt(5) && temp.charAt(8) == temp.charAt(2) && temp.charAt(5) != '-') {
			System.out.println("Player " + temp.toUpperCase().charAt(2) + " wins!");
			return true;
		}
		else if (temp.contains("-")) {
			//System.out.println("Game not over!");
			return false;
		} else {
			System.out.println("Its a draw!");
			return true;
		}
	}

}
