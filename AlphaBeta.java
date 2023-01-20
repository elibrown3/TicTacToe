import java.util.ArrayList;

public class AlphaBeta extends Player {
	
	private static Player max = new Player('x');
	private static Player min = new Player('o');
	
	public AlphaBeta(char c) {
		super(c);
	}
	
	public static void play() {
		Game g = new Game();
		AlphaBeta x = new AlphaBeta('x');
		AlphaBeta o = new AlphaBeta('o');
		int[] temp = null;
		int[] temp2 = null;
		while(!(g.terminate_state(g))) {
			temp = x.alphabeta(g, g);
			x.ply(g, temp[0], temp[1]);
			g.print_Board();
			System.out.println("---------------");
			if(g.terminate_state(g)) {
				g.print_Board();
				break;
			}
			temp2 = o.alphabeta(g, g);
			o.ply(g, temp2[0], temp2[1]);
			g.print_Board();
			System.out.println("---------------");
		}
		g.determine_winner(g);
	}
	
	public static void play2() {
		Game g = new Game();
		AlphaBeta x = new AlphaBeta('x');
		Player o = new Player('o');
		int[] temp = null;
		while(!(g.terminate_state(g))) {
			temp = x.alphabeta(g, g);
			x.ply(g, temp[0], temp[1]);
			System.out.println("---------------");
			if(g.terminate_state(g)) {
				g.print_Board();
				break;
			}
			g.print_Board();
			System.out.println("---------------");
			o.ply_manual(g);
		}
		g.determine_winner(g);
	}
	
	public int[] alphabeta(Game game, TTT s) {
		double value;
		int[] move = null;
		double infinity = Double.POSITIVE_INFINITY;
		double negative_infinity = Double.NEGATIVE_INFINITY;
		if (game.to_move(s).equals("max")) {
			value = max_value(game, s, negative_infinity, infinity).getUtility();
			move = max_value(game, s, negative_infinity, infinity).getAction();
		} else {
			value = min_value(game, s, negative_infinity, infinity).getUtility();
			move = min_value(game, s, negative_infinity, infinity).getAction();
		}
		return move;
	}
	
	public static Group max_value(Game game, TTT s, double alpha, double beta) {
		Group group1 = new Group(game.utility(s, max), null);
		if (game.terminate_state(s)) {
			return group1;
		}
		double v = Double.NEGATIVE_INFINITY;
		int[] move = null;
		double v2 = 0;
		int[] a2;
		ArrayList<int[]> actions = game.actions(s);
		for (int[] a : actions) {
			TTT result_of_action_i = game.result(s, a);
			Group group2 = min_value(game, result_of_action_i, alpha, beta);
			v2 = group2.getUtility();
			group1.setUtility(v2);
			a2 = group2.getAction();
			group1.setAction(a2);
			if (v2 > v) {
				v = v2;
				move = a;
				if (v > alpha) {
					alpha = v;
				}
			}
			if (v >= beta) {
				group1.setAction(move);
				group1.setUtility(v);
				return group1;
			}
		}
		group1.setAction(move);
		group1.setUtility(v);
		return group1;
	}
	
	public static Group min_value(Game game, TTT t, double alpha, double beta) {
		Group group1 = new Group(game.utility(t, max), null);
		if (game.terminate_state(t)) {
			return group1;
		}
		double v = Double.POSITIVE_INFINITY;
		int[] move = null;
		double v2 = 0;
		int[] a2;
		ArrayList<int[]> actions = game.actions(t);
		for (int[] a : actions) {
			TTT temp1 = game.result(t, a);
			Group group2 = max_value(game, temp1, alpha, beta);
			v2 = group2.getUtility();
			group1.setUtility(v2);
			a2 = group2.getAction();
			group1.setAction(a2);
			
			if (v2 < v) {
				v = v2;
				move = a;
				if (v < beta) {
					beta = v;
				}
			}
			if (v <= alpha) {
				group1.setAction(move);
				group1.setUtility(v);
				return group1;
			}
		}
		group1.setAction(move);
		group1.setUtility(v);
		return group1;
	}
	

}
