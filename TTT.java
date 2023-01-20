
public class TTT {
	private char[][] board = new char[][]{{'-', '-', '-'}, {'-', '-', '-'}, {'-', '-', '-'}};
	
	public TTT() {

	}
	
	public char[][] getBoard() {
		return board;
	}
	
	public void setBoard(int x, int y) {
		int count_x=0;
		int count_o=0;
		String temp = toString();
		for (int i=0; i<temp.length(); i++) {
			if (temp.charAt(i) == 'x')
				count_x++;
			else if(temp.charAt(i) == 'o')
				count_o++;		
		}
		if (count_x == count_o)
			board[y][x] = 'x';
		else
			board[y][x] = 'o';
	}
	
	public TTT copy_Board() {
		TTT copy = new TTT();
		for (int i=0; i<3; i++) {
				for (int j=0; j<3; j++) {
						copy.board[i][j] = board[i][j];
					}
				}
		return copy;
	}
	
	public void print_Board() {
		String l = toString();
		for (int i=0; i<l.length(); i++) {
				System.out.print(l.charAt(i) + " | ");
				if (i>0) {
					if((i+1)%3==0) {
						System.out.println();
						System.out.println();
					}
				}
		}
	}
	
	public String toString() {
		String sboard = "";
		for (int i=0; i<3; i++) {
			for (int j=0; j<3; j++) {
				sboard += board[i][j];
			}
		}
		//System.out.println("Test: " + board);
		return sboard;
	}
	

}
