package Sweepstakes;

public class Customer {
	private String fullname;
	private int score;
	private String superMarketID;

	public Customer(String fullname, int score, String superMarketID) {
		super();
		this.fullname = fullname;
		this.score = score;
		this.superMarketID = superMarketID;
	}

	public String getFullname() {
		return fullname;
	}

	public void setFullname(String fullname) {
		this.fullname = fullname;
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}

	public String getSuperMarketID() {
		return superMarketID;
	}

	public void setSuperMarketID(String superMarketID) {
		this.superMarketID = superMarketID;
	}

	@Override
	public String toString() {
		return  fullname  +"\t\t"+ score +"\t\t"  + superMarketID ;
	}

}
