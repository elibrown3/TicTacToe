
public class Group {
	private double utility;
	private int[] action;
	
	public Group(double utility, int[] action) {
		this.setUtility(utility);
		this.setAction(action);
	}

	public double getUtility() {
		return utility;
	}

	public void setUtility(double utility) {
		this.utility = utility;
	}

	public int[] getAction() {
		return action;
	}

	public void setAction(int[] action) {
		this.action = action;
	}
	
	public Group copyGroup() {
		Group g = new Group(getUtility(), getAction());
		return g;
		
	}
	

}
