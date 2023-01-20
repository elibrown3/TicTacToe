import java.util.ArrayList;


public class MiniMax extends Player {
	
	private static Player max = new Player('x');
	
	public MiniMax(char c) {
		super(c);
		
	}
	
	public static void play() {
		Game g = new Game();
		
		MiniMax x = new MiniMax('x');
		MiniMax o = new MiniMax('o');
		int[] temp = null;
		int[] temp2 = null;
		while(!(g.terminate_state(g))) {
			temp = x.minimax(g, g);
			x.ply(g, temp[0], temp[1]);
			g.print_Board();
			System.out.println("---------------");
			if(g.terminate_state(g)) {
				g.print_Board();
				break;
			}
			temp2 = o.minimax(g, g);
			o.ply(g, temp2[0], temp2[1]);
			g.print_Board();
			System.out.println("---------------");
		}
		g.determine_winner(g);
	}
	
	public static void play2() {
		Game g = new Game();
		MiniMax x = new MiniMax('x');
		Player o = new Player('o');
		int[] temp = null;
		while(!(g.terminate_state(g))) {
			temp = x.minimax(g, g);
			x.ply(g, temp[0], temp[1]);
			System.out.println("-----------");
			if(g.terminate_state(g)) {
				g.print_Board();
				break;
			}
			g.print_Board();
			System.out.println("------------");
			o.ply_manual(g);
		}
		System.out.println("-----------");
		g.determine_winner(g);
	}
	
	public int[] minimax(Game game, TTT s) {
		double value;
		Group g1 = max_value(game, s).copyGroup();
		Group g2 = min_value(game, s).copyGroup();
		int[] move = null;
		if (game.to_move(s).equals("max")) {
			value = g1.getUtility();
			move = g1.getAction();
		} else {
			value = g2.getUtility();
			move = g2.getAction();
		}
		System.out.println(value);
		return move;
	}
	
	public static Group max_value(Game game, TTT s) {
		Group group1 = new Group(0, null);
		if (game.terminate_state(s)) {
			group1.setUtility(game.utility(s, max));
			return group1;
		}
		double v = Double.NEGATIVE_INFINITY;
		int[] move = null;
		double v2 = 0;
		int[] a2;
		ArrayList<int[]> actions = game.actions(s);
		for (int[] a : actions) {
			TTT result_of_action_i = game.result(s, a);
			Group group2 = min_value(game, result_of_action_i);
			v2 = group2.getUtility();
			group1.setUtility(v2);
			a2 = group2.getAction();
			group1.setAction(a2);
			if (v2 > v) {
				v = v2;
				move = a;
			} 
		}
		group1.setAction(move);
		group1.setUtility(v);
		return group1;
	}
	
	public static Group min_value(Game game, TTT s) {
		Group group1 = new Group(0, null);
		if (game.terminate_state(s)) {
			group1.setUtility(game.utility(s, max));
			return group1;
		}
		double v = Double.POSITIVE_INFINITY;
		int[] move = null;
		double v2 = 0;
		int[] a2;
		ArrayList<int[]> actions = game.actions(s);
		for (int[] a : actions) {
			
			TTT temp1 = game.result(s, a);
			Group group2 = max_value(game, temp1);
			v2 = group2.getUtility();
			group1.setUtility(v2);
			a2 = group2.getAction();
			group1.setAction(a2);
			if (v2 < v) {
				v = v2;
				move = a;
			}
		}
		group1.setAction(move);
		group1.setUtility(v);
		return group1;
	}
	

}