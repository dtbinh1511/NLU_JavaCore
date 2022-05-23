package Task2_3;

public class ScoreBoard {
	public String name;
	public int classes;
	public IList iList;

	public ScoreBoard(String name, int classes, IList iList) {
		super();
		this.name = name;
		this.classes = classes;
		this.iList = iList;
	}

	@Override
	public String toString() {
		return "\n" + "NAME: " + this.name + "\n" + "CLASS: " + this.classes + "\n" + this.iList;
	}

	public int howManyCredits() {
		return this.iList.howManyCredits();
	}

	public double gradeAverage() {
		return this.iList.gradeAverage();
	}

	public boolean equals(Object obj) {
		if (obj == null || !(obj instanceof ScoreBoard))
			return false;
		else {
			ScoreBoard other = (ScoreBoard) obj;
			return this.name.equals(other.name) && this.classes == other.classes && this.iList.equals(other.iList);
		}
	}

	public IList sortByGradeDec() {
		return this.iList.sortByGradeDec();
	}

	public IList greaterThanList(double grade) {
		return this.iList.greaterThanList(grade);
	}
}
