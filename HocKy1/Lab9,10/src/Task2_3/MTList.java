package Task2_3;

public class MTList implements IList {

	@Override
	public String toString() {
		return "";
	}

	public int howManyCredits() {
		return 0;
	}

	public double totalGrade() {
		return 0.0;
	}

	@Override
	public double gradeAverage() {
		return 0.0;
	}

	public boolean equals(Object obj) {
		if (obj == null || !(obj instanceof MTList))
			return false;
		return true;
	}

	@Override
	public IList sortByGradeDec() {
		return new MTList();
	}

	@Override
	public IList insertByGradeDec(GradeRecord that) {
		return new ConsList(that, new MTList());
	}

	@Override
	public IList greaterThanList(double grade) {
		return new MTList();
	}

}
