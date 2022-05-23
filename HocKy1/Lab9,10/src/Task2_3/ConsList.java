package Task2_3;

public class ConsList implements IList {
	public GradeRecord first;
	public IList rest;

	public ConsList(GradeRecord first, IList rest) {
		super();
		this.first = first;
		this.rest = rest;
	}

	@Override
	public String toString() {
		return this.first.toString() + this.rest.toString();
	}

	public int howManyCredits() {
		return this.first.getCredits() + this.rest.howManyCredits();
	}

	public double totalGrade() {
		return this.first.grade + this.rest.totalGrade();

	}

	@Override
	public double gradeAverage() {
		return this.totalGrade() / this.howManyCredits();
	}

	public boolean equals(Object obj) {
		if (obj == null || !(obj instanceof ConsList))
			return false;
		else {
			ConsList other = (ConsList) obj;
			return this.first.equals(other.first) && this.rest.equals(other.rest);
		}
	}

	@Override
	public IList sortByGradeDec() {
		return this.rest.sortByGradeDec().insertByGradeDec(first);
	}

	@Override
	public IList insertByGradeDec(GradeRecord that) {
		if (this.first.biggerThan(that))
			return new ConsList(first, this.rest.insertByGradeDec(that));
		return new ConsList(that, new ConsList(first, rest));
	}

	@Override
	public IList greaterThanList(double grade) {
		if (this.first.biggerThanGrade(grade))
			return new ConsList(first, rest.greaterThanList(grade));
		return this.rest.greaterThanList(grade);
	}

}
